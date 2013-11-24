package com.example.practica1;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;

public abstract class modoPadre extends Activity{
	GridView gridview;
	ImageAdapter tableroAdapter;
	Reloj relojTask;
	Boolean start = false;
	int nMinas;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		    
	    }
	
	protected void setListeners(){
		gridview.setOnItemClickListener(new OnItemClickListener() {
	        public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
	            //Toast.makeText(GridDemo.this, "" + position, Toast.LENGTH_SHORT).show();
	            if (!start){
	            tableroAdapter.generaMina(nMinas, position);
	            startTimer();
	            start = true;
	            }
	            if(tableroAdapter.getTablero()[position].getEsMina()){
	            	tableroAdapter.changeImgAfterClicked(position, Casilla.mina);
	            	gridview.invalidateViews();
	            	return;
	            }
	            tableroAdapter.changeImgAfterClicked(position, 0);
	            gridview.invalidateViews();
	        }

	    });
	    
	    gridview.setOnItemLongClickListener(new OnItemLongClickListener(){

			@Override
			public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
					int position, long arg3) {
				tableroAdapter.changeImgAfterLongClicked(position);
	            gridview.invalidateViews();
				return true;
			}
	    	
	    });
	    
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.grid_demo, menu);
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
			 return 72;
		 case DisplayMetrics.DENSITY_XXHIGH:
			 return 108;
		 case DisplayMetrics.DENSITY_XXXHIGH:
			 return 144;
		     
		 }
		 dispResolution("none");
		 return 72;
	}
	
	public abstract void resetGame(View view);

	public void dispResolution(CharSequence text){
		Context context = getApplicationContext();
		int duration = Toast.LENGTH_SHORT;

		Toast toast = Toast.makeText(context, text, duration);
		toast.show();
	}
	
	@Override
	public Object onRetainNonConfigurationInstance() {
		TextView marcador = (TextView) findViewById(R.id.tiempoview);
	    final CargarDatos data = new CargarDatos(relojTask.getCont(),marcador.getText(),tableroAdapter.getTablero(), tableroAdapter.getGraphics());
	    return data;
	}
	
	public void startTimer(){
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
	    timer.schedule(testing, 1000, 1000);
	}


}