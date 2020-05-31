package com.yan.entity.command;

import com.yan.entity.core.Car;
import com.yan.entity.core.Orientation;

public class StartCommand implements Command {
    private final String commandType = "start";
    private String record;
    private int positionX;
    private int positionY;
    private Orientation orientation;

    public StartCommand(int x,int y, Orientation orientation) {
        this.positionX = x;
        this.positionY = y;
        this.orientation = orientation;
        record = "car start in ("+String.valueOf(x)+","+String.valueOf(y)+"), orientation: "+ orientation.toString();
    }

    @Override
    public String getCommandType() {
        return commandType;
    }

    @Override
    public String getCommandRecord() {
        return record;
    }

    @Override
    public void execute() {
        Car.Instance.setPosition(positionX, positionY);
        Car.Instance.setOrientation(orientation);
    }
    
}