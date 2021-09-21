import java.util.Scanner; 
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
            public static void main(String[] args) {   //TODO Auto-generated method stub
              
            JFrame frame=new JFrame("          Welcome To Prüfung   ");
            frame.getContentPane().setBackground(new Color(153,153,153));
            
        final JTextField textfield=new JTextField();
           textfield.setBounds(50,50,150,20);
        
        JButton start=new JButton("Start"); //start is button
        start.setBounds(50,150,110,30);  
        start.setBackground(new Color(051,051,051)); //up border dark grey
        start.setForeground(new Color(255,255,153));//yellow RGB for text
        start.addActionListener(new ActionListener()
        {  
            public void actionPerformed(ActionEvent e) //delegate method
            {    
                Quiz quiz=new Quiz();
            }  
        });  
        
        JButton exit=new JButton("Exit");  //Exit is button
        exit.setBounds(200,150,110,30); 
        exit.setBackground(new Color(051,051,051)); //up border dark grey
        exit.setForeground(new Color(255,255,153));//yellow RGB for text
        exit.addActionListener(new ActionListener()
        {  
            public void actionPerformed(ActionEvent e)
            {  
              System.exit(0);
              
            }  
        });  
        
        //frame.add(textfield);
        
        frame.add(start);
        frame.add(exit);  
        frame.setSize(400,400);  
        frame.setLayout(null);  
        frame.setVisible(true);       
  }}