package com.yan.service;

import com.yan.entity.command.*;
import com.yan.entity.core.*;
import com.yan.entity.record.*;
import com.yan.exceptions.MoveOutRangeException;

public class CommandExecutor {
    public boolean start(int x, int y, Orientation orientation) {
        try {
            // 命令初始化
            StartCommand startCommand = new StartCommand(x, y, orientation);
            // 执行命令
            startCommand.execute();
            // 打印命令日志
            Record startRecord = new RecordBuilderImpl(startCommand).build();
            System.out.println(startRecord);
            // 保存命令日志
            RecordService.addRecord(startRecord);

            return true;
        } catch(MoveOutRangeException e){
            throw e;
        } catch (Exception e) {
            return false;
        } finally {

        }
    }

    public boolean stop() {
        try {
            // 命令初始化
            StopCommand stopCommand = new StopCommand();
            // 执行命令
            stopCommand.execute();
            // 打印命令日志
            Record stopRecord = new RecordBuilderImpl(stopCommand).build();
            System.out.println(stopRecord);
            // 保存命令日志
            RecordService.addRecord(stopRecord);

            return true;
        } catch(MoveOutRangeException e){
            throw e;
        } catch (Exception e) {
            return false;
        } finally {

        }
    }

    public boolean move(int distance) {
        try {
            // 命令初始化
            MoveCommand moveCommand = new MoveCommand(distance);
            moveCommand.setDrivingMap(DrivingMapService.getDrivingMap());
            // 执行命令
            moveCommand.execute();
            // 打印命令日志
            Record record = new RecordBuilderImpl(moveCommand).build();
            System.out.println(record);
            // 保存命令日志
            RecordService.addRecord(record);

            return true;
        } catch(MoveOutRangeException e){
            throw e;
        } catch (Exception e) {
            return false;
        } finally {

        }
    }

    public boolean move(Orientation orientation, int distance) {
        try {
            // 命令初始化并执行
            TrunCommand trunCommand = new TrunCommand(orientation);
            trunCommand.execute();
            MoveCommand moveCommand = new MoveCommand(distance);
            moveCommand.setDrivingMap(DrivingMapService.getDrivingMap());
            moveCommand.execute();
            // 打印命令日志
            Record trunRecord = new RecordBuilderImpl(trunCommand).build();
            Record moveRecord = new RecordBuilderImpl(moveCommand).build();
            System.out.println(moveRecord);
            // 保存移动命令日志
            RecordService.addRecord(trunRecord);
            RecordService.addRecord(moveRecord);
            return true;
        } catch(MoveOutRangeException e){
            throw e;
        } catch (Exception e) {
            return false;
        } finally {

        }
    }

    public boolean trun(Orientation orientation) {
        try {
            // 命令初始化
            TrunCommand trunCommand = new TrunCommand(orientation);
            // 执行命令
            trunCommand.execute();
            // 打印命令日志
            Record record = new RecordBuilderImpl(trunCommand).build();
            System.out.println(record);
            // 保存命令日志
            RecordService.addRecord(record);
            return true;
        } catch(MoveOutRangeException e){
            throw e;
        } catch (Exception e) {
            return false;
        } finally {

        }
    }
}