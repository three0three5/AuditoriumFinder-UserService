package ru.orobtsovv.userservice.exception;

import static ru.orobtsovv.userservice.utils.constants.ExceptionConstants.NOT_FOUND_MESSAGE;

public class RequestNotFoundException extends NotFoundException {
    public RequestNotFoundException(String message) {
        super(message);
    }

    public RequestNotFoundException() {
        this(NOT_FOUND_MESSAGE);
    }
}
