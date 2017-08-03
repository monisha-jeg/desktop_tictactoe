import java.awt.*; 
import java.awt.Component.*; 
import java.awt.event.*;  
import javax.swing.*;

public class Over
{
	JFrame frame3;
	JButton again, stop;
	JLabel over;

	Over()	
	{
		String x = "IT'S A DRAW!!!!";
        if(TTT.user != -1)
        {
            if(Open.game != 'P' && TTT.user == 1)
                x = "COMPUTER WON!!!!!";
            else
                x = "PLAYER " + String.valueOf(TTT.user+1) + " WON!!!!";
        }

        frame3 = new JFrame("TIC TAC TOE");
        over = new JLabel(x);
		again = new JButton("PLAY AGAIN");
		stop = new JButton("EXIT");

		
        over.setBounds(100,60,400,100); 
        over.setFont(new Font("Arial", Font.BOLD, 30)); 

        again.setBounds(100,150,300,100);
        again.setFont(new Font("Arial", Font.BOLD, 20));  
        again.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){
                new Open();
                frame3.dispose();
            }  
        });

        stop.setBounds(100,300,300,100); 
        stop.setFont(new Font("Arial", Font.BOLD, 20));  
        stop.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){
                frame3.dispose();

            }  
        });

        frame3.add(over);
        frame3.add(again);
        frame3.add(stop);

        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame3.setSize(500,500);    
        frame3.setLayout(null); 
        frame3.setLocationRelativeTo(null);    
        frame3.setVisible(true);
	}


    public static void main(String args[])  
    {  
        new Over();  
    }
}