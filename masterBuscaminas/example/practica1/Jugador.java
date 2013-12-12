package com.example.buscaminasremix;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import android.content.Context;
/**
 * Jugador es la clase que se encarga de guardar la información esencial del
 * jugador para el ranking. Sólo toma un String con su nombre y un String con el tiempo
 * que le tomó completar el tablero. Contiene métodos de gestión de archivos para guardar
 * los rankings de diferentes dificultades en sus respectivos archivos y cargarlos y ordernarlos
 * posteriormente para mostrarlos por pantalla
 * 
 * @author      Gabriel Aumala
 * @author		Kevin Zambrano
 */
public class Jugador implements Comparator{
        String nombre, tiempo;
        Context c;
        final String rankf = "RankingFacil.txt";
        final String rankm = "RankingNormal.txt";
        final String rankd = "RankingDificil.txt";
        final String rankx = "RankingRemix.txt";
        /**
    	 * Crea un nuevo objeto Jugador inicializando todos los parametros, su nombre, el tiempo
    	 * y el contexto de la actividad, indispensable para trabajar con archivos privados.
    	 * @para nombre El nombre del jugador
    	 * @param tiempo El tiempo que le tomó al jugador completar el tablero
    	 * @param  c  el contexto de la actividad
    	 * @return      Objeto jugador
    	 */
        public Jugador(String nombre, String tiempo, Context c){
        	this.nombre = nombre;
        	this.tiempo = tiempo;
        	this.c = c;
        }
        /**
    	 * Crea un nuevo objeto Jugador inicializando todos los parametros menos el contexto,
    	 * este constructor solo se usa para ordenar la lista de jugadores al usar la interface
    	 * Comparator.
    	 * @para nombre El nombre del jugador
    	 * @param tiempo El tiempo que le tomó al jugador completar el tablero
    	 * @return      Objeto jugador
    	 */
        public Jugador(String nombre, String tiempo){
        	this.nombre = nombre;
        	this.tiempo = tiempo;
        	c = null;
        }
        /**
    	 * Crea un nuevo objeto Jugador inicializando ningún atributo. Se lo usa para obtener acceso
    	 * rápido a los métodos de gestión de archivos y Comparator.
    	 * @return      Objeto jugador
    	 */
        public Jugador(){
        }
        /**
    	 * Retorna un String con el nombre del jugador.
    	 * @return     El nombre del jugador
    	 */
        public String getNombre() {
                return nombre;
        }

        /**
    	 * Retorna un String con el tiempo del jugador.
    	 * @return     El nombre del jugador
    	 */
        public String getTiempo() {
                return tiempo;
        }

        /**
    	 * Abre un archivo privado para guardar las puntuaciones del modo fácil. 
    	 * Guarda los atributos nombre y tiempo con un formato especial. Posteriormente
    	 * se cierra el archivo.
    	 */        
        public void guardarPuntuacionFacil(){
        	String text = nombre + ";" + tiempo + "\n";
        	File file = new File(c.getFilesDir(), rankf);
        	try {
				FileWriter f = new FileWriter(file, true);
				f.write(text);
				f.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
        }
        /**
    	 * Abre un archivo privado para guardar las puntuaciones del modo normal. 
    	 * Guarda los atributos nombre y tiempo con un formato especial. Posteriormente
    	 * se cierra el archivo.
    	 */   	
        public void guardarPuntuacionNormal(){
            	String text = nombre + ";" + tiempo + "\n";
            	File file = new File(c.getFilesDir(), rankm);
            	try {
    				FileWriter f = new FileWriter(file, true);
    				f.write(text);
    				f.close();
    			} catch (IOException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			} 
        	
        }
        /**
    	 * Abre un archivo privado para guardar las puntuaciones del modo difícil. 
    	 * Guarda los atributos nombre y tiempo con un formato especial. Posteriormente
    	 * se cierra el archivo.
    	 */  
        public void guardarPuntuacionDificil(){
        	String text = nombre + ";" + tiempo + "\n";
        	File file = new File(c.getFilesDir(), rankd);
        	try {
				FileWriter f = new FileWriter(file, true);
				f.write(text);
				f.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
    	
    }
        /**
    	 * Abre un archivo privado para guardar las puntuaciones del modo remix. 
    	 * Guarda los atributos nombre y tiempo con un formato especial. Posteriormente
    	 * se cierra el archivo.
    	 */  
        public void guardarPuntuacionRemix(){
        	String text = nombre + ";" + tiempo + "\n";
        	File file = new File(c.getFilesDir(), rankx);
        	try {
				FileWriter f = new FileWriter(file, true);
				f.write(text);
				f.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
    	
    }
        /**
    	 * Carga las puntuaciones del modo fácil guardadas en el archivo y las retorna en
    	 * lista de objetos jugador.
    	 * @return La lista de objetos jugador que forman parte del ranking
    	 */  
        public ArrayList<Jugador> cargarPuntuacionFacil(){
        	FileInputStream in;
			try {
				in = c.openFileInput(rankf);
				return cargarList(in);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}     
        }
        /**
    	 * Carga las puntuaciones del modo normal guardadas en el archivo y las retorna en
    	 * lista de objetos jugador.
    	 * @return La lista de objetos jugador que forman parte del ranking
    	 */
        public ArrayList<Jugador> cargarPuntuacionNormal(){
        	FileInputStream in;
			try {
				in = c.openFileInput(rankm);
				return cargarList(in);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}     
        }
        /**
    	 * Carga las puntuaciones del modo difícil guardadas en el archivo y las retorna en
    	 * lista de objetos jugador.
    	 * @return La lista de objetos jugador que forman parte del ranking
    	 */
        public ArrayList<Jugador> cargarPuntuacionDificil(){
        	FileInputStream in;
			try {
				in = c.openFileInput(rankd);
				return cargarList(in);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}     
        }
        /**
    	 * Carga las puntuaciones del modo remix guardadas en el archivo y las retorna en
    	 * lista de objetos jugador.
    	 * @return La lista de objetos jugador que forman parte del ranking
    	 */
        public ArrayList<Jugador> cargarPuntuacionRemix(){
        		FileInputStream in;
					try {
						in = c.openFileInput(rankx);
						return cargarList(in);
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						return null;
					}     			
        }
        /**
    	 * Carga las puntuaciones del modo fácil guardadas en el archivo y decodifica su formato
    	 * para separar el string de tiempo del de nombre guardarlos en una nueva instancia de jugador.
    	 * Al terminar de leer el archivo ordena la lista usando el Comparator y la retorna.
    	 * @param in El archivo a ser leído
    	 * @return La lista ordenada de objetos jugador que forman parte del ranking, null si no hay ranking
    	 * o si hubo error con el archivo.
    	 */
        public ArrayList<Jugador> cargarList(FileInputStream in){
        	try{
        		String s1, s2;
        		ArrayList<Jugador> list = new ArrayList<Jugador>();
        		InputStreamReader inputStreamReader = new InputStreamReader(in);
        		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        		StringBuilder sb = new StringBuilder();
        		String line;
        		while ((line = bufferedReader.readLine()) != null) {
        			sb.append(line);
        			s1 = line.subSequence(0, line.indexOf(';')).toString();
        			s2 = line.subSequence(line.indexOf(';')+1,line.length()).toString();
        			list.add(new Jugador(s1, s2));
        		}
        		bufferedReader.close();
        		Collections.sort(list, new Jugador());
        		return list;
			}catch(IOException e){
			e.printStackTrace();
			return null;
		}
        }
        
		@Override
		public int compare(Object arg0, Object arg1) {
			Jugador j0 = (Jugador) arg0;
			Jugador j1 = (Jugador) arg1;
			if(j0.getTiempo().compareTo(j1.getTiempo())<0){
				return -1;
			}
			if(j0.getTiempo().compareTo(j1.getTiempo())==0){
				return 0;
			}
			return 1;
		}

}