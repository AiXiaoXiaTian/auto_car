package com.yan.entity.command;

import com.yan.entity.core.*;
import com.yan.exceptions.MoveOutRangeException;

public class MoveCommand implements Command {
    private final String commandType = "move";
    private DrivingMap drivingMap;
    private Position target;
    private int distance;
    private String record;

    public MoveCommand(int distance) {
        this.distance = distance;
        target = Car.Instance.getPosition().copy();
        switch(Car.Instance.getOrientation()){
            case East:
                target.setPosition(target.getPositionX() + distance, target.getPositionY());
                break;
            case South:
                target.setPosition(target.getPositionX(), target.getPositionY() - distance);
                break;
            case West:
                target.setPosition(target.getPositionX() - distance, target.getPositionY());
                break;
            case North:
                target.setPosition(target.getPositionX(), target.getPositionY() + distance);
                break;
        }
        record = "orientation:" + Car.Instance.getOrientation().toString() + ",distance:" + String.valueOf(distance)
            + ", old position:" + Car.Instance.getPosition().toString()
            + ", target position:" + target.toString();
    }

    public void setDrivingMap(DrivingMap drivingMap){
        this.drivingMap = drivingMap;
    }

    @Override
    public String getCommandRecord() {
        return record;
    }

    @Override
    public void execute() {
        if(drivingMap == null || distance == 0) throw new IllegalArgumentException("args is error");

        if(drivingMap.canDrive(target)){
            Car.Instance.setTargetPostition(target);
        }else{
            throw new MoveOutRangeException("the target position is unreachable,"
                + "old position:" + Car.Instance.getPosition().toString()
                + "target position:" + target.toString());
        }
    }

    @Override
    public String getCommandType() {
        return commandType;
    }
}