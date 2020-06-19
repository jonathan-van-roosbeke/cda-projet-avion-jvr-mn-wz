package com.avion.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.avion.dialog.WelcomeController;
import com.avion.model.MeteoritesMoving;

public class Info extends JPanel {
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private static final String NAME = "Name : " + WelcomeController.getName();
	private static final Color BACKGOUNG_COLOR = new Color(242, 242, 242);
	private static final Font FONT2 = new Font("Roboto", Font.BOLD, 20);
	JLabel vName;
	private static JLabel scoreLabel = new JLabel();
	private static JLabel life = new JLabel();
	private static int score;

	public Info() {

		setLayout(new GridLayout(1, 3));
		setOpaque(false);

		vName = new JLabel();
		vName.setForeground(BACKGOUNG_COLOR);
		vName.setHorizontalAlignment(SwingConstants.CENTER);
		vName.setFont(FONT2);
		this.add(vName);
		vName.setText(NAME);

		scoreLabel.setForeground(BACKGOUNG_COLOR);
		scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		scoreLabel.setFont(FONT2);
		this.add(scoreLabel);
		scoreLabel.setText(NAME);
		scoreLabel.setText("Score : 000");

		life.setForeground(BACKGOUNG_COLOR);
		life.setHorizontalAlignment(SwingConstants.CENTER);
		life.setFont(FONT2);
		this.add(life);
		life.setText(NAME);
		life.setText("Life : " + MeteoritesMoving.getLife());
	}

	public static void setLife() {
		Info.life.setText("Life : " + Integer.toString(MeteoritesMoving.getLife()));
	}

	public static void setScore(int nb) {
		String str = Integer.toString(nb);
		int strLen = str.length();
		if (strLen < 3) {
			while (strLen < 3) {
				StringBuilder sb = new StringBuilder();
				sb.append("0").append(str);
				str = sb.toString();
				strLen = str.length();
			}
		}
		score = Integer.parseInt(str);
		Info.scoreLabel.setText("Score : " + str);
	}

	public static int getScore() {
		return score;
	}
}
