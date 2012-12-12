package com.example.explicitintent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends Activity {
	private Button btn_ok, btn_cancel;
	private EditText editText;
	private final String tag = "SecondActivity";
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        btn_ok = (Button)findViewById(R.id.button_ok);
        btn_cancel = (Button)findViewById(R.id.button_cancel);
        editText = (EditText)findViewById(R.id.editText1);
        
        btn_ok.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.putExtra("name", editText.getText().toString());
				setResult(RESULT_OK,intent);
				finish();
			}
		});
        
        btn_cancel.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.putExtra("name", "Cancel Pressed");
				setResult(RESULT_CANCELED, intent);
				finish();
			}
		});
    }
}
