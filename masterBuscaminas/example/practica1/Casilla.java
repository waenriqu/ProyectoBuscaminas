package com.example.buscaminasremix;
public class Casilla {
    int tipo;
    Boolean oculta;
    Boolean esMina;
    public static final int mina = 9;
    
    
    public Casilla(){
        tipo = 0;
        oculta = true;
        esMina = false;
    }
    
    public void cambiarTipo(int nuevoTipo){
    tipo = nuevoTipo;
    }

    public void cambiarEstado(){
        oculta = false;
    }
    
    public boolean isOculto(){
    	return oculta;
    }

    public boolean getEsMina(){
    	return esMina;
    }
    
    public void setEsMina(boolean esMina){
    	this.esMina = esMina;
    }
    
 
    
    //Método para determinar la posición de la casilla en el tablero.
    public void obtenerPosicion(int x, String dif){
    	
    	
    	
    }
   
    
}
