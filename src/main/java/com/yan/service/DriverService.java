package com.yan.service;

import com.yan.entity.core.*;

public class DriverService {
    private CommandExecutor commandExecutor = new CommandExecutor();

    public void setDrivingMap(DrivingMap _drivingMap) {
        DrivingMapService.setDrivingMap(_drivingMap);
    }

    public DrivingMap getDrivingMap() {
        return DrivingMapService.getDrivingMap();
    }

    public void pringRecords() {
        RecordService.pringRecords();
    }

    public boolean start(int x, int y, Orientation orientation,DrivingMap drivingMap) {
        setDrivingMap(drivingMap);
        return commandExecutor.start(x, y, orientation);
    }

    public boolean stop() {
        return commandExecutor.stop();
    }

    public Position move(int distance) {
        commandExecutor.move(distance);
        return Car.Instance.getPosition();
    }

    public Position move(Orientation orientation, int distance) {
        commandExecutor.move(orientation, distance);
        return Car.Instance.getPosition();
    }

    public Orientation trun(Orientation orientation) {
        commandExecutor.trun(orientation);
        return Car.Instance.getOrientation();
    }
    
}