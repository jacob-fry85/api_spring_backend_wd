package com.jacobfrye.myboot.user;

import com.jacobfrye.myboot.jpa.AbstractEntityId;

import java.util.UUID;

public class UserId extends AbstractEntityId<UUID> {
    protected UserId() {

    }
    public UserId(UUID id) {
        super(id);
    }
}
