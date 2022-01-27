package tictactoe;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;

public class TTT implements  ActionListener
{
	//creates new frame, panel, button array to click an X or O, a title text object, a boolean for whose turn it is, and a random generator to randomly determine whos turn it is
JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JPanel slotsPanel = new JPanel();
		JButton[] slots = new JButton[9];
		Boolean playerTurn = true; // true == player 1 and false == player two
		JLabel text = new JLabel();
		Random rand = new Random();
	TTT()
	{
		// sets the general aspects of the frame, when it closes, sizing, background color, and visibility.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(900,900);
		frame.getContentPane().setBackground(new Color(255,204,153)); // color of original background
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		
		//sets color, front, placing, content, and opacity of the title text
		text.setBackground(new Color(0,0,0)); // color of text
		text.setForeground(new Color(255,128,0)); // color of 
		text.setFont(new Font("Times New Roman", Font.BOLD, 50));
		text.setHorizontalAlignment(JLabel.CENTER);
		text.setText("Click To Start");
		text.setOpaque(true);
		
		//sets the boundaries of the title panel
		panel.setLayout(new BorderLayout());
		panel.setBounds(0,0,600,100);
		
		// sets color of the x or o slot panel, assigns each actual button a slot, serts teh font and size of font for text inside the slot
		slotsPanel.setLayout(new GridLayout(3,3));
		slotsPanel.setBackground(new Color(255,70,0));
		for(int i = 0;i < 9; i++) 
		{
			slots[i] = new JButton();
			slotsPanel.add(slots[i]);
			slots[i].setFont(new Font ("Times New Roman",Font.ITALIC,100));
			slots[i].setFocusable(false);
			slots[i].addActionListener(this);
		}
		// adds panel and the slots to the actual application display
		panel.add(text);
		frame.add(panel,BorderLayout.SOUTH);
		frame.add(slotsPanel);
		turn();//runs the method to see who goes first
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		for(int i=0;i<9;i++) 
		{
			if(e.getSource()==slots[i]) 
			{
				if(playerTurn) 
				{
					if(slots[i].getText()=="") 
					{
						slots[i].setForeground(new Color(0,0,0));
						slots[i].setText("X");
						playerTurn=false;
						text.setText("O turn");
						winnerCheck();//after each button click checks for a winner
					}
				}else {
					if(slots[i].getText()=="") 
					{
						slots[i].setForeground(new Color(0,0,0));
						slots[i].setText("O");
						playerTurn=true;
						text.setText("X turn");
						winnerCheck();
					}
				}
			}			
		}
	}
	
	public void turn() 
	{
		//gets rid of the option to click a button before dice roll timer for smoother operation
		for(int i =0; i < 9; i++) 
		{
			slots[i].setEnabled(false);
		}
		
		// gives fun illusion of real dice roll timing
	try {
		text.setText("Rolling the dice to see who goes first.");
		Thread.sleep(666);
		text.setText("Rolling the dice to see who goes first..");
		Thread.sleep(666);
		text.setText("Rolling the dice to see who goes first...");
		Thread.sleep(666);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	for(int i =0; i < 9; i++) 
	{
		slots[i].setEnabled(true);
	}
	
	// actual computation of choosing who goes first with random number method
	if(rand.nextInt(2)==0) {
		playerTurn=true;
		text.setText("X Turn");
	}
	else {
		playerTurn=false;
		text.setText("O Turn");
	}
}
	public void winnerCheck()
	{
			//checking X win conditions
			if(
					(slots[0].getText()=="X") &&
					(slots[1].getText()=="X") &&
					(slots[2].getText()=="X")
					) 
			{
				xWins(0,1,2);
			}
			if(
					(slots[3].getText()=="X") &&
					(slots[4].getText()=="X") &&
					(slots[5].getText()=="X")
					) 
			{
				xWins(3,4,5);
			}
			if(
					(slots[6].getText()=="X") &&
					(slots[7].getText()=="X") &&
					(slots[8].getText()=="X")
					) 
			{
				xWins(6,7,8);
			}
			if(
					(slots[0].getText()=="X") &&
					(slots[3].getText()=="X") &&
					(slots[6].getText()=="X")
					) 
			{
				xWins(0,3,6);
			}
			if(
					(slots[1].getText()=="X") &&
					(slots[4].getText()=="X") &&
					(slots[7].getText()=="X")
					)
			{
				xWins(1,4,7);
			}
			if(
					(slots[2].getText()=="X") &&
					(slots[5].getText()=="X") &&
					(slots[8].getText()=="X")
					) 
			{
				xWins(2,5,8);
			}
			if(
					(slots[0].getText()=="X") &&
					(slots[4].getText()=="X") &&
					(slots[8].getText()=="X")
					) 
			{
				xWins(0,4,8);
			}
			if(
					(slots[2].getText()=="X") &&
					(slots[4].getText()=="X") &&
					(slots[6].getText()=="X")
					) 
			{
				xWins(2,4,6);
			}
			
			//checking O win conditions
			if(
					(slots[0].getText()=="O") &&
					(slots[1].getText()=="O") &&
					(slots[2].getText()=="O")
					) {
				oWins(0,1,2);
			}
			
			if(
					(slots[3].getText()=="O") &&
					(slots[4].getText()=="O") &&
					(slots[5].getText()=="O")
					) {
				oWins(3,4,5);
			}
			
			if(
					(slots[6].getText()=="O") &&
					(slots[7].getText()=="O") &&
					(slots[8].getText()=="O")
					) {
				oWins(6,7,8);
			}
			
			if(
					(slots[0].getText()=="O") &&
					(slots[3].getText()=="O") &&
					(slots[6].getText()=="O")
					) 
			{
				oWins(0,3,6);
			}
			
			if(
					(slots[1].getText()=="O") &&
					(slots[4].getText()=="O") &&
					(slots[7].getText()=="O")
					) 
			{
				oWins(1,4,7);
			}
			
			if(
					(slots[2].getText()=="O") &&
					(slots[5].getText()=="O") &&
					(slots[8].getText()=="O")
					) 
			{
				oWins(2,5,8);
			}
			
			if(
					(slots[0].getText()=="O") &&
					(slots[4].getText()=="O") &&
					(slots[8].getText()=="O")
					) 
			{
				oWins(0,4,8);
			}
			
			if(
					(slots[2].getText()=="O") &&
					(slots[4].getText()=="O") &&
					(slots[6].getText()=="O")
					) 
			{
				oWins(2,4,6);
			}
	}
	
	public void oWins(int choice1, int choice2, int choice3) 
	{
		slots[choice1].setBackground(Color.GREEN);
		slots[choice2].setBackground(Color.GREEN);
		slots[choice3].setBackground(Color.GREEN);
		
		for(int i =0; i < 9; i++) 
		{
			slots[i].setEnabled(false);
		}
		text.setText("O Player Wins!");
	}
	
	public void xWins(int choice1, int choice2, int choice3) 
	{
		slots[choice1].setBackground(Color.GREEN);
		slots[choice2].setBackground(Color.GREEN);
		slots[choice3].setBackground(Color.GREEN);
		
		for(int i =0; i < 9; i++) 
		{
			slots[i].setEnabled(false);
		}
		text.setText("X Player Wins!");
	}
	

}
