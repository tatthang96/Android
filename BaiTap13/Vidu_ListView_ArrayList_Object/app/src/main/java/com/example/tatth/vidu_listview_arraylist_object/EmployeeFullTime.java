package com.example.tatth.vidu_listview_arraylist_object;

/**
 * Created by tatth on 18/05/2017.
 */

public class EmployeeFullTime extends Employee{
    public double TinhLuong(){
        return 500;
    }

    public String toString(){
        return super.toString() + " -->FullTime = "+TinhLuong();
    }
}
