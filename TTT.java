import java.awt.*; 
import java.awt.Component.*; 
import java.awt.event.*;  
import javax.swing.*;
import java.util.*;
import javax.swing.Timer;

public class TTT
{  
    JFrame frame2;
    static JButton box[];
    static int state[];
    static int user;

    public static int doubleindex()
    {
        if(state[4] == -1)
            return 4;
        else if(state[4] == user)
        {

            if(state[0] == -1 && state[1] == -1 && state[2] == -1)
                if(state[6] == -1)
                    return 0;
                if(state[8] == -1)
                    return 2;
            if(state[6] == -1 && state[7] == -1 && state[8] == -1)
                if(state[0] == -1)
                    return 6;
                if(state[2] == -1)
                    return 8;

            if(state[0] == -1 && state[3] == -1 && state[6] == -1)
                if(state[2] == -1)
                    return 0;
                if(state[8] == -1)
                    return 6;
            if(state[2] == -1 && state[5] == -1 && state[8] == -1)
                if(state[0] == -1)
                    return 2;
                if(state[6] == -1)
                    return 8;

            if(state[0] == user && state[1] == -1 && state[2] == -1 && state[6] == -1)
                return 2;
            if(state[2] == user && state[0] == -1 && state[1] == -1 && state[8] == -1)
                return 0;
            if(state[6] == user && state[7] == -1 && state[8] == -1 && state[0] == -1)
                return 8;
            if(state[8] == user && state[6] == -1 && state[7] == -1 && state[2] == -1)
                return 6;

            if(state[0] == user && state[3] == -1 && state[2] == -1 && state[6] == -1)
                return 6;
            if(state[6] == user && state[0] == -1 && state[3] == -1 && state[8] == -1)
                return 0;
            if(state[8] == user && state[2] == -1 && state[5] == -1 && state[6] == -1)
                return 2;
            if(state[2] == user && state[5] == -1 && state[8] == -1 && state[0] == -1)
                return 8;
        }
        return -1;
    }

    public static int doubleblock()
    {
        int opponent = 0;
        if(user == 0) 
                opponent = 1;  

        if(state[4] == -1)
            return 4;
        else if(state[4] == opponent)
        { 
            if(state[0] == opponent && state[2] == -1)
                return 2;
            if(state[0] == opponent && state[6] == -1)
                return 6;
            if(state[2] == opponent && state[8] == -1)
                return 8;
            if(state[6] == opponent && state[8] == -1)
                return 8;
            if(state[2] == opponent && state[0] == -1)
                return 0;
            if(state[6] == opponent && state[0] == -1)
                return 0;
            if(state[8] == opponent && state[2] == -1)
                return 2;
            if(state[8] == opponent && state[6] == -1)
                return 6;
        }
        return -1;
    }


    public static int secondindex(int check)    
    {
        int index = 0, i;
        for(i = 1; i <= 3; i++)
        {
            if(state[index] == -1 && ((state[index+1] == check && state[index+1] == -1) || (state[index+1] == -1 && state[index+1] == check)))
                return index;
            if(state[index+1] == -1 && ((state[index] == check && state[index] == -1) || (state[index] == -1 && state[index] == check)))
                return index + 1;
            if(state[index+2] == -1 && ((state[index] == check && state[index] == -1) || (state[index] == -1 && state[index] == check)))
                return index + 2;
            index += 3;
        }

        index = 0;
        for(i = 1; i <= 3; i++)
        {
            if(state[index] == -1 && ((state[index+3] == check && state[index+6] == -1) && (state[index+3] == -1 && state[index+6] == check)))
                return index;
            if(state[index+3] == -1 && ((state[index] == check && state[index+6] == -1) && (state[index] == -1 && state[index+6] == check)))
                return index + 3;
            if(state[index+6] == -1 && ((state[index] == check && state[index+3] == -1) && (state[index] == -1 && state[index+3] == check)))
                return index + 6;
            index += 1;
        }

        if(state[4] == -1)
        {
            if((state[0] == check && state[8] == -1) && (state[0] == -1 && state[8] == check))
                return 4;
            if((state[2] == check && state[6] == check) && (state[2] == -1 && state[6] == check))
                return 4;
        }
        else
        {
            if(state[4] == check)
            {
                if(state[0] == -1 && state[8] == -1)
                {
                    int rand = (new Random()).nextInt(2);
                    return rand*8;
                }
                if(state[2] == -1 && state[6] == -1)
                {
                    int rand = (new Random()).nextInt(2);
                    if(rand == 0)
                        return 2;
                    else
                        return 6;
                }
            }
        } 
        return -1;
    }

    public static int getrandomindex()
    {
        int countempty = 0, i;
        for(i=0; i < 9; i++) 
        {
            if(state[i] == -1)
                countempty++;
        }

        int index = (new Random()).nextInt(countempty);
        for(i=0; i < 9; i++)
        {
            if(state[i] == -1)
            {
                index--;
                if(index == -1)
                    break;
            }
        }
        return i;
    }


    public static int completeindex(int check)
    {  
        int index = 0, left = -1, i;
        for(i = 1; i <= 3; i++)
        {
            if(state[index] == -1 && state[index+1] == check && state[index+2] == check)
                return index;
            if(state[index+1] == -1 && state[index] == check && state[index+2] == check)
                return index + 1;
            if(state[index+2] == -1 && state[index] == check && state[index+1] == check)
                return index + 2;
            index += 3;
        }

        index = 0;
        for(i = 1; i <= 3; i++)
        {
            if(state[index] == -1 && state[index+3] == check && state[index+6] == check)
                return index;
            if(state[index+3] == -1 && state[index] == check && state[index+6] == check)
                return index + 3;
            if(state[index+6] == -1 && state[index] == check && state[index+3] == check)
                return index + 6;
            index += 1;
        }

        if(state[4] == -1)
        {
            if(state[0] == check && state[8] == check)
                return 4;
            if(state[2] == check && state[6] == check)
                return 4;
        }
        else
        {
            if(state[4] == check)
            {
                if(state[0] == check && state[8] == -1)
                    return 8;
                if(state[8] == check && state[0] == -1)
                    return 0;
                if(state[2] == check && state[6] == -1)
                    return 6;
                if(state[6] == check && state[2] == -1)
                    return 2;
            }
        } 
        return -1;
    }



    public static void makemove()
    {
        int opponent = 0;
        if(user == 0) 
            opponent = 1;
        
        int val = completeindex(opponent);
        if(val == -1)
            val = getrandomindex();

        state[val] = user;
        box[val].setIcon(new ImageIcon(TTT.class.getResource("1s.png")));
    }
        


    public static void makemoveadvanced()
    {
        int opponent = 0;
        if(user == 0) 
                opponent = 1;        

        int val = completeindex(user);
        if(val == -1)
            val = completeindex(opponent);        
        if(val == -1)
            val = doubleblock();
        if(val == -1)
            val = doubleindex();
        if(val == -1)
            val = secondindex(user);
        if(val == -1)
            val = completeindex(-1);
        if(val == -1)
            val = getrandomindex();

        state[val] = user;
        box[val].setIcon(new ImageIcon(TTT.class.getResource("1s.png")));
    }


    public static int win()
    {
        int index = 0, i;
        for(i=1; i <= 3; i++)
        {
            if(state[index] != -1 && state[index] == state[index+1] && state[index+1] == state[index+2])
                return 1;
            index = index + 3;
        }
                                
        index = 0;
        for(i=1; i <= 3; i++)
        {
            if(state[index] != -1 && state[index] == state[index+3] && state[index+3] == state[index+6])
                return 1;
            index = index + 1;
        }
        
        if(state[0] !=  -1 && state[0] == state[4] && state[4] == state[8])
            return 1;
        
        if(state[2] !=  -1 && state[2] == state[4] && state[4] == state[6])
            return 1;
                
        int notover = 0;
        for(i=0; i < 9; i++) 
            if(state[i] == -1)
            {
                notover = 1;
                break;
            }    

        if(notover == 1)
            return 0;       
        else
        {
            user = -1;
            return -1;            
        }
    }

    public static void swapuser()
    {
        if(user == 1)
            user = 0;
        else
            user = 1;
    }


    TTT()  
    {  
        box = new JButton[9];
        state = new int[9];
        user = 0;        

        frame2= new JFrame("TIC TAC TOE"); 
        

        for(int i = 0; i < 9; i++)
        {
            box[i] = new JButton();
            box[i].setBackground(Color.gray);
            box[i].setName(String.valueOf(i));
            box[i].setActionCommand(String.valueOf(i));            
            state[i] = -1;
            
            box[i].addActionListener(new ActionListener(){  
                public void actionPerformed(ActionEvent e){
                    
                    int boxnum = Integer.parseInt(e.getActionCommand());

                    
                    if(state[boxnum] == -1)
                    {
                        state[boxnum] = user;
                        box[boxnum].setIcon(new ImageIcon(TTT.class.getResource(String.valueOf(user)+"s.png")));
                    
                        if(win() == 0)
                        {
                            if(Open.game == 'P')
                                swapuser();
                            else
                            {
                                swapuser();
                                if(Open.game == 'C')
                                    makemove();
                                else
                                    makemoveadvanced();
                                if(win() == 0)
                                    swapuser();
                                else
                                {                                    
                                    // final Timer overTimer = new Timer();
                                    // overTimer.schedule( new TimerTask() {
                                    //     public void run()
                                    //     {
                                            new Over();
                                            frame2.dispose();
                                //         }
                                //     }, 0, 10000 );                                    
                                }
                            }  
                        }                          
                        else
                        {
                            new Over();
                            frame2.dispose();
                        }                        
                    }
                }  
            });  

            frame2.add(box[i]);
        }

        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setSize(500,500);    
        frame2.setLayout(new GridLayout(3, 3, 8, 8)); 
        frame2.setLocationRelativeTo(null);    
        frame2.setVisible(true);    
    }  

    public static void main(String args[])  
    {  
        new TTT();  
    }  
     
}