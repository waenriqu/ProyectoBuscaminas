package com.example.buscaminasremix;

import java.util.Vector;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ResultScreen extends Activity {
String tiempo;
Puntuaciones puntuaciones;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result_screen);
		 Intent intent = getIntent();
		 tiempo = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
		 puntuaciones = new Puntuaciones(this.getApplicationContext());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.result_screen, menu);
		return true;
	}
	
	public void addPuntuacion(View view){
		EditText et = (EditText) findViewById(R.id.edit_message);
		puntuaciones.guardarPuntuacion(tiempo, et.getText().toString(), 0);
		setContentView(R.layout.ranking);
	}
	
	public void updateRanking(){
		TextView tv = (TextView) findViewById(R.id.ranking);
		Vector<String> listaRank = puntuaciones.listaPuntuaciones();
		String text = "";
		
		for(String s:listaRank){
			text = text + s +"\n";
		}
		
		tv.setText(text);
		tv.invalidate();
		
	}
	

}
