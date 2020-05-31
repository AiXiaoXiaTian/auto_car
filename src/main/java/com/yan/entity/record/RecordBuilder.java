package com.yan.entity.record;

import com.yan.entity.command.*;

public interface RecordBuilder {
    Command getCommand();
    Record build();
}