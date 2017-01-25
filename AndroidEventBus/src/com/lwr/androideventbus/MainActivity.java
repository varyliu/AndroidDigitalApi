package com.lwr.androideventbus;

import de.greenrobot.event.EventBus;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Button mButton = null;
	private TextView mTextView = null;
	private LinearLayout rootLayout = null;		
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		setContentView(R.layout.main);	
        //注册EventBus  
        EventBus.getDefault().register(this);  
		
		rootLayout = new LinearLayout(this);
		rootLayout.setOrientation(LinearLayout.VERTICAL);
		
		mButton = new Button(this);
		mButton.setText("btn_bty");
		mButton.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
		rootLayout.addView(mButton);
		
		mTextView = new TextView(this);
		mTextView.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
		rootLayout.addView(mTextView);
		
		setContentView(rootLayout);
		
		mButton.setOnClickListener(clickListener);	
	}
	
	
	private OnClickListener clickListener = new OnClickListener() {	
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent = new Intent(getApplicationContext(),SecondActivity.class);
			startActivity(intent);
		}
	};

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		EventBus.getDefault().unregister(this);
	}	
	
	public void onEventMainThread(FirstEvent event) {  
		  
        String msg = "onEventMainThread收到了消息：" + event.getMsg();   
        mTextView.setText(msg);  
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();  
    }
	
    //SecondEvent接收函数一
	public void onEventMainThread(SecondEvent event) {
		Log.d("lwr", "onEventMainThread收到了消息：" + event.getMsg());    
    }  
  
    //SecondEvent接收函数二  
    public void onEventBackgroundThread(SecondEvent event){  
        Log.d("lwr", "onEventBackground收到了消息：" + event.getMsg());  
    }  
    //SecondEvent接收函数三  
    public void onEventAsync(SecondEvent event){  
        Log.d("lwr", "onEventAsync收到了消息：" + event.getMsg());  
    } 
    
    public void onEvent(ThirdEvent event) {
    	Log.d("lwr", "OnEvent收到了消息：" + event.getMsg());    
    }  
    
	
}
