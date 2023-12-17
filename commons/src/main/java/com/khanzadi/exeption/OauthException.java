package com.khanzadi.exeption;

public class OauthException extends Exception{

    public OauthException() {
    }

    public OauthException(String message) {
        super(message);
    }

    public OauthException(String message, Throwable cause) {
        super(message, cause);
    }

    public OauthException(Throwable cause) {
        super(cause);
    }

    public OauthException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
