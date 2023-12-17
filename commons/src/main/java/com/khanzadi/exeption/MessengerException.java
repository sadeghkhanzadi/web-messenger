package com.khanzadi.exeption;

public class MessengerException extends Exception{
    public MessengerException() {
    }

    public MessengerException(String message) {
        super(message);
    }

    public MessengerException(String message, Throwable cause) {
        super(message, cause);
    }

    public MessengerException(Throwable cause) {
        super(cause);
    }

    public MessengerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
