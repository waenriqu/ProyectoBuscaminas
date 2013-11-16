package com.example.practica1;

import java.util.TimerTask;

public class Reloj extends TimerTask {
	public String tiempo = "00:00";

	@Override
	public void run() {
		// TODO Auto-generated method stub
		ultimoDigitoPlus(4);
				
	}
	
	public void ultimoDigitoPlus(int pos){
		char digit = tiempo.charAt(pos);
		char[] array = tiempo.toCharArray();
		if(digit < 9){
			array[pos] = ++digit;
			tiempo = array.toString();
		} else{
			array[pos] = 0;
			tiempo = array.toString();
			penultimoDigitoPlus(pos-1);
		}
		
	}

	public void penultimoDigitoPlus(int pos) {
		char digit = tiempo.charAt(pos);
		char[] array = tiempo.toCharArray();
		if(digit < 6){
			array[pos] = ++digit;
			tiempo = array.toString();
		} else{
			array[pos] = 0;
			tiempo = array.toString();
			if(pos>2){
			ultimoDigitoPlus(pos-2);
			} else{
				array[pos] = 9;
				tiempo = array.toString();
		}
	}

	
		
	}

}
