package it.edu.iisvolta;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Negozio {
	ArrayList<Prodotto> elencoProdotti=new ArrayList<Prodotto>();
	
	public void aggiungiProdotto(Prodotto p) {
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
 }
