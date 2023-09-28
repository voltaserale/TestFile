package it.edu.iisvolta;

public class Prodotto {
	private String descrizione;
	private double prezzo;
	private int quantità;
	
	public Prodotto(String descrizione, double prezzo, int quantità) {
		super();
		this.descrizione = descrizione;
		this.prezzo = prezzo;
		this.quantità = quantità;
	}
	
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		if (prezzo>0)
			this.prezzo = prezzo;
	}
	public int getQuantità() {
		return quantità;
	}
	public void setQuantità(int quantità) {
		if (quantità>0)
			this.quantità = quantità;
	}
	
	
	
	
}
