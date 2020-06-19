package com.avion.dialog;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Replay {
	int result = 1;

	public Replay(JFrame frame) {

		int dialogButton = JOptionPane.YES_NO_OPTION;
		int dialogResult = JOptionPane.showConfirmDialog(frame, "Replay?", "Replay", dialogButton);
		if (dialogResult == 0) {
			result = 0;

		} else {
			result = 1;
		}
	}

	public int getResult() {
		return result;
	}

}
