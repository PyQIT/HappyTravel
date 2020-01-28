package com.happytravel.happytravel.api.builder;

//Builder raportu o ilości pracowników w danym biurze
interface Builder{
    public void create();
    public void setAttributes(String type, Long quantity);
    public EmployeeByType returnProduct(String type, Long quantity);
}
