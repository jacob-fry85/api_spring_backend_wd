package com.jacobfrye.myboot.user;

import java.io.Serializable;

public interface EntityId<T> extends Serializable {
    T getId();
    String asString();
}
