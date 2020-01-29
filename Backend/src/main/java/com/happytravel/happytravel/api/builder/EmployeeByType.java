package com.happytravel.happytravel.api.builder;

public class EmployeeByType{
    private String type;
    private Long quantity;
    private Integer age;
    public void set(String type, Long quantity){
        this.type = type;
        this.quantity = quantity;
    }

    public void set(Integer age){
        this.age = age;
    }

    @Override
    public String toString(){
        return "\""+type+"\": "+quantity;
    }

    public String toStringAge(){
        return "\""+age+"\""+type+"\": "+quantity;
    }
}
