package com.example.tatth.baitap14;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Employee> arrEmployee = new ArrayList<Employee>();
    MyArrayAdapter adapter = null;
    ListView lvNhanVien = null;
    Button btnNhap;
    ImageButton btnRemoveAll;
    EditText editMa, editTen;
    RadioGroup genderGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnNhap = (Button)findViewById(R.id.btnNhap);
        btnRemoveAll = (ImageButton)findViewById(R.id.btnDelete);
        editMa = (EditText)findViewById(R.id.editMa);
        editTen = (EditText)findViewById(R.id.editTen);
        genderGroup = (RadioGroup)findViewById(R.id.radGroup);

        lvNhanVien = (ListView)findViewById(R.id.lvnhanvien);
        arrEmployee = new ArrayList<Employee>();
        adapter = new MyArrayAdapter(this, R.layout.my_item_layout,arrEmployee);
        lvNhanVien.setAdapter(adapter);
        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xulyNhap();
            }
        });
        btnRemoveAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xulyXoa();
            }
        });
    }

    public  void xulyNhap(){
        String ma = editMa.getText()+"";
        String ten = editTen.getText()+"";
        boolean gioitinh = false;
        if (genderGroup.getCheckedRadioButtonId()==R.id.radNu)
            gioitinh = true;

        Employee emp = new Employee();
        emp.setId(ma);
        emp.setName(ten);
        emp.setGender(gioitinh);
        arrEmployee.add(emp);
        adapter.notifyDataSetChanged();
        editMa.setText("");
        editTen.setText("");
        editMa.requestFocus();
    }

    public void xulyXoa()
    {
        for(int i = lvNhanVien.getChildCount() - 1; i >= 0; i--)
        {
            View v = lvNhanVien.getChildAt(i);
            CheckBox chk = (CheckBox) v.findViewById(R.id.chkitem);
            if (chk.isChecked())
                arrEmployee.remove(i);
        }
        adapter.notifyDataSetChanged();
    }



}
