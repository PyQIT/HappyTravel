package com.happytravel.happytravel.api.builder;

public class EmployeeByType{
    private String type;
    private Long quantity;
    public void set(String type, Long quantity){
        this.type = type;
        this.quantity = quantity;
    }
    @Override
    public String toString(){
        return "\""+type+"\": "+quantity;
    }
}
