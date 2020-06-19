package com.avion.controleur;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.avion.constante.AnimatedPictures;
import com.avion.constante.Constante;
import com.avion.constante.Constante.DIRECTION;
import com.avion.constante.Constante.HORIZONTAL;
import com.avion.constante.Constante.VERTICAL;
import com.avion.dialog.Welcome;
import com.avion.model.Spacecraft;
import com.avion.outils.Outils;
import com.avion.view.GuiClavier;

public class Controller implements KeyListener {

	private GuiClavier clavier;
	private Spacecraft vaisseau;
	DIRECTION dir;
	HORIZONTAL hor;
	VERTICAL ver;

	public Controller(GuiClavier pClavier, Spacecraft pVaisseau) {
		this.clavier = pClavier;
		this.vaisseau = pVaisseau;
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		switchKey(e);

		testDir();

		move(dir);
	}

	public void testDir() {
		if (ver == null && hor == HORIZONTAL.RIGHT) {
			dir = DIRECTION.RIGHT;
		} else if (ver == null && hor == HORIZONTAL.LEFT) {
			dir = DIRECTION.LEFT;
		} else if (hor == null && ver == VERTICAL.UP) {
			dir = DIRECTION.UP;
		} else if (hor == null && ver == VERTICAL.DOWN) {
			dir = DIRECTION.DOWN;
		} else if (hor == HORIZONTAL.RIGHT && ver == VERTICAL.UP) {
			dir = DIRECTION.UP_RIGHT;
		} else if (hor == HORIZONTAL.RIGHT && ver == VERTICAL.DOWN) {
			dir = DIRECTION.DOWN_RIGHT;
		} else if (hor == HORIZONTAL.LEFT && ver == VERTICAL.UP) {
			dir = DIRECTION.UP_LEFT;
		} else if (hor == HORIZONTAL.LEFT && ver == VERTICAL.DOWN) {
			dir = DIRECTION.DOWN_LEFT;
		} else if (hor == null && ver == null) {
			dir = DIRECTION.CENTER;
		}
	}

	public void switchKey(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			if (Welcome.isChecked) {
				affichageFleche(1);
			}
			affichageFleche(1);
			ver = VERTICAL.UP;
			break;

		case KeyEvent.VK_DOWN:
			if (Welcome.isChecked) {
				affichageFleche(2);
			}
			affichageFleche(2);
			ver = VERTICAL.DOWN;
			break;

		case KeyEvent.VK_LEFT:
			if (Welcome.isChecked) {
				affichageFleche(0);
			}
			affichageFleche(0);
			changeImageDirection(1);
			hor = HORIZONTAL.LEFT;
			break;

		case KeyEvent.VK_RIGHT:
			if (Welcome.isChecked) {
				affichageFleche(3);
			}
			affichageFleche(3);
			changeImageDirection(2);
			hor = HORIZONTAL.RIGHT;
			break;

		default:
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			if (Welcome.isChecked) {
				upReleased(1);
			}
			ver = null;
			break;

		case KeyEvent.VK_DOWN:
			if (Welcome.isChecked) {
				upReleased(2);
			}
			ver = null;
			break;

		case KeyEvent.VK_LEFT:
			if (Welcome.isChecked) {
				upReleased(0);
			}
			resetImageDirection();
			hor = null;
			break;

		case KeyEvent.VK_RIGHT:
			if (Welcome.isChecked) {
				upReleased(3);
			}
			resetImageDirection();
			hor = null;
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
			clavier.getJpanelOff(pIndex).add(new JLabel(Outils.imageRotation(clavier.getFlecheOff(), 0.0)));
			break;

		case 1:
			clavier.getJpanelOff(pIndex).add(new JLabel(Outils.imageRotation(clavier.getFlecheOff(), 90.0)));
			break;

		case 2:
			clavier.getJpanelOff(pIndex).add(new JLabel(Outils.imageRotation(clavier.getFlecheOff(), 270.0)));
			break;

		case 3:
			clavier.getJpanelOff(pIndex).add(new JLabel(Outils.imageRotation(clavier.getFlecheOff(), 180.0)));
			break;
		default:
			break;

		}
		clavier.getJpanelOff(pIndex).repaint();
	}

	private void move(DIRECTION dir) {
		Point pos = vaisseau.getLocation();

		switch (dir) {
		case UP:
			pos.y -= Constante.VAISSEAU_SPEED;
			break;
		case RIGHT:
			pos.x += Constante.VAISSEAU_SPEED;
			break;
		case DOWN:
			pos.y += Constante.VAISSEAU_SPEED;
			break;
		case LEFT:
			pos.x -= Constante.VAISSEAU_SPEED;
			break;
		case UP_RIGHT:
			pos.x += Constante.VAISSEAU_SPEED;
			pos.y -= Constante.VAISSEAU_SPEED;
			break;
		case DOWN_RIGHT:
			pos.x += Constante.VAISSEAU_SPEED;
			pos.y += Constante.VAISSEAU_SPEED;
			break;
		case DOWN_LEFT:
			pos.x -= Constante.VAISSEAU_SPEED;
			pos.y += Constante.VAISSEAU_SPEED;
			break;
		case UP_LEFT:
			pos.x -= Constante.VAISSEAU_SPEED;
			pos.y -= Constante.VAISSEAU_SPEED;
			break;
		default:
			break;
		}
		if (Welcome.isChecked) {
			if (pos.x >= Constante.WIDTH - vaisseau.getWidth() || pos.x < 0
					|| pos.y >= Constante.HEIGHT - vaisseau.getHeight() - Constante.HEIGHT_CLAVIER - 90 || pos.y < 0)
				return;

			vaisseau.setLocation(pos);
			vaisseau.validate();
		} else {
			if (pos.x >= Constante.WIDTH - vaisseau.getWidth() || pos.x < 0
					|| pos.y >= Constante.HEIGHT - Constante.HEIGHT_CLAVIER - 40 || pos.y < 0)
				return;

			vaisseau.setLocation(pos);
			vaisseau.validate();
		}
	}

	private void changeImageDirection(int pIndex) {
		vaisseau.getVaisseau().removeAll();
		vaisseau.revalidate();
		try {
			vaisseau.getVaisseau().setIcon(new ImageIcon(
					ImageIO.read(Spacecraft.class.getResourceAsStream(AnimatedPictures.tVaisseau[pIndex]))));
		} catch (IOException e) {
			e.printStackTrace();
		}
		vaisseau.repaint();
	}

	private void resetImageDirection() {
		vaisseau.getVaisseau().removeAll();
		vaisseau.revalidate();
		try {
			vaisseau.getVaisseau().setIcon(
					new ImageIcon(ImageIO.read(Spacecraft.class.getResourceAsStream(AnimatedPictures.tVaisseau[0]))));
		} catch (IOException e) {
			e.printStackTrace();
		}
		vaisseau.repaint();
	}
}
