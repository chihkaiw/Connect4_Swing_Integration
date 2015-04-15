package lab7;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Resetgame implements ActionListener { 
	ArrayList<ArrayList<JLabel>> _myList;
	ArrayList<ArrayList<Integer>> _checkList;
	JPanel _p_result;
	int _xxx;
	JLabel _player_name;
	
	private final int _reset=0; // reset all component in checkList to 0 
	ImageIcon blankicon_reset = new ImageIcon("images/blank.png");	//  reset all component in myList to blank

public Resetgame(ArrayList<ArrayList<JLabel>> myList, ArrayList<ArrayList<Integer>> checkList, JPanel p_result,JLabel player_name){
	
	_myList=myList;
	_checkList=checkList;
	_p_result=p_result;
	_player_name=player_name;
}

@Override
public void actionPerformed(ActionEvent arg0) {
	
	for (int i=0;   i<=5;  i++)
	{
		for(int j=0; j<=6; j++)
		{
			_myList.get(i).get(j).setIcon(blankicon_reset);
			_checkList.get(i).set(j, _reset);
		}
	}
	_p_result.setVisible(false); // let b_result disappear
	_player_name.setText("START PLAYER 1 TURN");// reset the Label
	
	
}
}