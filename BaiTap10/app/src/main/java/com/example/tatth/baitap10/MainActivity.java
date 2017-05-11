package com.example.tatth.baitap10;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editTen, editCMND, editBoSung;
    CheckBox chkDocBao, chkDocSach, chkDocCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTen = (EditText) findViewById(R.id.editHoTen);
        editCMND = (EditText) findViewById(R.id.editCMND);
        editBoSung = (EditText) findViewById(R.id.editBoSung);
        chkDocBao = (CheckBox) findViewById(R.id.chkdocbao);
        chkDocBao = (CheckBox) findViewById(R.id.chkdocbao);
        chkDocSach = (CheckBox) findViewById(R.id.chkdocsach);
        chkDocCode = (CheckBox) findViewById(R.id.chkdoccoding);
        Button btnGui = (Button) findViewById(R.id.btnGui);
        btnGui.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                doShowInformation();
            }
        });
    }

    public void doShowInformation() {
        String ten = editTen.getText() + "";
        ten = ten.trim();
        if (ten.length() < 3) {
            editTen.requestFocus();
            editTen.selectAll();
            Toast.makeText(this, "Tên phải >= 3 ký tự", Toast.LENGTH_SHORT).show();
            return;
        }

        String cmnd = editCMND.getText() + "";
        cmnd = cmnd.trim();
        if (cmnd.length() != 9) {
            editCMND.requestFocus();
            editCMND.selectAll();
            Toast.makeText(this, "CMND phải đúng 9 ký tự", Toast.LENGTH_SHORT).show();
            return;
        }

        String bang = "";
        RadioGroup group = (RadioGroup) findViewById(R.id.radioGroup1);
        int id = group.getCheckedRadioButtonId();
        if (id == -1) {
            Toast.makeText(this, "Phải chọn bằng cấp", Toast.LENGTH_SHORT).show();
            return;
        }

        RadioButton rad = (RadioButton) findViewById(id);
        bang = rad.getText() + "";
        String sothich = "";
        if (chkDocBao.isChecked())
            sothich += chkDocBao.getText() + "";
        if (chkDocSach.isChecked())
            sothich += chkDocSach.getText() + "\n";
        if (chkDocCode.isChecked())
            sothich += chkDocCode.getText() + "\n";

        String bosung = editBoSung.getText() + "";

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Thông tin cá nhân");
        builder.setPositiveButton("Đóng", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        String msg = ten + "\n";
        msg += cmnd + "\n";
        msg += bang + "\n";
        msg += sothich;
        msg += "_______________________\n";
        msg += "Thông tin bổ sung:\n";
        msg += bosung + "\n";
        msg += "_______________________";
        builder.setMessage(msg);
        builder.create().show();

    }

}
