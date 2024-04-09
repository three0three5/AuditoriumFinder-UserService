package ru.orobtsovv.userservice.utils.constants;

public class MQConstants {
    public static final String PROFILE_CREATE = "profile-create-queue"; // auth->user
    public static final String TELEGRAM_SAVE = "telegram-propagate-queue"; // auth->user
    public static final String TELEGRAM_REMOVE = "telegram-remove-queue"; // auth->user
    public static final String PROFILE_DELETE_AUTH = "profile-delete-auth-queue"; // user->auth
    public static final String PROFILE_DELETE_AUD = "profile-delete-aud-queue"; // user->aud
    public static final String PROFILE_DELETE_NOTIFICATIONS = "profile-delete-notifications-queue"; // user->notif
    public static final String PROFILE_UPDATE = "profile-update-notifications-queue"; // user->notif
    public static final String FRIEND_LINK_DELETED = "friend-link-delete-queue"; // user->notif
    public static final String FRIEND_REQUEST_ACCEPTED = "friend-request-accepted-queue"; //user->notif
    public static final String FRIEND_REQUEST_RECEIVED = "friend-request-received-queue"; //user->notif
}
