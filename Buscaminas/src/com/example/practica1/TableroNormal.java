package com.example.practica1;

import android.content.Context;

public class TableroNormal extends ImageAdapter{
	 protected Integer[] graphics = {
	            //00
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            //10
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            //20
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            //30
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            //40
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            //50
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            //60
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            //70
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            //80
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            //90
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            //100
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            //110
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            //120
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            //130
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            //140
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto
	             
	             
	    };
	//Crea un tablero normal con celdas ocultas.
	public TableroNormal(Context c, int imgSize){
		super(c,imgSize);
		mThumbIds = graphics;
		tablero = new Casilla[graphics.length];
		for(Casilla i: tablero){
			i = new Casilla();
			}
		distX = 16;
		
	}
	
	//Crea un tablero normal con celdas guardadas anteriormente.
	public TableroNormal(Context c, int imgSize, Casilla[] array, Integer[] graphics){
		super(c,imgSize);
		tablero = array;
		mThumbIds = graphics;
	}}
