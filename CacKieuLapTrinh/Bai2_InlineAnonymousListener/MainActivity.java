package com.example.tatth.bai2_inlineanonymouslistener;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnChuyen = (Button)findViewById(R.id.btnChuyen);
        btnChuyen.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0){
                EditText editNamDuong = (EditText)findViewById(R.id.editNamDuong);
                int namduong = Integer.parseInt(editNamDuong.getText()+"");
                String can, chi;
                switch (namduong % 10){
                    case 0: can="Canh";
                        break;
                    case 1: can="Tân";
                        break;
                    case 2: can="Nhâm";
                        break;
                    case 3: can="Quý";
                        break;
                    case 4: can="Giáp";
                        break;
                    case 5: can="Ất";
                        break;
                    case 6: can="Bính";
                        break;
                    case 7: can="Đinh";
                        break;
                    case 8: can="Mậu";
                        break;
                    case 9: can="Kỷ";
                        break;
                    default: can = "Lỗi tính can";
                        break;
                }

                switch (namduong % 12){
                    case 0: chi="Thân";
                        break;
                    case 1: chi="Dậy";
                        break;
                    case 2: chi="Tuất";
                        break;
                    case 3: chi="Hợi";
                        break;
                    case 4: chi="Tý";
                        break;
                    case 5: chi="Sửu";
                        break;
                    case 6: chi="Dần";
                        break;
                    case 7: chi="Mẹo";
                        break;
                    case 8: chi="Thìn";
                        break;
                    case 9: chi="Tỵ";
                        break;
                    case 10: chi="Ngọ";
                        break;
                    case 11: chi="Mùi";
                        break;
                    default: chi = "Lỗi tính chi";
                        break;
                }

                TextView txtkq = (TextView)findViewById(R.id.txtKQ);
                txtkq.setText(can + " " + chi);
            }
        });
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
