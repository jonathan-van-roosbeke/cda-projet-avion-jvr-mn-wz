package com.avion.meteorite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.avion.constante.NoAnimatedPictures;
import com.avion.outils.MakeImage;

public abstract class Meteorite extends JLabel {
	private ImageIcon image;
//	private int vitesse;
//	private int degat;
//	protected int taille;
//	private int valeurPoint;
	private static Meteorite[] m = { new MeteoriteSimple(), new MeteoriteDeFeu(), new MeteoriteZigzag(),
			new MeteoriteDeGlace(), new MeteoriteIceberg() };
	public static List<Meteorite> meteorites = new ArrayList<>(Arrays.asList(m));

	public Meteorite(NoAnimatedPictures imageUrl) {
		this.image = new ImageIcon(MakeImage.getTheImage(imageUrl));
		this.image = MakeImage.getScaledImage(image.getImage(), 100, 100);
//		this.vitesse = getVitesse();
//		this.degat = getDegat();
//		this.taille = getTaille();
//		this.valeurPoint = getValeur();
		this.image = MakeImage.getScaledImage(new ImageIcon(imageUrl.getUrl()).getImage(), getTaille(), getTaille());
		this.setIcon(this.image);
		this.setSize(100, 100);
	}

	public abstract int getDegat();

	public abstract int getTaille();

	public abstract int getValeur();

	public abstract int getVitesse();
}
