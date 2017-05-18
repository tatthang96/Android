package com.example.tatth.vidu_listview_arraylist_object;

/**
 * Created by tatth on 18/05/2017.
 */

public abstract class Employee {
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract double TinhLuong();

    public String toString() {
        return this.id + " - " + this.name;
    }
}
