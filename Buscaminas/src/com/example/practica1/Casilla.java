package com.example.practica1;

public class Casilla {
    int tipo;
    Boolean oculta;
    int posX;
    int posY;
    
    public Casilla(){
        tipo = 0;
        oculta = true;
    }
    
    public void cambiarTipo(int nuevoTipo){
    tipo = nuevoTipo;
    }

    public void cambiarEstado(){
        oculta = false;
    }
    
    
    //Método para conseguir la posición X de la casilla.
    public int getPosX(){
    	return posX;
    }
    
    
    //Método para conseguir la posición Y de la casilla.
    public int getPosY(){
    	return posY;
    }

    //Método para asignar posicion x de la casilla
    public void setPosX(int x){
    	posX = x;
    }
    
    //Método para determinar la posición de la casilla en el tablero.
    public void obtenerPosicion(int x, String dif){
    	
    	
    	
    }
    
}
