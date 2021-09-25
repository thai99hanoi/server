package com.project.HealthyCare.po;

import com.project.HealthyCare.PersistentEnum;
import com.project.HealthyCare.PersistentEnums;

import java.util.Map;

public enum TestResult implements PersistentEnum<Byte> {
    POSITIVE((byte) 1, "POSITIVE"),
    NEGATIVE((byte) 0, "NEGATIVE");

    private static final Map<Byte, TestResult> INDEX = PersistentEnums.index(TestResult.class);
    private final byte value;
    private final String displayName;

    private TestResult(byte value, String displayName) {
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
    public Map<Byte, TestResult> getAll() {
        return INDEX;
    }

    public boolean isPositive() {
        return this == POSITIVE;
    }

    public boolean isNEGATIVE() {
        return this == NEGATIVE;
    }

    public static TestResult parse(Byte value) {
        return value == null ? null : INDEX.get(value);
    }
}
