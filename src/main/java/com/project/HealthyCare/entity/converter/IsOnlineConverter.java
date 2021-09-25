package com.project.HealthyCare.entity.converter;

import com.project.HealthyCare.po.IsActive;
import com.project.HealthyCare.po.IsOnline;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class IsOnlineConverter implements AttributeConverter<IsOnline, Integer> {
    @Override
    public Integer convertToDatabaseColumn(IsOnline isOnline) {
        return isOnline == null ? null : isOnline.getValue().intValue();
    }

    @Override
    public IsOnline convertToEntityAttribute(Integer dbData) {
        return dbData == null ? null : IsOnline.parse(dbData.byteValue());
    }
}
