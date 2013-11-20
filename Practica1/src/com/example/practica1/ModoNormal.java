package com.example.practica1;

import java.util.Timer;
import java.util.TimerTask;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;

public class ModoNormal extends Activity {
	GridView gridview;
	ImageAdapter tablero;
	Reloj relojTask;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_modo_normal);
		
		
		@SuppressWarnings("deprecation")
		final CargarDatos data = (CargarDatos) getLastNonConfigurationInstance();
	    if (data == null) {
	        relojTask = new Reloj(this);
	        tablero = new TableroNormal(this, showTheMetrics());
	    } else{
	    	TextView relojview = (TextView) findViewById(R.id.tiempoview);
	    	relojTask = new Reloj(this, data.getCont());
	    	tablero = new TableroNormal(this, showTheMetrics(), (Integer[])data.getBoard());
	    	relojview.setText(data.getTime());
	    	relojview.invalidate();
	    }
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
		
	    gridview = (GridView) findViewById(R.id.gridview);
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
		getMenuInflater().inflate(R.menu.modo_normal, menu);
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
	 

public void resetGame(View view){
	Intent intent = new Intent(this, ModoNormal.class);
	startActivity(intent);
	finish();
}

public void dispResolution(CharSequence text){
	Context context = getApplicationContext();
	int duration = Toast.LENGTH_SHORT;

	Toast toast = Toast.makeText(context, text, duration);
	toast.show();
}

@Override
public Object onRetainNonConfigurationInstance() {
	TextView marcador = (TextView) findViewById(R.id.tiempoview);
    final CargarDatos data = new CargarDatos(relojTask.getCont(),marcador.getText(),(Object[])tablero.getmThumbIds());
    return data;
}

}
