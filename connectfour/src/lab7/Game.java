package lab7;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Game implements ActionListener {
	
	ImageIcon redicon = new ImageIcon("images/red.png");
	ImageIcon yellowicon = new ImageIcon("images/yellow.png");
	
	JButton _b1, _b2,_b3,_b4,_b5,_b6,_b7;
	int _xxx;  //the index of checking who's turn
	ArrayList<ArrayList<JLabel>> _myList;
	ArrayList<ArrayList<Integer>> _checkList;
	JPanel _p_result;
	JLabel _player_name;
	
	int _i1=5, _i2=5, _i3=5, _i4=5, _i5=5, _i6=5, _i0=5;//for remembering which row should we use now 
	int _whichnumber;
	ImageIcon _whichicon; // temp memory for Icon_Color
	
	public Game(ArrayList<ArrayList<JLabel>> myList, ArrayList<ArrayList<Integer>> checkList, JPanel p_result, int xxx,JButton b1,JButton b2, JButton b3,JButton b4,JButton b5,JButton b6, JButton b7, JLabel player_name){
	
		_myList=myList;
		_checkList=checkList;
		_player_name=player_name;
		_p_result=p_result;
		_xxx=xxx;
		_b1=b1;
		_b2=b2;
		_b3=b3;
		_b4=b4;
		_b5=b5;
		_b6=b6;
		_b7=b7;	
	}
	
	 public void actionPerformed(ActionEvent e) {
		
		//check who's turn, even == yellowicon_Player 2_-1, odd == redicon_Player 1_1
		if (_xxx!=0){
			if(_xxx%2==0){
				_whichicon=yellowicon;
				_whichnumber=-1;
				_player_name.setText("PLAYER 1 TURN");
			}
			if(_xxx%2!=0){
				_whichicon=redicon;
				_whichnumber=1;
				_player_name.setText("PLAYER 2 TURN");
			}
		}
		
		JButton b = (JButton)e.getSource(); // !!!!!!  to recognize that we press which button 
	    if( b.equals(_b1) )
		{
	    	if(_i0>=0){
				_myList.get(_i0).get(0).setIcon(_whichicon); // set _myList.get(_i0 row).get(0 column)'s Label become the COLOR of index _whichicon
				_checkList.get(_i0).set(0, _whichnumber);  // set _checkList.get(_i0 row).get(0 column)'s number become the integer of index _whichnumber
				_i0--; // _i0 will count from 5 to 0
				_xxx++;
	    	}
	    	else{
	    		_player_name.setText("STOP to click button 1"); // to prevent from over pressing 
	    	}
		}
		else if(b.equals(_b2))
		{
			if(_i1>=0){
				_myList.get(_i1).get(1).setIcon(_whichicon);
				_checkList.get(_i1).set(1, _whichnumber);
				_i1--;
				_xxx++;
	    	}
	    	else{
	    		_player_name.setText("STOP to click button 2");
	    	}
		}
		else if(b.equals(_b3))
		{
			if(_i2>=0){
				_myList.get(_i2).get(2).setIcon(_whichicon);
				_checkList.get(_i2).set(2, _whichnumber);
				_i2--;
				_xxx++;
	    	}
	    	else{
	    		_player_name.setText("STOP to click button 3");
	    	}
		}
		else if(b.equals(_b4))
		{
			if(_i3>=0){
				_myList.get(_i3).get(3).setIcon(_whichicon);
				_checkList.get(_i3).set(3, _whichnumber);
				_i3--;
				_xxx++;
	    	}
	    	else{
	    		_player_name.setText("STOP to click button 4");
	    	}
		}
		else if(b.equals(_b5))
		{
			if(_i4>=0){
				_myList.get(_i4).get(4).setIcon(_whichicon);
				_checkList.get(_i4).set(4, _whichnumber);
				_i4--;
				_xxx++;
	    	}
	    	else{
	    		_player_name.setText("STOP to click button 5");
	    	}
		}
		else if(b.equals(_b6))
		{
			if(_i5>=0){
				_myList.get(_i5).get(5).setIcon(_whichicon);
				_checkList.get(_i5).set(5, _whichnumber);
				_i5--;
				_xxx++;
	    	}
	    	else{
	    		_player_name.setText("STOP to click button 6");
	    	}
		}
		else if(b.equals(_b7))
		{
			if(_i6>=0){
				_myList.get(_i6).get(6).setIcon(_whichicon);
				_checkList.get(_i6).set(6, _whichnumber);
				_i6--;
				_xxx++;
	    	}
	    	else{
	    		_player_name.setText("STOP to click button 7");
	    	}
		}
	    checkresult(); // Checking the result after button be pressed every time 

		}

	public void  checkresult(){
		
		//check row ¡÷¡÷¡÷¡÷¡÷¡÷¡÷direction
		for (int i=0;   i<=5;  i++)
		{
			for(int j=0; j<=3; j++)
			{
				if(_checkList.get(i).get(j)==_checkList.get(i).get(j+1)){ // for example if _checkList(0,0)==_checkList(1,0)
					if(_checkList.get(i).get(j)==_checkList.get(i).get(j+2)){// for example if _checkList(0,0)==_checkList(2,0)
						if(_checkList.get(i).get(j)==_checkList.get(i).get(j+3)){// for example if _checkList(0,0)==_checkList(3,0)
							if(_checkList.get(i).get(j)==1){ // 1 represent redicon_player 1
								_player_name.setText("PLAYER 1 WIN");
								_p_result.setVisible(true); // show the result button
								_i0=_i1=_i2=_i3=_i4=_i5=_i6=5; // reset these parameter to original value
								_xxx=1;// reset these parameter to original value
							}
							else if(_checkList.get(i).get(j)==-1){
								_player_name.setText("PLAYER 2 WIN");
								_p_result.setVisible(true);
								_i0=_i1=_i2=_i3=_i4=_i5=_i6=5;
								_xxx=1;
							}
						}
						
					}
					
				}
			}
		}
		
		//check column ¡õ¡õ¡õ¡õ¡õ¡õdirection
		for (int j=0;   j<=6;  j++)
		{
			for(int i=0; i<=2; i++)
			{
				if(_checkList.get(i).get(j)==_checkList.get(i+1).get(j)){
					if(_checkList.get(i).get(j)==_checkList.get(i+2).get(j)){
						if(_checkList.get(i).get(j)==_checkList.get(i+3).get(j)){
							if(_checkList.get(i).get(j)==1){
								_player_name.setText("PLAYER 1 WIN");
								_p_result.setVisible(true);
								_i0=_i1=_i2=_i3=_i4=_i5=_i6=5;
								_xxx=1;
							}
							else if(_checkList.get(i).get(j)==-1){
								_player_name.setText("PLAYER 2 WIN");
								_p_result.setVisible(true);
								_i0=_i1=_i2=_i3=_i4=_i5=_i6=5;
								_xxx=1;
								
							}
						}
						
					}
					
				}
			}
		}
		
		//check \\\ direction
		for (int i=0;   i<=2;  i++)
		{
			for(int j=0; j<=3; j++)
			{
				if(_checkList.get(i).get(j)==_checkList.get(i+1).get(j+1)){
					if(_checkList.get(i).get(j)==_checkList.get(i+2).get(j+2)){
						if(_checkList.get(i).get(j)==_checkList.get(i+3).get(j+3)){
							if(_checkList.get(i).get(j)==1){
								_player_name.setText("PLAYER 1 WIN");
								_p_result.setVisible(true);
								_i0=_i1=_i2=_i3=_i4=_i5=_i6=5;
								_xxx=1;
								
							}
							else if(_checkList.get(i).get(j)==-1){
								_player_name.setText("PLAYER 2 WIN");
								_p_result.setVisible(true);
								_i0=_i1=_i2=_i3=_i4=_i5=_i6=5;
								_xxx=1;
								
							}
						}
						
					}
					
				}
			}
		}
		
		//check /// direction
		for (int i=0;   i<=2;  i++)
		{
			for(int j=3; j<=6; j++)
			{
				if(_checkList.get(i).get(j)==_checkList.get(i+1).get(j-1)){
					if(_checkList.get(i).get(j)==_checkList.get(i+2).get(j-2)){
						if(_checkList.get(i).get(j)==_checkList.get(i+3).get(j-3)){
							if(_checkList.get(i).get(j)==1){
								_player_name.setText("PLAYER 1 WIN");
								_p_result.setVisible(true);
								_i0=_i1=_i2=_i3=_i4=_i5=_i6=5;
								_xxx=1;
								
							}
							else if(_checkList.get(i).get(j)==-1){
								_player_name.setText("PLAYER 2 WIN");
								_p_result.setVisible(true);
								_i0=_i1=_i2=_i3=_i4=_i5=_i6=5;
								_xxx=1;
								
							}
						}
						
					}
					
				}
			}
		}
	
		
	}
	

}
		
		
	
	
		
		



