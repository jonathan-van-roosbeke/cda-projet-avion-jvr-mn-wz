package com.avion.meteorite;

public enum Properties {
	METEORITE_SIMPLE(9, 2, 2, 70), METEORITE_DE_GLACE(9, 2, 2, 80), METEORITE_ICEBERG(5, 2, 2, 90),
	METEORITE_DE_FEU(7, 2, 2, 100), METEORITE_ZIGZAG(4, 2, 2, 110);

	int vitesse;
	int degat;
	int valeur;
	int taille;

	private Properties(int vitesse, int degat, int valeur, int taille) {
		this.vitesse = vitesse;
		this.degat = degat;
		this.valeur = valeur;
		this.taille = taille;
	}

	public int getVitesse() {
		return vitesse;
	}

	public int getDegat() {
		return degat;
	}

	public int getValeur() {
		return valeur;
	}

	public int getTaille() {
		return taille;
	}

}
