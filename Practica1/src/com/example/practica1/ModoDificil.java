package com.example.practica1;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.AdapterView.OnItemClickListener;

public class ModoDificil extends Activity {
	GridView gridview;
	ImageAdapter tablero;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_modo_dificil);
		tablero = new TableroDificil(this, showTheMetrics());
		gridview = (GridView) findViewById(R.id.gridview);
		
	    gridview.setAdapter(tablero);
	    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
	    
	    gridview.setOnItemClickListener(new OnItemClickListener() {
	        public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
	            //Toast.makeText(GridDemo.this, "" + position, Toast.LENGTH_SHORT).show();
	            tablero.changeImgAfterClicked(position);
	            gridview.invalidateViews();
	            
	        }

	    });
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
