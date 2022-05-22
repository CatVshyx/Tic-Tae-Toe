package VisualTTT;

import javax.swing.*;
import java.awt.event.*;

public class VisualEngine implements ActionListener {
	private MainFrame parent;
	TTT ttt = new TTT();
	private Player player1 = new Player("x");
	private Player player2 = new Player("o");
	private Player[] plArray = {player1, player2};
	VisualEngine(MainFrame parent){
		this.parent = parent;
	}
	public void clearGame(){            
		for (JButton[] elements : parent.getButtonList()) {
			for (JButton el : elements) {
				el.setEnabled(true);
				el.setIcon(null);
			}
		}
		parent.bFinishMove.setIcon(null);
		ttt.clearMap();
	}
	public void winMethod(Player activePlayer) {
		int answer = JOptionPane.showConfirmDialog(null,activePlayer.getName()+ " Won. NextRound?", "Just Title",JOptionPane.YES_NO_OPTION);
		activePlayer.addCount();
		if ( answer == 0) { clearGame(); }
		else {
			JOptionPane.showInternalMessageDialog(null, "Your place will be blocked , to unblock it -> clear", "Warning", JOptionPane.INFORMATION_MESSAGE);
			for (JButton[] ar : parent.getButtonList()) {
				for (JButton el : ar) {
					el.setEnabled(false);
					}
				}
				parent.bFinishMove.setIcon(null);
			}
	}
	public Player[] getPlayers() { return plArray; }
	public void actionPerformed(ActionEvent e) {
		JButton clickedButton = (JButton)e.getSource();
		Player activePlayer = ttt.choosePlayer(parent.bFinishMove,plArray);
		plArray[0].setMoved(false);
		plArray[1].setMoved(false);
		activePlayer.setMoved(true);
		for (int x = 0; x < parent.getButtonList().length; x++) {
			for (int y = 0; y < parent.getButtonList()[x].length; y++) {
				if (clickedButton != parent.getButtonList()[x][y])  continue; 
				if (!ttt.getMap()[x][y].equals("*")) { 
					JOptionPane.showConfirmDialog(null, "This place is already taken , take another", "Warning", JOptionPane.PLAIN_MESSAGE);
					return;
				}
				ttt.getMap()[x][y] = activePlayer.getFigure();
				clickedButton.setIcon(activePlayer.getImage());
				ttt.showTextMap();
				break;
			}
		}
		boolean win = ttt.checkMap(activePlayer);
		if ( win ) {
			this.winMethod(activePlayer);
		}else if ( !win && !ttt.isEmpty() ) {
			JOptionPane.showConfirmDialog(null,
				" no won", "Warning",
					JOptionPane.PLAIN_MESSAGE);
			clearGame();
		}
		
	}
	
}
