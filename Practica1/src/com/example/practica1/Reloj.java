package com.example.practica1;

import android.app.Activity;
import android.widget.TextView;

public class Reloj {
	public String minutos = "00", segundos = "00";
	int cont = 0;
	
	public Activity tablero;
	
	Reloj(Activity tablero){
		this.tablero = tablero;
	}
	
	Reloj(Activity tablero, int cont){
		this.tablero = tablero;
		this.cont = cont;
	}

	public void run() {
		// TODO Auto-generated method stub
		TextView relojview = (TextView)tablero.findViewById(R.id.tiempoview);
		minutos = calcularMinutos(++cont);
		segundos = calcularSegundos(cont);
		relojview.setText(minutos + ":" + segundos);
		relojview.invalidate();
		
				
	}
	
	public String calcularMinutos(int cont){
		int minutos = cont/60;
		if(minutos < 10){
			return "0" + Integer.toString(minutos);
		}
		return Integer.toString(minutos);
		
	}

	public String calcularSegundos(int cont) {
		int segundos = cont%60;
		if(segundos < 10){
			return "0" + Integer.toString(segundos);
		}
		return Integer.toString(segundos);
					
		}

	public int getCont() {
		return cont;
	}


}
