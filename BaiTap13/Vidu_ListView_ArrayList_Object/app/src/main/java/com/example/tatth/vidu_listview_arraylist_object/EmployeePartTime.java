package com.example.tatth.vidu_listview_arraylist_object;

/**
 * Created by tatth on 18/05/2017.
 */

public class EmployeePartTime extends Employee {
    @Override
    public double TinhLuong() {
        return 150;
    }

    @Override
    public String toString() {
        return super.toString() + "-->PartTime=" + TinhLuong();
    }
}
