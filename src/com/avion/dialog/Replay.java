package com.avion.dialog;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Replay extends UIManager {
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	int result = 1;

	public Replay(JFrame frame) {
		int dialogButton = JOptionPane.YES_NO_OPTION;
		int dialogResult = JOptionPane.showConfirmDialog(frame, "Replay?", "Replay", dialogButton);
		result = dialogResult;
	}

	public int getResult() {
		return result;
	}
}
