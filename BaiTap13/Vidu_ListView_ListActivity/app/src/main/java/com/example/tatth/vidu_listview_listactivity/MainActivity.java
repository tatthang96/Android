package com.example.tatth.vidu_listview_listactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.view.View;
import android.widget.ListView;
import android.app.ListActivity;

public class MainActivity extends ListActivity {
    TextView selection;
    String arr[] = {"Intel", "SamSung", "Nokia", "Simen", "AMD", "KIC", "ECD"};
    ArrayAdapter<String> adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arr);
        setListAdapter(adapter);
        selection = (TextView) findViewById(R.id.selection);
    }
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        String txt = "position = " + position + "; value = "+ arr[position];
        selection.setText(txt);
        }
    }
