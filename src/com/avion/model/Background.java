package com.avion.model;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

import com.avion.constante.Constante;
import com.avion.constante.NoAnimatedPictures;
import com.avion.outils.MakeImage;

public class Background {
	private BufferedImage image;

	private int x;
	private int y;

	public Background() {
		this(0, 0);
	}

	public Background(int x, int y) {
		this.x = x;
		this.y = y;
		image = MakeImage.convertToBufferedImage(
				new ImageIcon(getClass().getResource(NoAnimatedPictures.BACKGROUND.getUrl())).getImage());
	}

	public void draw(Graphics window) {
		// Dessine l'image
		window.drawImage(image, getX(), getY(), image.getWidth(), image.getHeight(), null);
		// Déplacement en y
		this.y += Constante.BACKGROUD_SPEED;
		// Check si l'image est sorti du cadre
		if (this.y >= image.getHeight()) {
			// Si c'est le cas alligner le bas de l'image
			// avec le haut de l'image du bg
			this.y = this.y - image.getHeight() * 2;
		}
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public int getImageWidth() {
		return image.getWidth();
	}

	public int getImageHeight() {
		return image.getHeight();
	}
}