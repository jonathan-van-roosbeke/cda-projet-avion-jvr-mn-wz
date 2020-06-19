package com.avion.dialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.avion.constante.Constante;

public class Welcome extends JDialog {

	public static boolean isChecked;

	public Welcome() {
		final JDialog modelDialog = new JDialog(this, "Bienvenue", Dialog.ModalityType.TOOLKIT_MODAL);
		modelDialog.setResizable(false);

		modelDialog.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		this.setPreferredSize(new Dimension(300, 300));

		Container dialogContainer = modelDialog.getContentPane();

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.setBackground(Constante.BACKGROUND_COLOR);

		JPanel textsPanenl = new JPanel();
		textsPanenl.setLayout(new FlowLayout());
		textsPanenl.setBackground(Constante.BACKGROUND_COLOR);

		JLabel text = new JLabel("Ton nom : ");
		text.setFont(new Font("Roboto", Font.BOLD, 20));

		JLabel error = new JLabel();
		JTextField saisie = new JTextField(6);

		text.setForeground(Constante.TEXT_COLOR);

		error.setForeground(Color.RED);
		error.setFont(new Font("Roboto", Font.ITALIC, 12));
		error.setHorizontalAlignment(JLabel.CENTER);

		textsPanenl.add(text);
		textsPanenl.add(saisie);

		JLabel imageLabel = new JLabel(new ImageIcon(
				getScaledImage(new ImageIcon(getClass().getResource("/images/validate/ok.png")).getImage(), 20, 20)));
		textsPanenl.add(imageLabel);

		JCheckBox checkBoxClavier = new JCheckBox("Affichage clavier");
		checkBoxClavier.setBackground(Constante.BACKGROUND_COLOR);
		checkBoxClavier.setHorizontalAlignment(JLabel.CENTER);
		checkBoxClavier.setFont(new Font("Roboto", Font.CENTER_BASELINE, 15));
		checkBoxClavier.setForeground(Color.WHITE);

		mainPanel.add(error, BorderLayout.SOUTH);
		mainPanel.add(textsPanenl, BorderLayout.NORTH);
		mainPanel.add(checkBoxClavier, BorderLayout.CENTER);

		// verifie si la checkbox est active
		checkBoxClavier.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					isChecked = true;

				} else {
					isChecked = false;
				}
			}
		});

		imageLabel.addMouseListener(new WelcomeController(saisie, error));
		saisie.addKeyListener(new WelcomeController(saisie, error));

		dialogContainer.add(mainPanel);
		modelDialog.setBounds((Toolkit.getDefaultToolkit().getScreenSize().width - 250) / 2,
				(Toolkit.getDefaultToolkit().getScreenSize().height - 80) / 2, 350, 150);
		modelDialog.setVisible(true);

	}

	private Image getScaledImage(Image srcImg, int w, int h) {
		BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = resizedImg.createGraphics();
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.drawImage(srcImg, 0, 0, w, h, null);
		g2.dispose();
		return resizedImg;
	}
}