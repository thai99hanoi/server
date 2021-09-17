package com.project.HealthyCare.entity.converter;

import com.project.HealthyCare.po.IsActive;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class IsActiveConverter implements AttributeConverter<IsActive, Integer> {

    @Override
    public Integer convertToDatabaseColumn(IsActive isActive) {
        return isActive == null ? null : isActive.getValue().intValue();
    }

    @Override
    public IsActive convertToEntityAttribute(Integer dbData) {
        return dbData == null ? null : IsActive.parse(dbData.byteValue());
    }
}
