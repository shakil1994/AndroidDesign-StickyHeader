package com.example.shakil.androidrclgroupname.Model;

public class Person {
    private String name, position;
    private int viewType;

    public Person() {
    }

    public Person(String name, String position, int viewType) {
        this.name = name;
        this.position = position;
        this.viewType = viewType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }
}
