package VisualTTT;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.*;

public class ConfigFrame extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MainFrame v;
	private JTextField tx1, tx2;
	private JLabel lb1, lb2;
	private JButton bStart;
	ConfigFrame(MainFrame parent){
		v = parent;
		tx1 = new JTextField(10);
		tx2 = new JTextField(10);
		lb1 = new JLabel("Player 1:");
		lb2 = new JLabel("Player 2:");
		bStart = new JButton("Start");
		bStart.addActionListener(this);
		
		Image im = new ImageIcon(TTT.getImageO()).getImage();
		im = im.getScaledInstance(25,25, Image.SCALE_SMOOTH);
		lb1.setIcon(new ImageIcon(im));
		
		Image im2 = new ImageIcon(TTT.getImageX()).getImage();
		im2 = im2.getScaledInstance(25,25, Image.SCALE_SMOOTH);
		lb2.setIcon(new ImageIcon(im2));
		JPanel dialogPanel = new JPanel(new FlowLayout());
		JPanel workingSpice = new JPanel(new BorderLayout());
		dialogPanel.add(lb1);
		dialogPanel.add(tx1);
		dialogPanel.add(lb2);
		dialogPanel.add(tx2);
		workingSpice.add("North", new JLabel("Please write names for players"));
		workingSpice.add("South", bStart);
		workingSpice.add("Center", dialogPanel);
        this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
        this.setContentPane(workingSpice);
        this.setSize(200, 200);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		if (tx1.getText().length() < 2 || tx2.getText().length() < 2) {
			JOptionPane.showInternalMessageDialog(null, "Please , not so short names", "Warning", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		Player[] playerArray = v.engine.getPlayers();
		playerArray[0].setName(tx1.getText());
		v.lbName1.setText("Player: "+ tx1.getText());
		playerArray[0].countLabel = v.lbRes1;
		playerArray[1].setName(tx2.getText());
		v.lbName2.setText("Player: "+ tx2.getText());
		playerArray[1].countLabel = v.lbRes2;
		this.dispose();
		v.startGame();
	}
	
}
