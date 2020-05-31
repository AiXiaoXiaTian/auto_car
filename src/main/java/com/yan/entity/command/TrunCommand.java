package com.yan.entity.command;

import com.yan.entity.core.Car;
import com.yan.entity.core.Orientation;

public class TrunCommand implements Command {
    private final String commandType = "trun";
    private String record;
    private Orientation orientation;

    public TrunCommand(Orientation orientation) {
        this.orientation = orientation;
        record = "before orientation:" + Car.Instance.getOrientation().toString() + ",after orientation:" + orientation.toString();
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
        Car.Instance.setOrientation(orientation);
    }
    
}