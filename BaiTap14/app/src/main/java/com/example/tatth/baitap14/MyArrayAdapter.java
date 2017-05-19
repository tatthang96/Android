package com.example.tatth.baitap14;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by tatth on 18/05/2017.
 */

public class MyArrayAdapter extends ArrayAdapter<Employee> {
    Activity context = null;
    ArrayList<Employee>myArray = null;
    int layoutId;

    public  MyArrayAdapter(Activity context, int layoutId, ArrayList<Employee>arr) {
        super(context, layoutId, arr);
        this.context = context;
        this.layoutId = layoutId;
        this.myArray = arr;
        }
        public View getView(int postition, View convertView, ViewGroup parent){
            if (convertView == null)
            {
                LayoutInflater inflater = context.getLayoutInflater();
                convertView = inflater.inflate(layoutId, null);
            }

            LayoutInflater inflater = context.getLayoutInflater();
            convertView = inflater.inflate(layoutId, null);
            if (myArray.size() > 0 && postition >= 0)
            {
                final TextView txtdisplay = (TextView)convertView.findViewById(R.id.txtitem);
                final Employee emp = myArray.get(postition);
                txtdisplay.setText(emp.toString());
                final ImageView imgitem = (ImageView)convertView.findViewById(R.id.imgitem);
                if (emp.isGender())
                    imgitem.setImageResource(R.drawable.girlicon);
                else
                    imgitem.setImageResource(R.drawable.boyicon);
            }
            return convertView;
        }

}
