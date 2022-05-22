package VisualTTT;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Player {
	private String myName;
	private ImageIcon image;
	private String figure;
	boolean isMoved;
	private int count = 0;
	JLabel countLabel;
	Player(String figure){
		this.figure = figure;
		image = figure.equals("x") ? new ImageIcon(TTT.getImageX()) : new ImageIcon(TTT.getImageO());
	}
	public ImageIcon getImage() {
		return image;
	}
	boolean isMoved() {
		return isMoved;
	}
	public void setName(String name) {
		myName = name;
	}
	public String getName() {
		return myName;
	}
	public void addCount() {
		count ++;
		countLabel.setText("Count:  "+count);
	}
	public int getCount() {
		return count;
	}
	public void removeCount() {
		count = 0;
	}
	public String getFigure() {
		return figure;
	}
	public void setFigure(String fig) {
		this.figure = fig;
	}
}
