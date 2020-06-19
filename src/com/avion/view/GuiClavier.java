package com.avion.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.avion.constante.Constante;
import com.avion.constante.NoAnimatedPictures;
import com.avion.outils.MakeImage;
import com.avion.outils.Outils;

public class GuiClavier extends JPanel {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private List<JPanel> flechesOff = new ArrayList<>();
	private List<JPanel> flechesOn = new ArrayList<>();
	private BufferedImage flecheOff;
	private BufferedImage flecheOn;

	public GuiClavier() {
		initGuiClavier();
	}

	private void initGuiClavier() {

		for (int i = 0; i < 4; i++) {
			this.setBackground(new Color(6, 6, 16));
			JPanel initPanelOff = new JPanel();
			JPanel initPanelOn = new JPanel();
			initPanelOff.setLayout(new BorderLayout());
			initPanelOff.setBackground(new Color(6, 6, 16));
			initPanelOn.setLayout(new BorderLayout());
			initPanelOn.setBackground(new Color(6, 6, 16));
			flecheOff = MakeImage.getTheImage(NoAnimatedPictures.FLECHE_OFF);
			flecheOn = MakeImage.getTheImage(NoAnimatedPictures.FLECHE_ON);

			switch (i) {
			case 0:
				initPanelOff.add(new JLabel(Outils.imageRotation(flecheOff, 0.0)));
				initPanelOn.add(new JLabel(Outils.imageRotation(flecheOn, 0.0)));
				break;
			case 1:
				initPanelOff.add(new JLabel(Outils.imageRotation(flecheOff, 90.0)));
				initPanelOn.add(new JLabel(Outils.imageRotation(flecheOn, 90.0)));
				break;
			case 2:
				initPanelOff.add(new JLabel(Outils.imageRotation(flecheOff, 270.0)));
				initPanelOn.add(new JLabel(Outils.imageRotation(flecheOn, 270.0)));
				break;
			case 3:
				initPanelOff.add(new JLabel(Outils.imageRotation(flecheOff, 180.0)));
				initPanelOn.add(new JLabel(Outils.imageRotation(flecheOn, 180.0)));
				break;
			default:
				break;
			}
			flechesOff.add(initPanelOff);
			flechesOn.add(initPanelOn);
			this.add(initPanelOff);
		}

		this.setLayout(new GridLayout(1, 4));
		this.setPreferredSize(new Dimension(Constante.WIDTH, Constante.HEIGHT_CLAVIER));
	}

	public JPanel getJpanelOff(int pIndex) {
		return flechesOff.get(pIndex);
	}

	public JPanel getJpanelOn(int pIndex) {
		return flechesOn.get(pIndex);
	}

	public BufferedImage getFlecheOff() {
		return flecheOff;
	}

}
