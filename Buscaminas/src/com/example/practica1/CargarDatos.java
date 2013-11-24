package com.example.practica1;

public class CargarDatos {
	int cont;
	CharSequence time;
	Casilla [] board;
	Integer [] graphics;
	boolean perdiste;
	
	public CargarDatos(int c, CharSequence r, Casilla [] t, Integer[] g, boolean perdiste){
		this.cont=c;
		this.time=r;
		this.board=t;
		this.graphics=g;
		this.perdiste = perdiste;
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

	public boolean getPerdiste(){
		return perdiste;
	}
}
