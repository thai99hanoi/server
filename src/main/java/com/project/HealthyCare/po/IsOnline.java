package com.project.HealthyCare.po;

import com.project.HealthyCare.PersistentEnum;
import com.project.HealthyCare.PersistentEnums;

import java.util.Map;

public enum IsOnline implements PersistentEnum<Byte> {
    ONLINE((byte) 1, "ONLINE"),
    OFFLINE((byte) 0, "OFFLINE");

    private static final Map<Byte, IsOnline> INDEX = PersistentEnums.index(IsOnline.class);
    private final byte value;
    private final String displayName;

    private IsOnline(byte value, String displayName) {
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
    public Map<Byte, IsOnline> getAll() {
        return INDEX;
    }

    public boolean isOnline() {
        return this == ONLINE;
    }

    public boolean isOffline() {
        return this == OFFLINE;
    }

    public static IsOnline parse(Byte value) {
        return value == null ? null : INDEX.get(value);
    }
}
