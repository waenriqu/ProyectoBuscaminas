package com.example.practica1;

public class CargarDatos {
	int cont, revelados, vidas, combo;
	double barrier;
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
	
	public CargarDatos(int c, CharSequence r, Casilla [] t, Integer[] g, boolean perdiste, int revelados, int vidas, double barrier, int combo){
		this.cont=c;
		this.time=r;
		this.board=t;
		this.graphics=g;
		this.finish = perdiste;
		this.revelados = revelados;
		this.vidas = vidas;
		this.barrier = barrier;
		this.combo = combo;
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
	
	public double getBarrier() {
		return barrier;
	}
	
	public int getVidas() {
		return vidas;
	}
	
	public int getCombo() {
		return combo;
	}
	
}
