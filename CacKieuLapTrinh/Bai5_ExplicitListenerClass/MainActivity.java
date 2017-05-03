package com.example.tatth.bai5_explicitlistenerclass;

import android.icu.text.DecimalFormat;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity {
    Button btnTieptuc, btnGiai, btnThoat;
    EditText edita, editb, editc;
    TextView txtkq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnTieptuc = (Button)findViewById(R.id.btnTiepTuc);
        btnGiai = (Button)findViewById(R.id.btnGiaiPT);
        btnThoat = (Button)findViewById(R.id.btnThoat);
        btnTieptuc.setOnClickListener(new MyEvent());
        btnGiai.setOnClickListener(new MyEvent());
        btnThoat.setOnClickListener(new MyEvent());
        edita = (EditText)findViewById(R.id.edita);
        editb = (EditText)findViewById(R.id.editb);
        editc = (EditText)findViewById(R.id.editc);
        txtkq = (TextView) findViewById(R.id.txtKQ);
    }

    public void giaiPT(){
        String sa=edita.getText()+"", sb = editb.getText()+"", sc = editc.getText()+"";
        int a = Integer.parseInt(sa);
        int b = Integer.parseInt(sb);
        int c = Integer.parseInt(sc);
        String kq = "";
        if (a == 0) {
            if (b == 0) {
                if (c == 0)
                    kq = "PT vô số nghiệm";
                else
                    kq = "PT vô nghiệm";
            } else
                kq = "PT có 1 nghiệm, x=" + String.format("%.1f", ((double) c / b));
        }
        else {
            double delta = b * b - 4 * a * c;
            if (delta < 0)
                kq = "PT vô nghiệm";
            else if (delta == 0)
                kq = "PT có nghiệm x1 = x2 =" + String.format("%.1f", (double)-b/(2*a));
            else
            {
                kq = "PT có 2 nghiệm: x1 =" + String.format("%.1f", (-b-Math.sqrt(delta))/(2*a))
                        + "; x2 = " + String.format("%.1f", (-b+Math.sqrt(delta))/(2*a));
            }
        }
        txtkq.setText(kq);
    }

    private class MyEvent implements OnClickListener
    {
        @Override
        public void onClick(View arg0){
            if (arg0 == btnTieptuc)
            {
                edita.setText("");
                editb.setText("");
                editc.setText("");
                edita.requestFocus();
            }
            else if(arg0.getId()==R.id.btnGiaiPT)
            {
                giaiPT();
            }
            else if (arg0.getId()==R.id.btnThoat)
            {
                finish();
            }
        }
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
