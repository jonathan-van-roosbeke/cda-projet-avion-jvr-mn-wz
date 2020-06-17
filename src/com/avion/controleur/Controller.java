package com.avion.controleur;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.avion.constante.AnimatedPictures;
import com.avion.constante.Constante;
import com.avion.model.Spacecraft;
import com.avion.outils.Outils;
import com.avion.view.GuiClavier;

public class Controller implements KeyListener {

	private GuiClavier clavier;
	private Spacecraft vaisseau;

	public Controller(GuiClavier pClavier, Spacecraft pVaisseau) {
		this.clavier = pClavier;
		this.vaisseau = pVaisseau;
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			affichageFleche(1);
			moveVaisseauUp();
			break;

		case KeyEvent.VK_DOWN:
			affichageFleche(2);
			moveVaisseauDown();
			break;

		case KeyEvent.VK_LEFT:
			affichageFleche(0);
			moveVaisseauLeft();
			changeImageDirection(1);
			break;

		case KeyEvent.VK_RIGHT:
			affichageFleche(3);
			moveVaisseauRight();
			changeImageDirection(2);
			break;

		default:
			break;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			upReleased(1);
			break;

		case KeyEvent.VK_DOWN:
			upReleased(2);
			break;

		case KeyEvent.VK_LEFT:
			upReleased(0);
			resetImageDirection();
			break;

		case KeyEvent.VK_RIGHT:
			upReleased(3);
			resetImageDirection();
			break;

		default:
			break;
		}

	}

	private void affichageFleche(int pIndex) {
		clavier.getJpanelOff(pIndex).removeAll();
		clavier.getJpanelOff(pIndex).revalidate();
		clavier.getJpanelOff(pIndex).add(clavier.getJpanelOn(pIndex));
		clavier.getJpanelOff(pIndex).repaint();

	}

	private void upReleased(int pIndex) {
		clavier.getJpanelOff(pIndex).removeAll();
		clavier.getJpanelOff(pIndex).revalidate();
		switch (pIndex) {
		case 0:
			clavier.getJpanelOff(pIndex)
					.add(new JLabel(Outils.imageRotation((BufferedImage) clavier.getFlecheOff(), 0.0)));
			break;

		case 1:
			clavier.getJpanelOff(pIndex)
					.add(new JLabel(Outils.imageRotation((BufferedImage) clavier.getFlecheOff(), 90.0)));
			break;

		case 2:
			clavier.getJpanelOff(pIndex)
					.add(new JLabel(Outils.imageRotation((BufferedImage) clavier.getFlecheOff(), 270.0)));
			break;

		case 3:
			clavier.getJpanelOff(pIndex)
					.add(new JLabel(Outils.imageRotation((BufferedImage) clavier.getFlecheOff(), 180.0)));
			break;

		}
		clavier.getJpanelOff(pIndex).repaint();
	}

	private void moveVaisseauUp() {
		vaisseau.setLocation(vaisseau.getX(), vaisseau.getY() - Constante.VAISSEAU_SPEED);
	}

	private void moveVaisseauDown() {
		vaisseau.setLocation(vaisseau.getX(), vaisseau.getY() + Constante.VAISSEAU_SPEED);
	}

	private void moveVaisseauLeft() {
		vaisseau.setLocation(vaisseau.getX() - Constante.VAISSEAU_SPEED, vaisseau.getY());
	}

	private void moveVaisseauRight() {
		vaisseau.setLocation(vaisseau.getX() + Constante.VAISSEAU_SPEED, vaisseau.getY());
	}

	private void changeImageDirection(int pIndex) {
		vaisseau.getVaisseau().removeAll();
		vaisseau.revalidate();
		vaisseau.getVaisseau().setIcon(new ImageIcon(AnimatedPictures.tVaisseau[pIndex]));
		vaisseau.repaint();
	}

	private void resetImageDirection() {
		vaisseau.getVaisseau().removeAll();
		vaisseau.revalidate();
		vaisseau.getVaisseau().setIcon(new ImageIcon(AnimatedPictures.tVaisseau[0]));
		vaisseau.repaint();
	}
}
