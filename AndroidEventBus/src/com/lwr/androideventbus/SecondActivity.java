package com.lwr.androideventbus;

import de.greenrobot.event.EventBus;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;

public class SecondActivity extends Activity {
	
	private Button mFirstButton = null;
	private Button mSecondButton = null;
	private Button mThridButton = null;
	private LinearLayout rootLayout = null;	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		rootLayout = new LinearLayout(this);
		rootLayout.setOrientation(LinearLayout.VERTICAL);
		
		mFirstButton = new Button(this);
		mFirstButton.setText("First Event");
		mFirstButton.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
		rootLayout.addView(mFirstButton);
		
		mSecondButton = new Button(this);
		mSecondButton.setText("Second Event");
		mSecondButton.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
		rootLayout.addView(mSecondButton);
		
		mThridButton = new Button(this);
		mThridButton.setText("Thrid Event");
		mThridButton.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
		rootLayout.addView(mThridButton);
		
		setContentView(rootLayout);
		
		mFirstButton.setOnClickListener(clickListener);
		mSecondButton.setOnClickListener(clickListener);
		mThridButton.setOnClickListener(clickListener);
	}
	
	private OnClickListener clickListener = new OnClickListener() {	
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			if(v.equals(mFirstButton))
			{
				EventBus.getDefault().post(new FirstEvent("FirstEvent btn clicked")); 
			}else if(v.equals(mSecondButton))
			{
				EventBus.getDefault().post(new SecondEvent("SecondEvent btn clicked"));
			}else {
				EventBus.getDefault().post(new ThirdEvent("ThirdEvent btn clicked")); 
			}
		
		}
	};
	
	
}
