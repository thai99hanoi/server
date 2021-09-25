package com.project.HealthyCare.po;

import com.project.HealthyCare.PersistentEnum;
import com.project.HealthyCare.PersistentEnums;

import java.util.Map;

public enum IsActive implements PersistentEnum<Byte> {
    ACTIVE((byte) 1, "ACTIVE"),
    DEACTIVE((byte) 0, "DEACTIVE");

    private static final Map<Byte, IsActive> INDEX = PersistentEnums.index(IsActive.class);
    private final byte value;
    private final String displayName;

    private IsActive(byte value, String displayName) {
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
    public Map<Byte, IsActive> getAll() {
        return INDEX;
    }

    public boolean isActive() {
        return this == ACTIVE;
    }

    public boolean isSDeactive() {
        return this == DEACTIVE;
    }
    public static IsActive parse(Byte value) {
        return value == null ? null : INDEX.get(value);
    }
}
