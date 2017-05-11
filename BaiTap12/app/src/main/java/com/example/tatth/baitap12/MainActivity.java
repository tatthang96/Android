package com.example.tatth.baitap12;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity {
    Button btnTinhTT, btnTiep, btnThongKe;
    ImageButton btnThoat;
    EditText editTenKH, editSoLuongSach, editThanhTien, editTongSoKH, editTongSoVIP, editTongDoanhThu;
    TextView txtThanhTien;
    CheckBox chkVip;
    DanhSachKhachHang danhsach = new DanhSachKhachHang();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getControls();
        addEvents();
    }

    private void getControls() {
        btnTinhTT = (Button) findViewById(R.id.btnTinhTT);
        btnTiep = (Button) findViewById(R.id.btnTiep);
        btnThongKe = (Button) findViewById(R.id.btnThongKe);
        btnThoat = (ImageButton) findViewById(R.id.btnThoat);
        editTenKH = (EditText) findViewById(R.id.editTenKH);
        editSoLuongSach = (EditText) findViewById(R.id.editSoLuongSach);
        editTongDoanhThu = (EditText) findViewById(R.id.editTongDoanhThu);
        editTongSoKH = (EditText) findViewById(R.id.editTongSoKH);
        editTongSoVIP = (EditText) findViewById(R.id.editTongSoVIP);
        txtThanhTien = (TextView) findViewById(R.id.txtThanhTien);
        chkVip = (CheckBox) findViewById(R.id.chkVip);
    }

    private void addEvents() {
        btnTinhTT.setOnClickListener(new ProcessMyEvent());
        btnThongKe.setOnClickListener(new ProcessMyEvent());
        btnThoat.setOnClickListener(new ProcessMyEvent());
        btnTiep.setOnClickListener(new ProcessMyEvent());
    }

    private void doTinhTien() {
        KhachHang kh = new KhachHang();
        kh.setTenKH(editTenKH.getText() + "");
        kh.setSlMua(Integer.parseInt(editSoLuongSach.getText() + ""));
        kh.setVip(chkVip.isChecked());
        txtThanhTien.setText(kh.tinhThanhTien() + "");
        danhsach.addKhachHang(kh);
    }

    private void doTiep() {
        editTenKH.setText("");
        editSoLuongSach.setText("");
        txtThanhTien.setText("");
        editTenKH.requestFocus();
    }

    private void doThongKe() {
        editTongSoKH.setText(danhsach.tongKhachHang() + "");
        editTongSoVIP.setText(danhsach.tongKhachHangVip() + "");
        editTongDoanhThu.setText(danhsach.tongDoanhThu() + "");
    }

    private void doThoat() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Hỏi thoát chương trình");
        builder.setMessage("Muốn thoát chương trình?");
        builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        builder.create().show();
    }

    private class ProcessMyEvent implements OnClickListener {
        public void onClick(View arg0) {
            switch (arg0.getId()) {
                case R.id.btnTinhTT:
                    doTinhTien();
                    break;
                case R.id.btnThongKe:
                    doThongKe();
                    break;
                case R.id.btnTiep:
                    doTiep();
                    break;
                case R.id.btnThoat:
                    doThoat();
                    break;
            }
        }
    }

}
