package com.happytravel.happytravel.api.decorator;

import com.happytravel.happytravel.api.builder.BuilderImpl;

public class EmployeeByAgeType extends BuilderDecorator {
    BuilderImpl builderImpl;

    public EmployeeByAgeType(BuilderImpl builderImpl){
        this.builderImpl = builderImpl;
    }

    @Override
    public void setAgeAttribute(Integer age) {
        super.setAgeAttribute(age);
    }
}
