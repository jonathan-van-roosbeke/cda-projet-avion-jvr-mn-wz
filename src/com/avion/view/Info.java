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
	JLabel name;
	private static JLabel scoreLabel = new JLabel();
	private static JLabel life = new JLabel();
	private static int score;

	public Info() {

		setLayout(new GridLayout(1, 3));
		setOpaque(false);

		name = new JLabel();
		name.setForeground(new Color(242, 242, 242));
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setFont(new Font("Roboto", Font.BOLD, 20));
		this.add(name);
		name.setText("Name : " + WelcomeController.getName());

		scoreLabel.setForeground(new Color(242, 242, 242));
		scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		scoreLabel.setFont(new Font("Roboto", Font.BOLD, 20));
		this.add(scoreLabel);
		scoreLabel.setText("Name : " + WelcomeController.getName());
		scoreLabel.setText("Score : 000");

		life.setForeground(new Color(242, 242, 242));
		life.setHorizontalAlignment(SwingConstants.CENTER);
		life.setFont(new Font("Roboto", Font.BOLD, 20));
		this.add(life);
		life.setText("Name : " + WelcomeController.getName());
		life.setText("Life : " + MeteoritesMoving.getLife());
	}

	public static void setLife(int nb) {
		nb = MeteoritesMoving.getLife();
		Info.life.setText("Life : " + Integer.toString(nb));
	}

	public static void setScore(int nb) {
		String str = Integer.toString(nb);
		int strLen = str.length();
		if (strLen < 3) {
			while (strLen < 3) {
				StringBuffer sb = new StringBuffer();
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
