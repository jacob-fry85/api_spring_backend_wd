package com.jacobfrye.myboot.user;

public interface Entity <T extends EntityId>{
    T getId();
}
