package ru.orobtsovv.userservice.exception;

import static ru.orobtsovv.userservice.utils.constants.ExceptionConstants.FRIENDS_ALREADY;
import static ru.orobtsovv.userservice.utils.constants.ExceptionConstants.REQUEST_EXISTS;

public class RequestAlreadyException extends RuntimeException {
    public RequestAlreadyException() {
        super(REQUEST_EXISTS);
    }
}
