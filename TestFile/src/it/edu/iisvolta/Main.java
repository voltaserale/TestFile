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
			FileWriter fw=new FileWriter("prodotti.csv");	//crea un file di nome prodotti.txt
			fw.write("Pane;3.50;20\n");			//scrive una riga nel file
			fw.write("Pasta;1.60;45\n");
			fw.write("Biscotti;4.70;80\n");
			fw.write("Salame;35;37\n");
			fw.close();					//chiude il file	
			System.out.println("File correttamente creato");
		} catch (IOException e) {
			System.out.println("Si è verificato un errore in fase di creazione file!");
			e.printStackTrace();
		}
		
		//*****  LETTURA DA UN FILE *****
		File f=new File("prodotti.csv");
		String[] dati;
		try {
			Scanner sc=new Scanner(f);		//questo scanner non legge dalla tastiera, bensì dal file f
			String riga;
			while (sc.hasNextLine()) { //ripeti finché ci sono righe da leggere
				riga=sc.nextLine();		//leggi una riga dal file
				dati=riga.split(";");	//divide la stringa in più pezzi usando il carattere ";" come separatore
				System.out.println("Trovato prodotto:\n");
				System.out.println("  Nome: "+dati[0]);
				System.out.println("  Prezzo: "+dati[1]);
				System.out.println("  Quantità: "+dati[2]);
				System.out.println("\n");
			}
			sc.close();  //chiudi il file
			System.out.println("\n\nLettura terminata.");
		} catch (FileNotFoundException e) {
			System.out.println("Si è verificato un errore in fase di lettura!"); 
			e.printStackTrace();
		}
	}

}
