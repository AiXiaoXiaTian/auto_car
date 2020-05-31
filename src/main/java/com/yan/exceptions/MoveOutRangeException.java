package com.yan.exceptions;

public class MoveOutRangeException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public MoveOutRangeException(String message) {
        super(message);
    }
}