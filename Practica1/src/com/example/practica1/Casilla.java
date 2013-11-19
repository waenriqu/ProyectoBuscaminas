package com.example.practica1;

public class Casilla {
    int tipo;
    String img;
    Boolean oculta;
    
    public Casilla(){
        tipo = 0;
        oculta = true;
    }
    
    public void cambiarTipo(int nuevoTipo){
    tipo = nuevoTipo;
    }

    public void cambiarEstado(){
        oculta = false;
        cambiarImagen();
    }
    
    public void cambiarImagen(){
        
    }
    
}
