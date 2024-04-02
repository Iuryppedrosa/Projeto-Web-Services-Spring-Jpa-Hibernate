package com.projetowebspring.course.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(Object message) {
        super("Resource not found.Id" + message);
    }

}
