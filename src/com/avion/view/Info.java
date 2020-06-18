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
	private static JLabel score;
	private static JLabel life;

	public Info() {

		setLayout(new GridLayout(1, 3));
		setOpaque(false);

		name = new JLabel();
		name.setForeground(new Color(242, 242, 242));
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setFont(new Font("Roboto", Font.BOLD, 20));
		this.add(name);
		name.setText("Name : " + WelcomeController.getName());

		score = new JLabel();
		score.setForeground(new Color(242, 242, 242));
		score.setHorizontalAlignment(SwingConstants.CENTER);
		score.setFont(new Font("Roboto", Font.BOLD, 20));
		this.add(score);
		score.setText("Name : " + WelcomeController.getName());
		score.setText("Score : ");

		life = new JLabel();
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
		Info.score.setText("Score : " + str);
	}

}
