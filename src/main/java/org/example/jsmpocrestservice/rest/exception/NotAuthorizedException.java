package org.example.jsmpocrestservice.rest.exception;


public class NotAuthorizedException extends RuntimeException {

    public NotAuthorizedException(String msg) {
        super(msg);
    }

}
