package VisualTTT;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.imageio.ImageIO;
import java.awt.Image;
import javax.swing.JButton;

public class TTT {
	private String[][] map = {{"*","*","*"},{"*","*","*"},{"*","*","*"}}; 
	public void showTextMap() {
		System.out.println("  0 1 2");
		for (int x = 0; x < 3; x++) {
			System.out.print(x+" ");
			for (int y = 0 ; y < 3; y ++) {
				System.out.print(map[x][y]+" ");
			}
			System.out.println(" ");
		}
	}
	public Player choosePlayer (JButton bFinishMove,Player[] plArray) {
		if (!plArray[0].isMoved()){
			bFinishMove.setIcon(plArray[1].getImage());
			return plArray[0];	
		}else {
			bFinishMove.setIcon(plArray[0].getImage());
			return plArray[1];
		}
	}
	public boolean isEmpty() {
		for (String[] arr : map) {
			for (String el : arr) {
				if (el.equals("*")) return true;
			}
		}
		return false;
	}
	public boolean checkMap(Player activePlayer) {
		boolean win = false;
		for (int x = 0; x < 3; x++) {
			boolean gWin = true;
			boolean vWin = true;
			for (int y = 0; y < 3; y++) {
				if( !map[x][y].equals(activePlayer.getFigure())) { gWin = false; }
				if (!map[y][x].equals(activePlayer.getFigure())){ vWin = false; }
			}
			win = gWin || vWin;
			if (win)  return win; 
		}
		if ( map[0][0].equals(activePlayer.getFigure()) && map[1][1].equals(activePlayer.getFigure()) && map[2][2].equals(activePlayer.getFigure()) ) 
			win = true;
		else if (map[0][2].equals(activePlayer.getFigure()) && map[1][1].equals(activePlayer.getFigure()) && map[2][0].equals(activePlayer.getFigure())) 
			win = true;
		return win;
	}
	void clearMap() {
		String[][] myMap = {{"*","*","*"},{"*","*","*"},{"*","*","*"}}; 
		map = myMap;
	}
	public String[][] getMap(){
		return map;
	}

	public static Image getImageO(){
		Path p = Paths.get("src\\images\\O.png");
		try {
			return ImageIO.read(new File(p.toAbsolutePath().toString()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	 }
	public  static Image getImageX() {
		 Path p = Paths.get("src\\images\\X.png");
		 try {
			return ImageIO.read(new File(p.toAbsolutePath().toString()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	 }
}
