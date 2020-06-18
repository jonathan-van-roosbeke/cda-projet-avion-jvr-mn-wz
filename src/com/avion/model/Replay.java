package com.avion.model;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Replay {
	int result = 1;

	public Replay(JFrame frame) {

		int dialogButton = JOptionPane.YES_NO_OPTION;
		int dialogResult = JOptionPane.showConfirmDialog(frame, "Replay?", "Replay", dialogButton);
		if (dialogResult == 0) {
//			System.out.println("Yes option");
//			frame.dispose();
//			new Welcome();
//			SpaceGame.startGame(frame);
			result = 0;

		} else {
//			System.out.println("No Option");
		}
	}

	public int getResult() {
		return result;
	}

}
