package lab7;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI {
	
	int _xxx=1; // //the index of checking who's turn, start odd= 1 
	
	public GUI(){
		// build up 2D ArrayList
		ArrayList<ArrayList<JLabel>> myList = new ArrayList<ArrayList<JLabel>>(); // for ImageIcon
		ArrayList<JLabel> tempList = new ArrayList<JLabel>();
		ArrayList<ArrayList<Integer>> checkList = new ArrayList<ArrayList<Integer>>(); // for check result index number
		ArrayList<Integer> checktempList = new ArrayList<Integer>();
		// build up a Frame
		JFrame mainWindow = new JFrame("CSE115-Lab 7-Chihkai Wang");
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.setSize(470,560);
		mainWindow.setVisible(true);
		mainWindow.setLayout(new BoxLayout(mainWindow.getContentPane(),BoxLayout.Y_AXIS));//set the Layout of Frame
		// first Panel for Label
		JPanel panel= new JPanel();
	    panel.setLayout(new FlowLayout());
	    mainWindow.add(panel);
	    // second Panel for buttons and Icons
	    JPanel p= new JPanel();
	    p.setLayout(new GridLayout(7, 7, 5, 5));
	    mainWindow.add(p);
	    // third Panel for result button
	    JPanel p_result= new JPanel();
	    p_result.setLayout(new GridLayout(1, 1, 5, 5));
	    mainWindow.add(p_result);
		// Design of Label 
		JLabel player_name = new JLabel("PLAYER 1 TURN");
		player_name.setBounds(0, 0, 470, 150);
		panel.add(player_name);	
		// Design of result button
		JButton b_result = new JButton("Click to play again");
		b_result.setBounds(0, 0, 470, 150);
		p_result.add(b_result);
		b_result.addActionListener(new Resetgame(myList,checkList,p_result,player_name));
		p_result.setVisible(false);  // hide the result button before someone win the game 
		// Design of buttons
		JButton b1 = new JButton("Col1");
		p.add(b1);
		JButton b2 = new JButton("Col2");
		p.add(b2);
		JButton b3 = new JButton("Col3");
		p.add(b3);
		JButton b4 = new JButton("Col4");
		p.add(b4);
		JButton b5 = new JButton("Col5");
		p.add(b5);
		JButton b6 = new JButton("Col6");
		p.add(b6);
		JButton b7 = new JButton("Col7");
		p.add(b7);

		lab7.Game game= new Game(myList,checkList,p_result,_xxx,b1,b2,b3,b4,b5,b6,b7,player_name); //one ActionLinster for seven buttons 
		b1.addActionListener(game);
		b2.addActionListener(game);
		b3.addActionListener(game);
		b4.addActionListener(game);
		b5.addActionListener(game);
		b6.addActionListener(game);
		b7.addActionListener(game);
		// Design of Icon
		ImageIcon blankicon = new ImageIcon("images/blank.png");	// build up a blank ImageIcon
		for (int i=0;   i<=5;  i++)
		{
			for(int j=0; j<=6; j++)
			{
				JLabel aa = new JLabel(blankicon);
				tempList.add(aa); //put the JLabel into tempList (one row -------)
				checktempList.add(0); // set 0 into checktempList for check the result in the future
			}
			myList.add(tempList); //put entire tempList into myList (one column,¡õ), it become 2D ArrayList 
			tempList = new ArrayList<JLabel>();
			checkList.add(checktempList);
			checktempList = new ArrayList<Integer>();
		}
		// add all element of myList into p Panel
		for (int i=0;   i<=5;  i++)
		{
			for(int j=0; j<=6; j++)
			{
				p.add(myList.get(i).get(j));
			}
		}	
		
	}

}
