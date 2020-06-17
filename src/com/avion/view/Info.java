package com.avion.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Info extends JPanel {

	public Info() {

		setLayout(new GridLayout(1, 3));
		setOpaque(false);

		for (int i = 0; i < 3; i++) {
			JLabel label = new JLabel();
			label.setForeground(new Color(242, 242, 242));
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setFont(new Font("Roboto", Font.BOLD, 20));
			this.add(label);

			switch (i) {
			case 0:
				label.setText("Name : ");
				break;
			case 1:
				label.setText("Score : ");
				break;
			case 2:
				label.setText("Life : ");
				break;
			}
		}
	}
}
