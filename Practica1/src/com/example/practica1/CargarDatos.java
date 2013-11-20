package com.example.practica1;

public class CargarDatos {
	int cont;
	CharSequence time;
	Object [] board;
	
	public CargarDatos(int c, CharSequence r, Object [] t){
		this.cont=c;
		this.time=r;
		this.board=t;
	}

	public int getCont() {
		return cont;
	}

	public CharSequence getTime() {
		return time;
	}

	public Object[] getBoard() {
		return board;
	}

	
}
