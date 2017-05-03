package com.example.tatth.bai4_listenerinvariable;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Button;
import android.view.View.OnClickListener;
public class MainActivity extends AppCompatActivity {
    private Button btnFar, btnCel, btnClear;
    private EditText txtFar, txtCel;
    private OnClickListener myVarListener = new OnClickListener(){
        @Override
        public void onClick(View arg0){

            if (arg0 == btnFar)
            {
                try {
                    double F = Double.parseDouble(txtFar.getText() + "");
                    double out = (F - 32) * (5.0 / 9);
                    txtCel.setText(String.format("%.1f", out) + "");
                }
                catch (Exception e)
                {
                    txtFar.setText("Chưa nhập độ F");
                }
            }
            else if (arg0 == btnCel) {
                try {
                    double C = Double.parseDouble(txtCel.getText() + "");
                    double out = C * (9.0 / 5) + 32;
                    txtFar.setText(String.format("%.1f", out) + "");
                } catch (Exception e) {
                    txtCel.setText("Chưa nhập độ F");
                }
            }
            else if (arg0 == btnClear)
            {
                txtCel.setText("");
                txtFar.setText("");
                txtFar.requestFocus();
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnFar = (Button)findViewById(R.id.btnFar);
        btnCel = (Button)findViewById(R.id.btnCel);
        btnClear = (Button)findViewById(R.id.btnClear);
        txtFar = (EditText)findViewById(R.id.editFar);
        txtCel = (EditText)findViewById(R.id.editCel);
        btnFar.setOnClickListener(myVarListener);
        btnCel.setOnClickListener(myVarListener);
        btnClear.setOnClickListener(myVarListener);
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
