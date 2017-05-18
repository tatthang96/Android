package com.example.tatth.vidu_listview_arraylist_object;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText editId, editName;
    Button btnNhap;
    RadioGroup radgroup;
    ListView lvNhanVien;
    ArrayList<Employee> arrEmployee = new ArrayList<Employee>();
    ArrayAdapter<Employee>adapter = null;

    Employee employee = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editId = (EditText)findViewById(R.id.editMa);
        editName = (EditText)findViewById(R.id.editTen);
        btnNhap = (Button)findViewById(R.id.btnNhap);
        radgroup = (RadioGroup)findViewById(R.id.radiogroup1);
        lvNhanVien = (ListView)findViewById(R.id.lvNhanVien);

        adapter = new ArrayAdapter<Employee>(this, android.R.layout.simple_list_item_1, arrEmployee);
        lvNhanVien.setAdapter(adapter);

        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processNhap();
            }
        });
    }

    public void processNhap() {
        int radId = radgroup.getCheckedRadioButtonId();
        String id = editId.getText()+"";
        String name = editName.getText()+"";
        if (radId == R.id.radChinhThuc)
            employee = new EmployeeFullTime();
        else
            employee = new EmployeePartTime();

        employee.setId(id);
        employee.setName(name);

        arrEmployee.add(employee);
        adapter.notifyDataSetChanged();
    }
}
