package com.yan.entity.core;

public class CarPark implements DrivingMap {
    private int length;
    private int width;
    private int[][] drivingMap;  // 1为可行使，0为不可行驶（如该位置有障碍物）

    public CarPark(int length,int width) {
        this.length = length;
        this.width = width;
        initDrivingMap();
    }

    private void initDrivingMap(){
        drivingMap = new int[length][width];
        // 标记哪些位置可行驶，哪些不可行驶（目前位置都可行驶）
        for(int i = 0; i < length; i++){
            for(int j = 0; j < width; j++)
                drivingMap[i][j] = 1;
        }
    }

    @Override
    public int[][] getDrivingMap() {
        return drivingMap;
    }

    @Override
    public boolean canDrive(Position target) {
        if(target.getPositionX() >= length || target.getPositionX() < 0
            || target.getPositionY() >= width || target.getPositionY() < 0
            || drivingMap[target.getPositionX()][target.getPositionY()] == 0)
            return false;
        return true;
    }
    
    @Override
    public boolean markUnableDrivePoint(Position unable){
        // 更新不可行驶的位置
        if(canDrive(unable))
            drivingMap[unable.getPositionX()][unable.getPositionY()] = 0;
        return true;
    }

    @Override
    public String toString() {
        return "{" +
            " length='" + length + "'" +
            ", width='" + width + "'" +
            "}";
    }

}