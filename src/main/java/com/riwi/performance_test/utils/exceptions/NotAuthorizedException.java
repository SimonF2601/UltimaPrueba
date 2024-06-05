package com.riwi.performance_test.utils.exceptions;

public class NotAuthorizedException extends RuntimeException {
    public NotAuthorizedException(String id) {
        super(id);
    }
}
