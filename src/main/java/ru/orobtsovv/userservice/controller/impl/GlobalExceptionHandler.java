package ru.orobtsovv.userservice.controller.impl;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.orobtsovv.userservice.dto.response.ShortMessageResponse;
import ru.orobtsovv.userservice.exception.FriendsAlreadyException;
import ru.orobtsovv.userservice.exception.IllegalFriendRequestException;
import ru.orobtsovv.userservice.exception.NotFoundException;
import ru.orobtsovv.userservice.exception.RequestAlreadyException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ShortMessageResponse notFoundHandler(NotFoundException e) {
        return new ShortMessageResponse(e.getMessage());
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ShortMessageResponse constraintViolationHandler(DataIntegrityViolationException e) {
        return new ShortMessageResponse(e.getMessage());
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(FriendsAlreadyException.class)
    public ShortMessageResponse alreadyFriendException(FriendsAlreadyException e) {
        return new ShortMessageResponse(e.getMessage());
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(RequestAlreadyException.class)
    public ShortMessageResponse alreadyRequestException(RequestAlreadyException e) {
        return new ShortMessageResponse(e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalFriendRequestException.class)
    public ShortMessageResponse alreadyRequestException(IllegalFriendRequestException e) {
        return new ShortMessageResponse(e.getMessage());
    }
}
