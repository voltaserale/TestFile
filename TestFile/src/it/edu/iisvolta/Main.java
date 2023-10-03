package it.edu.iisvolta;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String risp;
		Negozio n=new Negozio();
		
		do {
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			System.out.println("Gestione prodotti\n");
			System.out.println("1 - visualizza prodotti");
			System.out.println("2 - carica prodotti");
			System.out.println("3 - salva prodotti");
			System.out.println("4 - aggiungi prodotto");
			System.out.println("\n9 - esci");
			System.out.print("Inserisci la tua scelta: ");
			risp=sc.nextLine();
			switch(risp) {
			case "1":
				System.out.println("Elenco prodotti:");
				for(Prodotto p:n.elencoProdotti())
				{
					System.out.println("Prodotto: "+p.getDescrizione());
					System.out.println(" Prezzo: "+p.getPrezzo());
					System.out.println(" Quantità: "+p.getQuantità()+"\n");
				}
				// n.elencoProdotti=null;   //non si può fare!!!
				
				break;
			case "2":
				n.carica("prodotti.csv");
				break;
			case "3":
				n.salva("prodotti.csv");
				break;
			case "4":
				Prodotto nuovoProd=new Prodotto();
				System.out.print("Inserisci la descrizione: ");
				nuovoProd.setDescrizione(sc.nextLine());
				System.out.print("Inserisci il prezzo: ");
				nuovoProd.setPrezzo(Double.parseDouble(sc.nextLine()));
				System.out.print("Inserisci la quantità: ");
				nuovoProd.setQuantità(Integer.parseInt(sc.nextLine()));
				n.aggiungiProdotto(nuovoProd);
				break;
			case "9":
				System.out.println("Arrivederci!");
				break;
			default:
				System.out.println("Scelta non valida!");
			}
			System.out.println("Premi Enter per continuare...");
			sc.nextLine();
		} while (!risp.equals("9"));
			
	}

}
