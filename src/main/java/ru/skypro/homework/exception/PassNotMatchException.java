package ru.skypro.homework.exception;

public class PassNotMatchException extends RuntimeException {
    public PassNotMatchException(String mismatch) {
        super(mismatch);
    }
    public PassNotMatchException(String mismatch, Throwable cause) {
        super(mismatch, cause);
    }

    public PassNotMatchException(Throwable cause) {
        super(cause);
    }

    public PassNotMatchException(String mismatch, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(mismatch, cause, enableSuppression, writableStackTrace);
    }
}
