package com.example.tatth.vidu_listview_hardcode_array;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final String arr[] = {"Tep", "Ty", "Bin", "Bo"};
        ListView lv = (ListView) findViewById(R.id.lvperson);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arr);
        lv.setAdapter(adapter);
        final TextView txt = (TextView) findViewById(R.id.txtSelection);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){
           public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3){
               txt.setText("position: "+arg2+"; value ="+arr[arg2]);
           }
        });
    }
}
