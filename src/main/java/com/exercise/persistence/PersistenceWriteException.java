package com.exercise.persistence;

public class PersistenceWriteException extends Exception {

    public PersistenceWriteException(String message) {
        super(message);
    }

    public PersistenceWriteException(String message, Throwable cause) {
        super(message, cause);
    }
}
