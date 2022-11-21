package com.jacobfrye.myboot.entity;

import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Data
public class User {
    private UUID id;
    private String email;
    private String password;
    private Set<UserRole> roles;
}
