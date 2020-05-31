package com.yan.service;

import java.util.LinkedList;
import java.util.List;

import com.yan.entity.record.Record;

public class RecordService {
    private static List<Record> records = new LinkedList<>();

    public static void addRecord(Record record){
        records.add(record);
    }
    
    public static void pringRecords() {
        for (Record record : records) {
            System.out.println(record.toString());
        }
    }

}