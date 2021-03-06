package com.example.explicitintent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	private Button btn;
	private String text;
	private final String tag = "MainActivity";
	private final int REQUEST_CODE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button)findViewById(R.id.button1);
        btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, SecondActivity.class);
				intent.putExtra("name", "Sudipta");
				startActivityForResult(intent,REQUEST_CODE);
				
			}
		});
    }
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
    	super.onActivityResult(requestCode, resultCode, data);
    	if(resultCode == RESULT_OK && REQUEST_CODE == REQUEST_CODE){
    		text = "Received: "+data.getExtras().getString("name");
    	}else if(resultCode == RESULT_CANCELED && requestCode == REQUEST_CODE){
    		text = "Cancel Pressed";
    	}
    	Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
    }

    
    
}
