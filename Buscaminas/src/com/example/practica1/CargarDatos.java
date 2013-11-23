package com.example.practica1;

public class CargarDatos {
	int cont;
	CharSequence time;
	Casilla [] board;
	Integer [] graphics;
	
	public CargarDatos(int c, CharSequence r, Casilla [] t, Integer[] g){
		this.cont=c;
		this.time=r;
		this.board=t;
		this.graphics=g;
	}

	public int getCont() {
		return cont;
	}

	public CharSequence getTime() {
		return time;
	}

	public Casilla[] getBoard() {
		return board;
	}
	
	public Integer[] getGraphics() {
		return graphics;
	}

	
}
