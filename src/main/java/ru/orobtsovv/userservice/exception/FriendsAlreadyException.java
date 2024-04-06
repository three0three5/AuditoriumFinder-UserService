package ru.orobtsovv.userservice.exception;

import static ru.orobtsovv.userservice.utils.constants.ExceptionConstants.FRIENDS_ALREADY;

public class FriendsAlreadyException extends RuntimeException {
    public FriendsAlreadyException() {
        super(FRIENDS_ALREADY);
    }
}
