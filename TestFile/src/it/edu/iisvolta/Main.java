package it.edu.iisvolta;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		
		//*****  SCRITTURA SU UN FILE *****
		try {
			FileWriter fw=new FileWriter("prodotti.txt");	//crea un file di nome prodotti.txt
			fw.write("Pane\n");			//scrive una riga nel file
			fw.write("Pasta\n");
			fw.write("Biscotti\n");
			fw.write("Salame\n");
			fw.close();					//chiude il file	
			System.out.println("File correttamente creato");
		} catch (IOException e) {
			System.out.println("Si è verificato un errore in fase di creazione file!");
			e.printStackTrace();
		}
		
		//*****  LETTURA DA UN FILE *****
		File f=new File("prodotti.txt");
		try {
			Scanner sc=new Scanner(f);		//questo scanner non legge dalla tastiera, bensì dal file f
			String riga;
			while (sc.hasNextLine()) { //ripeti finché ci sono righe da leggere
				riga=sc.nextLine();		//leggi una riga dal file
				System.out.println("Trovato prodotto: "+riga);
			}
			sc.close();  //chiudi il file
			System.out.println("\n\nLettura terminata.");
		} catch (FileNotFoundException e) {
			System.out.println("Si è verificato un errore in fase di lettura!"); 
			e.printStackTrace();
		}
	}

}
