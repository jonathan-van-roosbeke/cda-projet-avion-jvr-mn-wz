package com.avion.meteorite;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.avion.constante.NoAnimatedPictures;
import com.avion.outils.MakeImage;

public abstract class Meteorite extends JLabel {
	private ImageIcon image;
	NoAnimatedPictures imageUrl;
	BufferedImage bufferedImage;
	private static Meteorite[] m = { new MeteoriteSimple(), new MeteoriteDeFeu(), new MeteoriteZigzag(),
			new MeteoriteDeGlace(), new MeteoriteIceberg() };

	public static List<Meteorite> meteorites = new ArrayList<>(Arrays.asList(m));

	public Meteorite() {
		this.imageUrl = getImageUrl();
		this.bufferedImage = MakeImage.getTheImage(imageUrl);
		this.image = new ImageIcon(MakeImage.getTheImage(imageUrl));
		this.setIcon(this.image);
	}

	public BufferedImage getImage() {
		return resize(bufferedImage, getTaille(), getTaille());
	}

	public static BufferedImage resize(BufferedImage img, int newW, int newH) {
		Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
		BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

		Graphics2D g2d = dimg.createGraphics();
		g2d.drawImage(tmp, 0, 0, null);
		g2d.dispose();

		return dimg;
	}

	public abstract int getDegat();

	public abstract int getTaille();

	public abstract int getValeur();

	public abstract int getVitesse();

	public abstract NoAnimatedPictures getImageUrl();
}
