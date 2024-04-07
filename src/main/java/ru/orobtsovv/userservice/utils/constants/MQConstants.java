package ru.orobtsovv.userservice.utils.constants;

public class MQConstants {
    public static final String PROFILE_CREATE = "profile-create-queue";
    public static final String TELEGRAM_SAVE = "telegram-propagate-queue";
    public static final String TELEGRAM_REMOVE = "telegram-remove-queue";
    public static final String PROFILE_DELETE_AUTH = "profile-delete-auth-queue";
    public static final String PROFILE_DELETE_AUD = "profile-delete-auth-queue";
    public static final String PROFILE_DELETE_NOTIFICATIONS = "profile-delete-auth-queue";
    public static final String FRIEND_LINK_DELETED = "friend-link-delete-queue";
}
