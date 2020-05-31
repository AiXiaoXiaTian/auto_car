package com.yan.entity.record;

import com.yan.entity.command.*;

public class RecordBuilderImpl implements RecordBuilder {

    private Command command;

    public RecordBuilderImpl(Command command) {
        this.command = command;
    }
    
    @Override
    public Command getCommand(){
        return command;
    }

    @Override
    public Record build() {
        if(command == null)
            throw new IllegalArgumentException("drivingCommand is not set");
        return new RecordImpl(this);
    }
    
}