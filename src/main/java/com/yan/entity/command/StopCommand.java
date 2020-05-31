package com.yan.entity.command;

import com.yan.entity.core.Car;

public class StopCommand implements Command {
    private final String commandType = "start";
    private String record;

    public StopCommand() {
        record = "car start in "+ Car.Instance.getPosition().toString() +", orientation: "+ Car.Instance.getOrientation().toString();
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
        // 停止
        Car.Clear();
    }
}