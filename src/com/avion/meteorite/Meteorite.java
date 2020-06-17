package com.avion.meteorite;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.avion.constante.NoAnimatedPictures;
import com.avion.model.Position;
import com.avion.outils.MakeImage;

public class Meteorite extends JPanel {
	private Position position;
	private ImageIcon image;
	private int vitesse;
	private int degat;
	private int taille;
	private int valeurPoint;

	public Meteorite(Position position, NoAnimatedPictures imageUrl, int vitesse, int degat, int taille,
			int valeurPoint) {
		JPanel p = new JPanel();
		this.position = position;
		System.out.println(this.position.getX());
		this.image = new ImageIcon(MakeImage.getTheImage(imageUrl));
		this.image = MakeImage.getScaledImage(image.getImage(), 100, 100);
		this.vitesse = vitesse;
		this.degat = degat;
		this.taille = taille;
		this.valeurPoint = valeurPoint;

		setLayout(null);
		setLocation(0, 0);
		add(new JLabel(this.image));

		p.setVisible(true);
		p.add(this);
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(int x, int y) {
		this.position.setX(x);
		this.position.setY(y);
	}

	public int getDegat() {
		return degat;
	}

	public int getTaille() {
		return taille;
	}

	public int getValeurPoint() {
		return valeurPoint;
	}

	public ImageIcon getImage() {
		return image;
	}

	public int getVitesse() {
		return vitesse;
	}

}
