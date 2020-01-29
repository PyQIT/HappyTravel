package com.happytravel.happytravel.api.decorator;

import com.happytravel.happytravel.api.builder.BuilderImpl;

public abstract class BuilderDecorator extends BuilderImpl {
    public void setAgeAttribute(Integer age){
        count.set(age);
    }
}
