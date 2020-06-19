package com.avion.outils;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.ImageIcon;

public abstract class Outils {
	private Outils() {

	}

	public static ImageIcon imageRotation(BufferedImage image, Double degrees) {
		// Calculate the new size of the image based on the angle of rotaion
		double radians = Math.toRadians(degrees);
		double sin = Math.abs(Math.sin(radians));
		double cos = Math.abs(Math.cos(radians));
		int newWidth = (int) Math.round(image.getWidth() * cos + image.getHeight() * sin);
		int newHeight = (int) Math.round(image.getWidth() * sin + image.getHeight() * cos);

		// Create a new image
		BufferedImage rotate = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = rotate.createGraphics();

		// Calculate the "anchor" point around which the image will be rotated
		int x = (newWidth - image.getWidth()) / 2;
		int y = (newHeight - image.getHeight()) / 2;

		// Transform the origin point around the anchor point
		AffineTransform at = new AffineTransform();
		at.setToRotation(radians, x + (image.getWidth() / 2), y + (image.getHeight() / 2));
		at.translate(x, y);
		g2d.setTransform(at);

		// Paint the originl image
		g2d.drawImage(image, 0, 0, null);
		g2d.dispose();
		return new ImageIcon(rotate);
	}

	public static void writeFile(String str) {
		String path = System.getProperty("user.dir").toString() + "/temp/record.txt";
		File temp = new File(System.getProperty("user.dir") + "/temp");
		File file = new File(path);
		RandomAccessFile randomFile = null;

		if (!temp.exists()) {
			temp.mkdir();
		}

		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try {
			randomFile = new RandomAccessFile(path, "rw");
			long fileLength = randomFile.length();
			randomFile.seek(fileLength);
			randomFile.writeBytes(str);
			randomFile.close();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (randomFile != null) {
				try {
					randomFile.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static String getDate() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		return dtf.format(LocalDateTime.now());
	}

	public static List<String> readFile() {
		String path = "temp/record.txt";

		ArrayList<String> listName = new ArrayList<String>();
		ArrayList<Integer> listScore = new ArrayList<Integer>();
		ArrayList<String> listDate = new ArrayList<String>();
		ArrayList<String> sorted = new ArrayList<String>(20);

		try {
			File file = new File(path);
			FileInputStream fis = new FileInputStream(file);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(isr);

			String str;
			String[] line;

			while ((str = br.readLine()) != null) {
				line = str.split(";");
				listName.add(line[0]);
				listScore.add(Integer.parseInt(line[1]));
				listDate.add(line[2]);
			}

			br.close();
			isr.close();
			fis.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Collections.sort(listScore, Collections.reverseOrder());

		if (listScore.size() < 20) {
			for (int i = 0; i < listScore.size(); i++) {
				String str = Integer.toString(listScore.get(i)) + "," + listName.get(i) + "," + listDate.get(i);
				sorted.add(str);
			}
		} else {
			for (int i = 0; i < 20; i++) {
				String str = Integer.toString(listScore.get(i)) + "," + listName.get(i) + "," + listDate.get(i);
				sorted.add(str);
			}
		}

		return sorted;
	}
}
