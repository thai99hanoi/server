package com.project.HealthyCare.entity.converter;

import com.project.HealthyCare.po.Status;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class StatusConverter implements AttributeConverter<Status, Integer> {
    @Override
    public Integer convertToDatabaseColumn(Status status) {
        return status == null ? null : status.getValue().intValue();
    }

    @Override
    public Status convertToEntityAttribute(Integer dbData) {
        return dbData == null ? null : Status.parse(dbData.byteValue());
    }
}
