package com.yan.service;

import com.yan.entity.core.DrivingMap;

/**
 * 装载当前地图(一个客户端同一时间只能有一张地图),考虑安全性不应对外公开,地图更新应由一独立后台线程实时更新(暂未开发)
 */
public class DrivingMapService {
    private static DrivingMap drivingMap;

    public static void setDrivingMap(DrivingMap _drivingMap){
        drivingMap = _drivingMap;
    }

    public static DrivingMap getDrivingMap(){
        return drivingMap;
    }
}