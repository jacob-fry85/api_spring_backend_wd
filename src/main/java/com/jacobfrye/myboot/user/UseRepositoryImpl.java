//package com.jacobfrye.myboot.user;
//
//import org.apache.catalina.User;
//
//import java.util.UUID;
//
//public class UseRepositoryImpl implements UserRepositoryCustom {
//    private final UniqueIdGenerator<UUID> generator;
//
//    public UserRepositoryImpl(UniqueIdGenerator<UUID> generator) {
//        this.generator = generator;
//    }
//
//    @Override
//    public UserId nextid() {
//    }
//
//    @Override
//    public UserId nextId() {
//        return new UserId(generator.getNextUniqueId());
//    }
//}
