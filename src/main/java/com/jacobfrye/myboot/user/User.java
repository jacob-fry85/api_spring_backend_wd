package com.jacobfrye.myboot.user;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@Table(name = "my_user")
public class User extends UserId{
    @Id
    private UserId id;

    private String email;
    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @NotNull
    private Set<UserRole> roles;

    public User(){}

    public User(UUID id, String email, String password, Set<UserRole> roles) {
        super(id);
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public User(UserId newRandomId, String staffEmail, String encode, HashSet<UserRole> roles) {
    }

    public static User createStaff(UserId newRandomId, String staffEmail, String encode) {
        HashSet<UserRole> roles = new HashSet<>();
        roles.add(UserRole.STAFF);
        User newUser = new User(newRandomId, staffEmail,encode,roles);
        return newUser;
    }

    public static User createManager(UserId newRandomId, String staffEmail, String encode) {
        HashSet<UserRole> roles = new HashSet<>();
        roles.add(UserRole.MANAGER);
        User newUser = new User(newRandomId, staffEmail,encode,roles);
        return newUser;
    }
}
