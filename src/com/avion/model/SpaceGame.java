package com.avion.model;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

public class SpaceGame extends JPanel {

	private static int width = 300;
	private static int heigth = 300;

	public SpaceGame() {
		this.setBackground(Color.YELLOW);

		this.setLayout(null);

		MeteoritePanel m1 = new MeteoritePanel();
		this.add(m1);

		Spacecraft a1 = new Spacecraft();
		this.add(a1);

		a1.setFocusable(true);

		new Thread(new Runnable() {
			public void run() {
				while (true) {
					m1.setLocation(m1.getX(), (m1.getY() + 10) % width);
					m1.repaint();
					try {
						Thread.sleep(300);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();

		a1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int step = 5;
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					a1.setLocation(a1.getX(), a1.getY() - step);
				} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					a1.setLocation(a1.getX(), a1.getY() + step);
				} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					a1.setLocation(a1.getX() + step, a1.getY());
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					a1.setLocation(a1.getX() - step, a1.getY());
				}
			}
		});

	}

}