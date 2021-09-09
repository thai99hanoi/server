package com.project.HealthyCare.dao.entity.converter;

import com.project.HealthyCare.dao.po.TestResult;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class TestResultConverter implements AttributeConverter<TestResult, Integer> {

    @Override
    public Integer convertToDatabaseColumn(TestResult result) {
        return result == null ? null : result.getValue().intValue();
    }

    @Override
    public TestResult convertToEntityAttribute(Integer dbData) {
        return dbData == null ? null : TestResult.parse(dbData.byteValue());
    }
}
