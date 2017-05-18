package com.example.tatth.vidu_listview_arraylist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText txtTen;
    TextView txtChon;
    Button btn;
    ListView lv;
    ArrayList<String> arrayList = null;
    ArrayAdapter<String> adapter = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtTen = (EditText)findViewById(R.id.txtTen);
        txtChon = (TextView)findViewById(R.id.txtSelection);
        lv = (ListView)findViewById(R.id.lvperson);

        arrayList = new ArrayList<String>();

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,arrayList);

        lv.setAdapter(adapter);

        btn = (Button)findViewById(R.id.btnNhap);

        btn.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View arg0){
                arrayList.add(txtTen.getText()+"");
                adapter.notifyDataSetChanged();
            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3){
                txtChon.setText("position: "+arg2+"; value = "+arrayList.get(arg2));
            }
        });

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int arg2, long arg3){
                arrayList.remove(arg2);
                adapter.notifyDataSetChanged();
                return false;
            }
        });
    }
}
