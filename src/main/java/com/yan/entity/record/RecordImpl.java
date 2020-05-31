package com.yan.entity.record;

import java.time.LocalDateTime;

/**
 * 行车记录日志，应异步记录
 */
public class RecordImpl implements Record {
    private static int id;  // 自增日志编号，生产环境应保存在h2数据库中
    private String recordType;
    private String record;
    private String recordMsg;  // 完整日志信息
    private LocalDateTime recordTime = LocalDateTime.now();  // 记录时间

    static {
        id = 0;
    }

    public RecordImpl(RecordBuilder builder) {
        id = id++;
        recordType = builder.getCommand().getCommandType();
        record = builder.getCommand().getCommandRecord();
        recordMsg = createRecordMsg();
    }

    public String createRecordMsg() {
        return "{" +
            " id='" + id + "'" +
            ", commandType='" + recordType + "'" +
            ", recordTime='" + recordTime + "'" +
            ", record='" + record + "'" +
            "}";
    }

    @Override
    public String toString() {
        return recordMsg;
    }
}