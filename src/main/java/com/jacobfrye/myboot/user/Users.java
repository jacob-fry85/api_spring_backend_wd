package com.jacobfrye.myboot.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.UUID;

public class Users {
    private static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();
    public static final String STAFF_EMAIL="staff@example.com";
    public static final String STAFF_PASSWORD="officer";
    public static final String MANAGER_EMAIL="manager@example.com";
    public static final String MANAGER_PASSWORD="manager";

    @Autowired
    private User user;
    private static User OFFICER = User.createStaff(newRandomId(),
            STAFF_EMAIL,
            PASSWORD_ENCODER.encode
                    (STAFF_PASSWORD));
    private static User CAPTAIN = User.createManager(newRandomId(),
            MANAGER_EMAIL,
            PASSWORD_ENCODER.encode
                    (MANAGER_PASSWORD));
    public static UserId newRandomId() {
        return new UserId(UUID.randomUUID());
    }
    public static User newRandomOfficer() {
        return newRandomOfficer(newRandomId());
    }
    public static User newRandomOfficer(UserId userId) {
        String uniqueId = userId.asString().substring(0, 5);
        return User.createStaff(userId,
                "user-" + uniqueId +
                        "@example.com",
                PASSWORD_ENCODER.encode("user"));
    }
    public static User officer() {
        return OFFICER;
    }
    public static User captain() {
        return CAPTAIN;
    }
    private Users() {
    }
}
