package com.example.buscaminasremix;

import android.content.Context;

public class TableroSurvival extends ImageAdapter{
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
		    R.drawable.oculto, R.drawable.oculto};
	
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
		            new Casilla(), new Casilla(),
		            new Casilla(), new Casilla()};
	 
	 public TableroSurvival(Context c, int imgSize){
			super(c,imgSize);
			mThumbIds = graphics;
			tablero = emptyBoard;
			distX = 12;
			revelados = 0;
			nMinas = 15;
			
		}
	 
	 public TableroSurvival(Context c, int imgSize, Casilla[] array, Integer[] graphics, int revelados){
			super(c,imgSize);
			tablero = array;
			mThumbIds = graphics;
			this.graphics = null;
			this.emptyBoard = null;
			distX = 12;
			nMinas = 15;
			this.revelados = revelados;
		}
	 
	 @Override
	 public void setNMinas(){
			nMinas += 2;
		}
	
}
