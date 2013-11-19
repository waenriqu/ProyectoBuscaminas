package com.example.practica1;

import android.content.Context;

public class TableroFacil extends ImageAdapter{
	protected Integer[] tablero = {
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
	public TableroFacil(Context c, int imgSize){
		super(c,imgSize);
		mThumbIds = tablero;
	}

}
