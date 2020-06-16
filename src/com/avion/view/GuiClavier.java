package com.avion.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.avion.constante.Constante;
import com.avion.constante.NoAnimatedPictures;

public class GuiClavier extends JPanel {

	private JPanel up;
	private JPanel down;
	private JPanel left;
	private JPanel right;

	GuiClavier() {
		initGuiClavier();
	}

	private void initGuiClavier() {

		this.left = new JPanel();
		this.up = new JPanel();
		this.down = new JPanel();
		this.right = new JPanel();

		this.setLayout(new GridLayout(1, 4));
		this.setPreferredSize(new Dimension(Constante.WIDTH, 200));
		left.add(new JLabel(new ImageIcon(NoAnimatedPictures.FLECHE_G_OFF.getUrl())));
		this.add(left);
		this.add(up);
		this.add(down);
		this.add(right);

		left.setBackground(new Color(6, 6, 16));
		up.setBackground(new Color(6, 6, 16));
		down.setBackground(new Color(6, 6, 16));
		right.setBackground(new Color(6, 6, 16));

	}
}
