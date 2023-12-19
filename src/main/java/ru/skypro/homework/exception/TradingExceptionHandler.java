package ru.skypro.homework.exception;

public class TradingExceptionHandler extends RuntimeException {
    public TradingExceptionHandler() {
    }

    public TradingExceptionHandler(String message) {
        super(message);
    }

    public TradingExceptionHandler(String message, Throwable cause) {
        super(message, cause);
    }

    public TradingExceptionHandler(Throwable cause) {
        super(cause);
    }

    public TradingExceptionHandler(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
