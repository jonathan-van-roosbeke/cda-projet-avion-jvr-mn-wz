package com.avion.outils;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import com.avion.constante.NoAnimatedPictures;
import com.avion.model.Spacecraft;

public class MakeImage {
	private static BufferedImage image;

	public static BufferedImage getTheImage(NoAnimatedPictures pic) {

		try {
			image = ImageIO.read(Spacecraft.class.getResourceAsStream(pic.getUrl()));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return image;
	}

	public static ImageIcon getScaledImage(Image srcImg, int w, int h) {
		BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = resizedImg.createGraphics();
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.drawImage(srcImg, 0, 0, w, h, null);
		g2.dispose();
		return new ImageIcon(resizedImg);
	}

	public static BufferedImage convertToBufferedImage(Image image) {
		BufferedImage newImage = new BufferedImage(image.getWidth(null), image.getHeight(null),
				BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = newImage.createGraphics();
		g.drawImage(image, 0, 0, null);
		g.dispose();
		return newImage;
	}
}
