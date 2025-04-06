package com.jcruz.reslerianadb.common.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException() {
        super();
    }

    public NotFoundException(String resourceType, int id) {
        super(String.format("Resource %s with id %d not found", resourceType, id));
    }

    public NotFoundException(Throwable cause) {
        super(cause);
    }

    public NotFoundException(String msg, Throwable cause) {
        super(msg, cause);
    }

}