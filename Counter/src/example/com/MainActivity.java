package example.com;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	TextView txtCount;
	RadioButton	rBtnUp, rBtnDown;
	Button btnCount;
	
	int count = 0;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        rBtnUp = (RadioButton)findViewById(R.id.rBtnUpId);
        rBtnDown = (RadioButton)findViewById(R.id.rBtnDownId);
        txtCount = (TextView)findViewById(R.id.txtCountId);
        txtCount.setText(String.valueOf(count));
        
        btnCount = (Button)findViewById(R.id.btnCountId);
        btnCount.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if (rBtnUp.isChecked()){
					count++;
				} else if (rBtnDown.isChecked()){
					count--;
				}
				txtCount.setText(String.valueOf(count));
			}
		});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
