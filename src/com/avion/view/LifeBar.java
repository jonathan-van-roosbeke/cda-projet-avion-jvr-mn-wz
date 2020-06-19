package com.avion.view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.avion.constante.NoAnimatedPictures;
import com.avion.model.MeteoritesMoving;
import com.avion.outils.MakeImage;

public class LifeBar extends JPanel {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private static JLabel l1 = new JLabel();
	private static JLabel l2 = new JLabel();
	private static JLabel l3 = new JLabel();
	private static JLabel l4 = new JLabel();
	private static JLabel l5 = new JLabel();

	public LifeBar() {
		setLayout(new GridLayout(1, 5));

		setBackground(new Color(6, 6, 16));

		l1.setIcon(new ImageIcon(MakeImage.getTheImage(NoAnimatedPictures.VIE_01_ON)));
		l1.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(l1);

		l2.setIcon(new ImageIcon(MakeImage.getTheImage(NoAnimatedPictures.VIE_02_ON)));
		l2.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(l2);

		l3.setIcon(new ImageIcon(MakeImage.getTheImage(NoAnimatedPictures.VIE_03_ON)));
		l3.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(l3);

		l4.setIcon(new ImageIcon(MakeImage.getTheImage(NoAnimatedPictures.VIE_04_ON)));
		l4.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(l4);

		l5.setIcon(new ImageIcon(MakeImage.getTheImage(NoAnimatedPictures.VIE_05_ON)));
		l5.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(l5);

		setVisible(true);
	}

	public static void setLifeBar(int nb) {
		nb = MeteoritesMoving.getLife();

		if (nb < 80) {
			l5.setIcon(new ImageIcon(MakeImage.getTheImage(NoAnimatedPictures.VIE_05_OFF)));
			l5.setHorizontalAlignment(SwingConstants.CENTER);
		}
		if (nb < 60) {
			l4.setIcon(new ImageIcon(MakeImage.getTheImage(NoAnimatedPictures.VIE_04_OFF)));
			l4.setHorizontalAlignment(SwingConstants.CENTER);
		}
		if (nb < 40) {
			l3.setIcon(new ImageIcon(MakeImage.getTheImage(NoAnimatedPictures.VIE_03_OFF)));
			l3.setHorizontalAlignment(SwingConstants.CENTER);
		}
		if (nb < 20) {
			l2.setIcon(new ImageIcon(MakeImage.getTheImage(NoAnimatedPictures.VIE_02_OFF)));
			l2.setHorizontalAlignment(SwingConstants.CENTER);
		}
		if (nb < 5) {
			l1.setIcon(new ImageIcon(MakeImage.getTheImage(NoAnimatedPictures.VIE_01_OFF)));
			l1.setHorizontalAlignment(SwingConstants.CENTER);
		}
	}

	public static void initLifeBar() {
		l1.setIcon(new ImageIcon(MakeImage.getTheImage(NoAnimatedPictures.VIE_01_ON)));
		l1.repaint();
		l2.setIcon(new ImageIcon(MakeImage.getTheImage(NoAnimatedPictures.VIE_02_ON)));
		l2.repaint();
		l3.setIcon(new ImageIcon(MakeImage.getTheImage(NoAnimatedPictures.VIE_03_ON)));
		l3.repaint();
		l4.setIcon(new ImageIcon(MakeImage.getTheImage(NoAnimatedPictures.VIE_04_ON)));
		l4.repaint();
		l5.setIcon(new ImageIcon(MakeImage.getTheImage(NoAnimatedPictures.VIE_05_ON)));
		l5.repaint();
	}
}
