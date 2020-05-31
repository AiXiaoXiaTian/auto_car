package com.yan.entity.command;

public interface Command {
    String getCommandType();
    String getCommandRecord();
    void execute();
}