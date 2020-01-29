package com.happytravel.happytravel.api.builder;

public class BuilderImpl implements Builder {
    public EmployeeByType count;
    public void create(){
        this.count = new EmployeeByType();
    }
    public void setAttributes(String type, Long quantity){
        count.set(type, quantity);
    }
    public EmployeeByType returnProduct(String type, Long quantity){
        this.create();
        this.setAttributes(type, quantity);
        return count;
    }
}
