package com.example.tatth.baitap12;

import java.util.ArrayList;

/**
 * Created by tatth on 11/05/2017.
 */

public class DanhSachKhachHang {
    ArrayList<KhachHang> listKH = new ArrayList<KhachHang>();
    public void addKhachHang(KhachHang kh)
    {
        listKH.add(kh);
    }

    public double tongDoanhThu()
    {
        double tien = 0.0;
        for (KhachHang kh:listKH)
        {
            tien += kh.tinhThanhTien();
        }
        return tien;
    }

    public int tongKhachHang(){
        return listKH.size();
    }

    public int tongKhachHangVip(){
        int s = 0;
        for (KhachHang kh:listKH)
        {
            if (kh.isVip())
                s++;
        }
        return s;
    }
}
