package com.yan.entity.core;

public class Car {
    private int id; // 每个客户端（车辆）都有一个唯一标识，并应保证无法被篡改
    private Position position; // 车当前位置
    private Orientation orientation; // 车当前方向

    public int getId() {
        return this.id;
    }

    public Position getPosition() {
        return this.position;
    }

    public void setPosition(int x,int y){
        position.setPosition(x, y);
    }

    public void setTargetPostition(Position target){
        position.setPosition(target.getPositionX(), target.getPositionY());
    }

    public Orientation getOrientation() {
        return this.orientation;
    }

    public void setOrientation(Orientation orientation){
        this.orientation = orientation;
    }

    // 单例模式，客户端只能有一个car类实例
    // 饿汉式单例模式，客户端初始化时就应加载，若采用延迟加载会造成首次用户触发命令时卡顿
    // 客户端系统关闭时（如遇到电量完全耗尽的情况），此单例应从客户端H2数据库或者文件中加载
    private Car() {
    }

    public static Car Instance = getCarInstance();

    private static Car getCarInstance() { // 客户端唯一，暂不考虑并发安全性
        if(Instance != null) return Instance;

        Car instance = tryLoadCarInstane();
        if (instance == null) {
            instance = new Car();
            instance.position = new Position();
        }
        return instance;
    }

    private static Car tryLoadCarInstane() {
        // TODO unrealized
        return null; // 尝试从H2数据库或文件中加载实例
    }

    public static void Clear(){
        // 关机
    }
}