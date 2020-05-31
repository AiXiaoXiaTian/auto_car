package com.yan.entity.core;

public interface DrivingMap {
    int[][] getDrivingMap();
    boolean canDrive(Position target);
    boolean markUnableDrivePoint(Position unable);
}