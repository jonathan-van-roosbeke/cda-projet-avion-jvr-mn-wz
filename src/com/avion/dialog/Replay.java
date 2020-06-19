package com.avion.dialog;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Replay extends UIManager {
	int result = 1;

	public Replay(JFrame frame) {

		// this.put("OptionPane.background", new ColorUIResource(6, 6, 16));
		// this.put("Panel.background", new ColorUIResource(6, 6, 16));

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
