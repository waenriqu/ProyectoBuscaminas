package com.example.buscaminasremix;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;

public class Jugador_S extends Jugador {

	public Jugador_S(String string, String tiempo,
			Context c) {
		super(string,tiempo, c);
	}
	
	public Jugador_S(String string, String tiempo) {
		super(string,tiempo);
	}

	public void guardarPuntuacionSurvival(){
    	String text = nombre + ";" + tiempo + "\n";
    	File file = new File(c.getFilesDir(), ranks);
    	try {
			FileWriter f = new FileWriter(file, true);
			f.write(text);
			f.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	
}
	
	public ArrayList<Jugador> cargarPuntuacionSurvival(){
		FileInputStream in;
			try {
				in = c.openFileInput(ranks);
				return cargarListSurvivor(in);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}     			
}
	@Override
	public int compare(Object arg0, Object arg1) {
		Jugador j0 = (Jugador) arg0;
		Jugador j1 = (Jugador) arg1;
		if(Integer.parseInt(j0.getTiempo()) > Integer.parseInt(j1.getTiempo())){
			return -1;
		}
		if(Integer.parseInt(j0.getTiempo()) == Integer.parseInt(j1.getTiempo())){
			return 0;
		}
		return 1;
	}
}
