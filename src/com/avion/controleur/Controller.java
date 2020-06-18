package com.avion.controleur;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.avion.constante.AnimatedPictures;
import com.avion.constante.Constante;
import com.avion.constante.Constante.DIRECTION;
import com.avion.constante.Constante.HORIZONTAL;
import com.avion.constante.Constante.VERTICAL;
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
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			affichageFleche(1);
//			moveVaisseauUp();
			ver = VERTICAL.UP;
			break;

		case KeyEvent.VK_DOWN:
			affichageFleche(2);
//			moveVaisseauDown();
			ver = VERTICAL.DOWN;
			break;

		case KeyEvent.VK_LEFT:
			affichageFleche(0);
//			moveVaisseauLeft();
			changeImageDirection(1);
			hor = HORIZONTAL.LEFT;
			break;

		case KeyEvent.VK_RIGHT:
			affichageFleche(3);
//			moveVaisseauRight();
			changeImageDirection(2);
			hor = HORIZONTAL.RIGHT;
			break;

		default:
			break;
		}

		if (ver == null && hor == HORIZONTAL.RIGHT) {
			dir = DIRECTION.RIGHT;
//			moveVaisseauRight();
		} else if (ver == null && hor == HORIZONTAL.LEFT) {
			dir = DIRECTION.LEFT;
//			moveVaisseauLeft();
		} else if (hor == null && ver == VERTICAL.UP) {
			dir = DIRECTION.UP;
//			moveVaisseauUp();
		} else if (hor == null && ver == VERTICAL.DOWN) {
			dir = DIRECTION.DOWN;
//			moveVaisseauDown();
		} else if (hor == HORIZONTAL.RIGHT && ver == VERTICAL.UP) {
			dir = DIRECTION.UP_RIGHT;
//			moveVaisseauUpRight();
		} else if (hor == HORIZONTAL.RIGHT && ver == VERTICAL.DOWN) {
			dir = DIRECTION.DOWN_RIGHT;
//			moveVaisseauDownRight();
		} else if (hor == HORIZONTAL.LEFT && ver == VERTICAL.UP) {
			dir = DIRECTION.UP_LEFT;
//			moveVaisseauUpLeft();
		} else if (hor == HORIZONTAL.LEFT && ver == VERTICAL.DOWN) {
			dir = DIRECTION.DOWN_LEFT;
//			moveVaisseauDownLeft();
		}

		move(dir);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			upReleased(1);
			ver = null;
			break;

		case KeyEvent.VK_DOWN:
			upReleased(2);
			ver = null;
			break;

		case KeyEvent.VK_LEFT:
			upReleased(0);
			resetImageDirection();
			hor = null;
			break;

		case KeyEvent.VK_RIGHT:
			upReleased(3);
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

		}
		clavier.getJpanelOff(pIndex).repaint();
	}

//	private void moveVaisseauUp() {
//		vaisseau.setLocation(vaisseau.getX(), vaisseau.getY() - Constante.VAISSEAU_SPEED);
//	}
//
//	private void moveVaisseauDown() {
//		vaisseau.setLocation(vaisseau.getX(), vaisseau.getY() + Constante.VAISSEAU_SPEED);
//	}
//
//	private void moveVaisseauLeft() {
//		vaisseau.setLocation(vaisseau.getX() - Constante.VAISSEAU_SPEED, vaisseau.getY());
//	}
//
//	private void moveVaisseauRight() {
//		vaisseau.setLocation(vaisseau.getX() + Constante.VAISSEAU_SPEED, vaisseau.getY());
//	}
//
//	private void moveVaisseauUpRight() {
//		vaisseau.setLocation(vaisseau.getX() + Constante.VAISSEAU_SPEED, vaisseau.getY() - Constante.VAISSEAU_SPEED);
//	}
//
//	private void moveVaisseauUpLeft() {
//		vaisseau.setLocation(vaisseau.getX() - Constante.VAISSEAU_SPEED, vaisseau.getY() - Constante.VAISSEAU_SPEED);
//	}
//
//	private void moveVaisseauDownRight() {
//		vaisseau.setLocation(vaisseau.getX() + Constante.VAISSEAU_SPEED, vaisseau.getY() + Constante.VAISSEAU_SPEED);
//	}
//
//	private void moveVaisseauDownLeft() {
//		vaisseau.setLocation(vaisseau.getX() - Constante.VAISSEAU_SPEED, vaisseau.getY() + Constante.VAISSEAU_SPEED);
//	}

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
		}
		if (pos.x >= Constante.WIDTH - vaisseau.getWidth() || pos.x < 0
				|| pos.y >= Constante.HEIGHT - vaisseau.getHeight() - Constante.HEIGHT_CLAVIER - 90 || pos.y < 0)
			return;

		vaisseau.setLocation(pos);
		vaisseau.validate();
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
