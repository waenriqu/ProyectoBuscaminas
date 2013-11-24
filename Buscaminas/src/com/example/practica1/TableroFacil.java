package com.example.practica1;

import android.content.Context;

public class TableroFacil extends ImageAdapter{
	
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
            R.drawable.oculto,
             
             
    };
	
	protected Casilla[] emptyBoard = {
            //00
            new Casilla(), new Casilla(),
            new Casilla(), new Casilla(),
            new Casilla(), new Casilla(),
            new Casilla(), new Casilla(),
            new Casilla(), new Casilla(),
            //10
            new Casilla(), new Casilla(),
            new Casilla(), new Casilla(),
            new Casilla(), new Casilla(),
            new Casilla(), new Casilla(),
            new Casilla(), new Casilla(),
            //20
            new Casilla(), new Casilla(),
            new Casilla(), new Casilla(),
            new Casilla(), new Casilla(),
            new Casilla(), new Casilla(),
            new Casilla(), new Casilla(),
            //30
            new Casilla(), new Casilla(),
            new Casilla(), new Casilla(),
            new Casilla(), new Casilla(),
            new Casilla(), new Casilla(),
            new Casilla(), new Casilla(),
            //40
            new Casilla(), new Casilla(),
            new Casilla(), new Casilla(),
            new Casilla(), new Casilla(),
            new Casilla(), new Casilla(),
            new Casilla(), new Casilla(),
            //50
            new Casilla(), new Casilla(),
            new Casilla(), new Casilla(),
            new Casilla(), new Casilla(),
            new Casilla(), new Casilla(),
            new Casilla(), new Casilla(),
            //60
            new Casilla(), new Casilla(),
            new Casilla(), new Casilla(),
            new Casilla(), new Casilla(),
            new Casilla(), new Casilla(),
            new Casilla(), new Casilla(),
            //70
            new Casilla(), new Casilla(),
            new Casilla(), new Casilla(),
            new Casilla(), new Casilla(),
            new Casilla(), new Casilla(),
            new Casilla(), new Casilla(),
            //80
            new Casilla()
             
             
    };
	
	//Crea un tablero fácil con celdas ocultas.
	public TableroFacil(Context c, int imgSize){
		super(c,imgSize);
		mThumbIds = graphics;
		tablero = emptyBoard;
		distX = 9;
	}
	
	//Crea un tablero fácil con celdas guardadas anteriormente.
	public TableroFacil(Context c, int imgSize, Casilla[] array, Integer[] graphics){
		super(c,imgSize);
		tablero = array;
		mThumbIds = graphics;
		this.graphics = null;
		this.emptyBoard = null;
		distX = 9;
	}
	
	
	

}
