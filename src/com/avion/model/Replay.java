package com.avion.model;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.avion.view.GameView;

public class Replay {
	public Replay(JFrame frame) {
		int dialogButton = JOptionPane.YES_NO_OPTION;
		int dialogResult = JOptionPane.showConfirmDialog(frame, "Replay?", "Replay", dialogButton);
		if (dialogResult == 0) {
			System.out.println("Yes option");
			GameView gameView = new GameView(true);
			gameView.init();
		} else {
			System.out.println("No Option");
		}
	}
}
