package com.example.practica1;

public class CargarDatos {
	int cont, revelados;
	CharSequence time;
	Casilla [] board;
	Integer [] graphics;
	boolean finish;
	
	public CargarDatos(int c, CharSequence r, Casilla [] t, Integer[] g, boolean perdiste, int revelados){
		this.cont=c;
		this.time=r;
		this.board=t;
		this.graphics=g;
		this.finish = perdiste;
		this.revelados = revelados;
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

	public boolean getFinish(){
		return finish;
	}
	
	public int getRevelados() {
		return revelados;
	}
}
