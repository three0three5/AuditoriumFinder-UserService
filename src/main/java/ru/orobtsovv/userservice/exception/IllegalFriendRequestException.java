package ru.orobtsovv.userservice.exception;

import static ru.orobtsovv.userservice.utils.constants.ExceptionConstants.ILLEGAL_FRIEND_REQUEST;

public class IllegalFriendRequestException extends RuntimeException {
    public IllegalFriendRequestException() {
        super(ILLEGAL_FRIEND_REQUEST);
    }
}
