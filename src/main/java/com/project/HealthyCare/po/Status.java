package com.project.HealthyCare.po;

import com.project.HealthyCare.PersistentEnum;
import com.project.HealthyCare.PersistentEnums;

import java.util.Map;

public enum Status implements PersistentEnum<Byte> {
    PASS((byte) 1, "PASS"),
    NOTPASS((byte) 0, "NOTPASS");

    private static final Map<Byte, Status> INDEX = PersistentEnums.index(Status.class);
    private final byte value;
    private final String displayName;

    private Status(byte value, String displayName) {
        this.value = value;
        this.displayName = displayName;
    }

    @Override
    public Byte getValue() {
        return this.value;
    }

    @Override
    public String getDisplayName() {
        return this.displayName;
    }

    @Override
    public Map<Byte, Status> getAll() {
        return INDEX;
    }

    public boolean isPass() {
        return this == PASS;
    }

    public boolean isNotPass() {
        return this == NOTPASS;
    }

    public static Status parse(Byte value) {
        return value == null ? null : INDEX.get(value);
    }
}
