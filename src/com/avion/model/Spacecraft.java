package com.avion.model;

import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.avion.constante.AnimatedPictures;
import com.avion.constante.Constante;

public class Spacecraft extends JLabel {

	private BufferedImage imgVaisseau;
	private BufferedImage imgReacteur;
	private JLabel vaisseau;
	private JLabel reacteur;
	private int choixImgVaisseau;

	public Spacecraft() {

		try {
			imgVaisseau = ImageIO
					.read(Spacecraft.class.getResourceAsStream(AnimatedPictures.tVaisseau[choixImgVaisseau]));
			imgReacteur = ImageIO.read(Spacecraft.class.getResourceAsStream(AnimatedPictures.tReacteur[0]));
		} catch (IOException e) {
			e.printStackTrace();
		}

		vaisseau = new JLabel(new ImageIcon(imgVaisseau));
		reacteur = new JLabel(new ImageIcon(imgReacteur));

		setLocation((Constante.WIDTH / 2) - (Constante.VAISSEAU_WIDTH / 2),
				(Constante.HEIGHT - Constante.HEIGHT_CLAVIER) - Constante.VAISSEAU_HEIGHT - 200);

		this.setLayout(new BorderLayout());
		this.add(vaisseau, "Center");
		this.add(reacteur, "South");

		this.setSize(Constante.VAISSEAU_WIDTH, Constante.VAISSEAU_HEIGHT + 18);
	}

	public BufferedImage getImgVaisseau() {
		return imgVaisseau;
	}

	public void setChoixVaisseau(int pChoix) {
		this.choixImgVaisseau = pChoix;
	}

	public JLabel getVaisseau() {
		return vaisseau;
	}
}
