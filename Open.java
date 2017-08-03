import java.awt.*; 
import java.awt.Component.*; 
import java.awt.event.*;  
import javax.swing.*;
import java.util.*;

public class Open
{
	JFrame frame1;
	JButton play, comp, compa;
    static char game = '\0';

	Open()	
	{
		frame1 = new JFrame("TIC TAC TOE");
        play = new JButton("TWO PLAYERS");
        comp = new JButton("COMPUTER - EASY");
        compa = new JButton("COMPUTER - TOUGH");


        play.setBounds(100,80,300,70);
        play.setFont(new Font("Arial", Font.BOLD, 20));  
        play.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){
                game = 'P';
                frame1.dispose();
                new TTT();
            }  
        });


        comp.setBounds(100,200,300,70);
        comp.setFont(new Font("Arial", Font.BOLD, 20));  
		comp.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){
                game = 'C';
                frame1.dispose();
                new TTT();
            }  
        });


        compa.setBounds(100,320,300,70);
        compa.setFont(new Font("Arial", Font.BOLD, 20));  
        compa.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){
                game = 'A';
                frame1.dispose();
                new TTT();
            }  
        });

        frame1.add(play);
        frame1.add(comp);
        frame1.add(compa);

        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setSize(500,500);    
        frame1.setLayout(null); 
        frame1.setLocationRelativeTo(null);   
        frame1.setVisible(true); 
	}

    public static void main(String args[])  
    {  
        new Open();
    }
}