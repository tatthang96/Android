package com.example.tatth.baitap12;

/**
 * Created by tatth on 11/05/2017.
 */

public class KhachHang {
    private String tenKH;
    private int slMua;
    private boolean isVip;
    public static final int GIA = 20000;
    public KhachHang()
    {

    }

    public KhachHang(String tenKH, int slMua, boolean isVip)
    {
        this.tenKH = tenKH;
        this.slMua = slMua;
        this.isVip = isVip;
    }

    public String getTenKH(){
        return tenKH;
    }

    public void setTenKH(String tenKH){
        this.tenKH = tenKH;
    }

    public int getSlMua(){
        return slMua;
    }

    public void setSlMua(int slMua){
        this.slMua = slMua;
    }

    public boolean isVip(){
        return isVip;
    }

    public void setVip(boolean isVip){
        this.isVip = isVip;
    }

    public double tinhThanhTien(){
        return(!isVip ? slMua *GIA : slMua * GIA * 0.9);
    }
}
