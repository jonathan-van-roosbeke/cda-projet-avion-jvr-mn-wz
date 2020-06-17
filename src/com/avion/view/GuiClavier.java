package com.avion.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.avion.constante.Constante;
import com.avion.constante.NoAnimatedPictures;
import com.avion.outils.Outils;

public class GuiClavier extends JPanel {

	private List<JPanel> flechesOff = new ArrayList<>();
	private List<JPanel> flechesOn = new ArrayList<>();
	private BufferedImage flecheOff;
	private BufferedImage flecheOn;

	GuiClavier() {
		initGuiClavier();
	}

	private void initGuiClavier() {

		for (int i = 0; i < 4; i++) {
			JPanel initPanelOff = new JPanel();
			JPanel initPanelOn = new JPanel();
			initPanelOff.setLayout(new BorderLayout());
			initPanelOff.setBackground(new Color(6, 6, 16));
			initPanelOn.setLayout(new BorderLayout());
			initPanelOn.setBackground(new Color(6, 6, 16));
			try {
				flecheOff = ImageIO.read(new File(NoAnimatedPictures.FLECHE_OFF.getUrl()));
				flecheOn = ImageIO.read(new File(NoAnimatedPictures.FLECHE_ON.getUrl()));

				switch (i) {
				case 0:
					initPanelOff.add(new JLabel(Outils.imageRotation((BufferedImage) flecheOff, 0.0)));
					initPanelOn.add(new JLabel(Outils.imageRotation((BufferedImage) flecheOn, 0.0)));
					break;

				case 1:

					initPanelOff.add(new JLabel(Outils.imageRotation((BufferedImage) flecheOff, 90.0)));
					initPanelOn.add(new JLabel(Outils.imageRotation((BufferedImage) flecheOn, 90.0)));
					break;

				case 2:
					initPanelOff.add(new JLabel(Outils.imageRotation((BufferedImage) flecheOff, 270.0)));
					initPanelOn.add(new JLabel(Outils.imageRotation((BufferedImage) flecheOn, 270.0)));
					break;

				case 3:
					initPanelOff.add(new JLabel(Outils.imageRotation((BufferedImage) flecheOff, 180.0)));
					initPanelOn.add(new JLabel(Outils.imageRotation((BufferedImage) flecheOn, 180.0)));
					break;
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
			flechesOff.add(initPanelOff);
			flechesOn.add(initPanelOn);
			this.add(initPanelOff);
		}

		this.setLayout(new GridLayout(1, 4));
		this.setPreferredSize(new Dimension(Constante.WIDTH, 150));
	}

	public void initBouton(JPanel pPanel, String pUrl) {
		pPanel.setLayout(new BorderLayout());
		pPanel.add(new JLabel(new ImageIcon(pUrl)));
	}

	public List<JPanel> getFlechesOff() {
		return flechesOff;
	}

	public JPanel getJpanelOff(int pIndex) {
		return flechesOff.get(pIndex);
	}

	public JPanel getJpanelOn(int pIndex) {
		return flechesOn.get(pIndex);
	}

	public void changeOffToOn(int pInt) {
		System.out.println(this.getComponents()[3]);
		this.remove(0);

	}

	public List<JPanel> getPanelsOff() {
		return flechesOff;
	}

	public BufferedImage getFlecheOn() {
		return flecheOn;
	}

	public BufferedImage getFlecheOff() {
		return flecheOff;
	}

}
