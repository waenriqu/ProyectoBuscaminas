package com.example.practica1;

import java.util.Timer;
import java.util.TimerTask;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;

public class ModoDificil extends Activity {
	GridView gridview;
	ImageAdapter tablero;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_modo_dificil);
		tablero = new TableroDificil(this, showTheMetrics());
		gridview = (GridView) findViewById(R.id.gridview);
		
		final Reloj relojTask = new Reloj(this);
		final Handler handler = new Handler(); 
		Timer timer = new Timer(); 
	    TimerTask testing = new TimerTask() {
	        public void run() { 
	            handler.post(new Runnable() {
	                public void run() {
	                    relojTask.run();
	                }

	            });


	        }
	    };
	    
	    gridview.setAdapter(tablero);
	    
	    gridview.setOnItemClickListener(new OnItemClickListener() {
	        public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
	            //Toast.makeText(GridDemo.this, "" + position, Toast.LENGTH_SHORT).show();
	            tablero.changeImgAfterClicked(position);
	            gridview.invalidateViews();
	            
	        }
	           
	    });
	    
	    gridview.setOnItemLongClickListener(new OnItemLongClickListener(){

			@Override
			public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
					int position, long arg3) {
				tablero.changeImgAfterLongClicked(position);
	            gridview.invalidateViews();
				return true;
			}
	    	
	    });
	    
	    timer.schedule(testing, 1000, 1000);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.modo_dificil, menu);
		return true;
	}
	
	public int showTheMetrics(){
		 int density= getResources().getDisplayMetrics().densityDpi;

		 switch(density)
		 {
		 case DisplayMetrics.DENSITY_LOW:
		    return 24;
		case DisplayMetrics.DENSITY_MEDIUM:
		      return 36;
		 case DisplayMetrics.DENSITY_HIGH:
		     return 54;
		 case DisplayMetrics.DENSITY_XHIGH:
		      return 54;
		     
		 }
		 
		 return 24;
	}

	public void resetGame(View view){
		Intent intent = new Intent(this, ModoDificil.class);
		startActivity(intent);
		finish();
	}


}
