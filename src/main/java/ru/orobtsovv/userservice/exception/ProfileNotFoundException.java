package ru.orobtsovv.userservice.exception;

import static ru.orobtsovv.userservice.utils.constants.ExceptionConstants.PROFILE_NOT_FOUND_MESSAGE;

public class ProfileNotFoundException extends NotFoundException {
    public ProfileNotFoundException(String message) {
        super(message);
    }

    public ProfileNotFoundException() {
        this(PROFILE_NOT_FOUND_MESSAGE);
    }
}
