package com.example.practica1;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Ranking {
	
	public void SavePlayers(){
		String archivo = "ranking";
		String sr;
		File f;
		FileWriter fw;
		Scanner teclado= new Scanner(System.in);
		ArrayList <String> players = new ArrayList<String>();
		
		try {
			fw= new FileWriter( new File(archivo), false);
			System.out.println("Ingrese el nombre: ");	
			sr = teclado.nextLine() + "," + " 12";
			players.add(sr);
			fw.append(sr);
			fw.close();
		} catch (Exception ex) {}
		
	}

}
