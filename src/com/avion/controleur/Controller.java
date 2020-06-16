package com.avion.controleur;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JLabel;

import com.avion.outils.Outils;
import com.avion.view.GuiClavier;

public class Controller implements KeyListener {

	private GuiClavier clavier;

	public Controller(GuiClavier pClavier) {
		this.clavier = pClavier;
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			upPressed(1);
			break;

		case KeyEvent.VK_DOWN:
			upPressed(2);
			break;

		case KeyEvent.VK_LEFT:
			upPressed(0);
			break;

		case KeyEvent.VK_RIGHT:
			upPressed(3);
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
			break;

		case KeyEvent.VK_RIGHT:
			upReleased(3);
			break;

		default:
			break;
		}

	}

	private void upPressed(int pIndex) {
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
}
