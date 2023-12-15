package com.khanzadi.exeption;

public class MessengerExp extends Exception{
    public MessengerExp() {
    }

    public MessengerExp(String message) {
        super(message);
    }

    public MessengerExp(String message, Throwable cause) {
        super(message, cause);
    }

    public MessengerExp(Throwable cause) {
        super(cause);
    }

    public MessengerExp(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
