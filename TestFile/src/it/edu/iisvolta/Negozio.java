package it.edu.iisvolta;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Negozio {
	private ArrayList<Prodotto> elencoProdotti=new ArrayList<Prodotto>();
	
	public void aggiungiProdotto(Prodotto p) {
		if (p.getPrezzo()>0 && 
				p.getQuantità()>0 &&
				p.getDescrizione().length()>0)
			elencoProdotti.add(p);
	}
	
	public void salva(String nomeFile) {
		//*****  SCRITTURA SU UN FILE *****
		try {
			FileWriter fw=new FileWriter(nomeFile);	//crea un file di nome prodotti.txt
			for(Prodotto p:elencoProdotti)
				fw.write(	//scrivo una riga di prodotto per ogni elemento della lista
					p.getDescrizione()+";"+
					p.getPrezzo()+";"+
					p.getQuantità()+"\n"
					);			
			fw.close();					//chiude il file	
			System.out.println("File correttamente creato");
		} catch (IOException e) {
			System.out.println("Si è verificato un errore in fase di creazione file!");
			e.printStackTrace();
		}
	}
	
	public void carica(String nomeFile) {
		//*****  LETTURA DA UN FILE *****
		File f=new File(nomeFile);
		String[] dati;
		try {
			Scanner sc=new Scanner(f);		//questo scanner non legge dalla tastiera, bensì dal file f
			String riga;
			while (sc.hasNextLine()) { //ripeti finché ci sono righe da leggere
				riga=sc.nextLine();		//leggi una riga dal file
				dati=riga.split(";");	//divide la stringa in più pezzi usando il carattere ";" come separatore
				Prodotto p=new Prodotto();
				p.setDescrizione(dati[0]);
				p.setPrezzo(Double.parseDouble(dati[1]));
				p.setQuantità(Integer.parseInt(dati[2]));
				elencoProdotti.add(p);		//aggiungo il prodotto alla lista
			}
			sc.close();  //chiudi il file
			System.out.println("\n\nLettura terminata.");
		} catch (FileNotFoundException e) {
			System.out.println("Si è verificato un errore in fase di lettura!"); 
			e.printStackTrace();
		}
	}
	
	public Iterable<Prodotto> elencoProdotti() {		//restituisce una versione in sola lettura (Iterable) della lista dei prodotti
		return this.elencoProdotti;
	}
 }
