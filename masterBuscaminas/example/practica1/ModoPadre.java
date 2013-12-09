package com.example.buscaminasremix;


import java.util.Timer;
import java.util.TimerTask;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;

public abstract class ModoPadre extends Activity{
	GridView gridview;
	ImageAdapter tableroAdapter;
	Reloj relojTask;
	Timer timer;
	Boolean start = false, finish = false;
	int nMinas;
	final int audioBandera = R.raw.bandera, audioVictoria = R.raw.victoria, audioDeactivate = R.raw.deactivated;
	final int audioDerrota = R.raw.gameover;
	MediaPlayer mpBandera, mpVictoria, mpDeactivate, mpDerrota;
	public final static String TIEMPO_MESSAGE = "com.example.myfirstapp.TIEMPO";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mpBandera = newAudio(audioBandera);
		mpVictoria = newAudio(audioVictoria);
		mpDerrota = newAudio(audioDerrota);
		
		}
	
	protected void setListeners(){
		gridview.setOnItemClickListener(new OnItemClickListener() {
	        public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
	            //Toast.makeText(GridDemo.this, "" + position, Toast.LENGTH_SHORT).show();
	            if (!start){
	            tableroAdapter.generaMina(position);
	            startTimer();
	            start = true;
	            }
	            
	            if(!tableroAdapter.getTablero()[position].isOculto()){
	            	return;
	            }
	            if(tableroAdapter.getTablero()[position].getEsMina()){
	            	tableroAdapter.revelarTodasMinas();
	            	detenerJuego();
	            	actualizarCarita(false);
	            	gridview.invalidateViews();
	            	playAudio(mpDerrota);
	            	return;
	            }
	            
	             seleccionarNumero(position);
	            gridview.invalidateViews();
	            
	            if(tableroAdapter.isVictoria()){
	            	detenerJuego();
	            	actualizarCarita(true);
	            	playAudio(mpVictoria);
	            	//resultScreen();
	            }
	        }

	    });
	    
	    gridview.setOnItemLongClickListener(new OnItemLongClickListener(){

			@Override
			public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
					int position, long arg3) {
				if(!tableroAdapter.getTablero()[position].isOculto()){
					return true;
				}
				tableroAdapter.changeImgAfterLongClicked(position);
				playAudio(mpBandera);
	            gridview.invalidateViews();
				return true;
			}
	    	
	    });
	    
	}
	
	public void seleccionarNumero(int pos){
		switch(tableroAdapter.calcularMinas(pos)){
		case 0:
			tableroAdapter.changeImgAfterClicked(pos, 0);
			tableroAdapter.revelarAdy(pos);
			break;
		case 1:
			tableroAdapter.changeImgAfterClicked(pos, 1);
			break;
		case 2:
			tableroAdapter.changeImgAfterClicked(pos, 2);
			break;
		case 3:
			tableroAdapter.changeImgAfterClicked(pos, 3);
			break;
		case 4:
			tableroAdapter.changeImgAfterClicked(pos, 4);
			break;
		case 5:
			tableroAdapter.changeImgAfterClicked(pos, 5);
			break;
		case 6:
			tableroAdapter.changeImgAfterClicked(pos, 6);
			break;
		case 7:
			tableroAdapter.changeImgAfterClicked(pos, 7);
			break;
		case 8:
			tableroAdapter.changeImgAfterClicked(pos, 8);
			break;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.modo_padre, menu);
		return true;
	}
	
	public int showTheMetrics(){
		 int density= getResources().getDisplayMetrics().densityDpi;

		 switch(density)
		 {
		 case DisplayMetrics.DENSITY_LOW:
			return 27;
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
		if(!start){
			return null;
		}
		deleteMP();
	    final CargarDatos data = new CargarDatos(relojTask.getCont(),marcador.getText(),tableroAdapter.getTablero(), tableroAdapter.getGraphics(), finish, tableroAdapter.revelados);
	    return data;
	}
	
	
	
	
	
	
	
	
	public void startTimer(){
		final Handler handler = new Handler(); 
		timer = new Timer(); 
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

	public void detenerJuego(){
		gridview.setOnItemClickListener(null);
		gridview.setOnItemLongClickListener(null);
		timer.cancel();
		timer = null;
		finish = true;
	}
	
	public void actualizarCarita(boolean victoria){
		ImageButton ib = (ImageButton)findViewById(R.id.resetButton);
		if(victoria){
			ib.setImageResource(R.drawable.clicked);
		}else{
		ib.setImageResource(R.drawable.yoonsad);
		}
		ib.invalidate();
	}
	
	@SuppressLint("NewApi")
	public abstract void gravityCenterAPI16();
	
	public abstract void gravityCenterAPI8();
	
	public void cambiarContentViews(){
		if(Integer.valueOf(android.os.Build.VERSION.SDK) >= 16){
			gravityCenterAPI16();
		} else{
			gravityCenterAPI8();
		}
	}

	public void resetCombo() {
		// TODO Auto-generated method stub
		
	}
	
	public MediaPlayer newAudio(int file){
		try{
			return MediaPlayer.create(getApplicationContext(), file);
		} 	catch(Exception e){
			Toast.makeText(ModoPadre.this, "Error "+Log.getStackTraceString(e), Toast.LENGTH_SHORT).show();
			return null;
		}
	}
	
	public void playAudio(MediaPlayer mp){
		try{
			if(mp.isPlaying()){
				mp.pause();
				mp.seekTo(0);
				mp.start();
			} else{
				mp.start();
			}
		}catch(Exception e){
			e.printStackTrace();
			Toast.makeText(ModoPadre.this, "Error "+Log.getStackTraceString(e), Toast.LENGTH_LONG).show();
		}
	}
	
	public void deleteMP(){
		if(mpBandera != null){
			mpBandera.stop();
			mpBandera.release();
		}
		if(mpVictoria != null){
			mpVictoria.stop();
			mpVictoria.release();
		}
		if(mpDerrota != null){
			mpDerrota.stop();
			mpDerrota.release();
		}
	}
	
	@Override
	public void onBackPressed() {
	    deleteMP();
	    finish();
	    return;
	}  
	
	public void resultScreen(){
		Intent intent = new Intent(this, ResultScreen.class);
		TextView tv = (TextView) findViewById(R.id.tiempoview);
		 intent.putExtra(TIEMPO_MESSAGE, tv.getText().toString());
		startActivity(intent);
	}
	
}