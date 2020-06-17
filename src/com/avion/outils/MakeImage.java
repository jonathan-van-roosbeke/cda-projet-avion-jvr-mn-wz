package com.avion.outils;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import com.avion.constante.NoAnimatedPictures;

public class MakeImage {
	private static BufferedImage image;

	public static BufferedImage getTheImage(NoAnimatedPictures pic) {

		try {
			image = ImageIO.read(new File(pic.getUrl()));
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

}
