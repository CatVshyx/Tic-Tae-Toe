package VisualTTT;
import java.awt.*;

import javax.swing.*;
public class MainFrame {
	private JButton[][]  buttonList = new JButton[3][3];; 
	JButton  bFinishMove;
	VisualEngine engine = new VisualEngine(this);
	JLabel lbRes1, lbRes2;
	JLabel lbName1 , lbName2;
	JFrame jf;
	MainFrame(){
		ConfigFrame cf = new ConfigFrame(this);
		JPanel pl1 = new JPanel();
		pl1.setLayout(new GridLayout(3,3));
		for (int i = 0; i< 3; i++) {
			for (int x = 0 ; x < 3; x++) {
				buttonList[i][x] = new JButton();
				buttonList[i][x].setIcon(new ImageIcon());
				buttonList[i][x].setBackground(Color.white);
				buttonList[i][x].setOpaque(true);
				buttonList[i][x].addActionListener(engine);
				pl1.add(buttonList[i][x]);
			}
		}
		JPanel pl3 = new JPanel();
		pl3.setLayout(new GridLayout(4,1,5,5));
		lbRes1 = new JLabel("Count:   ");
		lbRes2 = new JLabel("Count:   ");
		lbName1 = new JLabel("Player "+ engine.getPlayers()[0].getName());
		lbName2 = new JLabel("Player "+ engine.getPlayers()[1].getName());
		
		
		Image im = new ImageIcon(TTT.getImageX()).getImage();
		im = im.getScaledInstance(25,25, Image.SCALE_SMOOTH);
		lbName1.setIcon(new ImageIcon(im));
		
		
		Image im2 = new ImageIcon(TTT.getImageO()).getImage();
		im2 = im2.getScaledInstance(25,25, Image.SCALE_SMOOTH);
		lbName2.setIcon(new ImageIcon(im2));
		
		pl3.add(lbName1);
		pl3.add(lbRes1);
		pl3.add(lbName2);
		pl3.add(lbRes2);
		

		JPanel pl2 = new JPanel();
		pl2.setLayout(new GridLayout(1,2));
		JButton bClear = new JButton("Clear");
		bClear.addActionListener((e) -> engine.clearGame() );
		bFinishMove= new JButton("is turning");
		bFinishMove.setHorizontalTextPosition(JButton.CENTER);
		bFinishMove.setVerticalTextPosition(JButton.BOTTOM);
		pl2.add(bClear);
		pl2.add(bFinishMove);
		JPanel workingSpace = new JPanel();
		workingSpace.setLayout(new BorderLayout());
		workingSpace.add("Center", pl1);
		workingSpace.add("South" , pl2);
		workingSpace.add("East", pl3);
		
		jf = new JFrame("TTT");
		jf.setSize(500,500);
		jf.setLocationRelativeTo(null);
		jf.setContentPane(workingSpace);
		jf.setResizable(false);
		
	}
	 JButton[][] getButtonList(){
		return buttonList;
	};
	 void startGame() {
		jf.setVisible(true);
	}
}
