package com.example.tatth.bai3_activityislistener;

import android.icu.text.DecimalFormat;
import android.icu.text.NumberFormat;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements OnClickListener{
    Button btnTinh;
    EditText editTen, editChieuCao, editCanNang, editBMI, editChuanDoan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnTinh = (Button)findViewById(R.id.btnTinh);
        btnTinh.setOnClickListener(this);
        editTen = (EditText)findViewById(R.id.editTen);
        editChieuCao = (EditText)findViewById(R.id.editChieuCao);
        editCanNang = (EditText)findViewById(R.id.editCanNang);
        editBMI = (EditText)findViewById(R.id.editBMI);
        editChuanDoan = (EditText)findViewById(R.id.editChuanDoan);
    }

    @Override
    public void onClick(View arg0){
        double H = Double.parseDouble(editChieuCao.getText()+"");
        double W = Double.parseDouble(editCanNang.getText()+"");
        double BMI = W/Math.pow(H, 2);
        String chuandoan="";
        if (BMI < 18)
            chuandoan="Bạn gầy";
        else if (BMI <= 24.9)
            chuandoan="Bạn bình thường";
        else if (BMI <= 29.9)
            chuandoan="Bạn béo phì dộ 1";
        else if (BMI <= 34.9)
            chuandoan="Bạn béo phì dộ 2";
        else
            chuandoan="Bạn béo phì độ 3";
        editBMI.setText(String.format("%.1f", BMI)+"");
        editChuanDoan.setText(chuandoan);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
