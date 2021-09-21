//a project by purpleprogrammers

import java.awt.event.*;
import java.util.Scanner;
import java.awt.*;
import javax.swing.*;
public class Quiz implements ActionListener{
	Scanner N= new Scanner(System.in);
	String name=N.toString();
	String[] questions= { 
			"        What is our national anthem?",
			"              What are our Flag colors?",
			"      What was Java originally called?",
			"          What is our national flower?",
			"        Which company Created java?"
			
			};
	
	String[][] options= { 
			{"Amar Shonar Bangla","O Amar Desher Mati","Ami Banglai Gaan Gai","Purano She Diner Kotha"},
			{"Black & White","Blue & Green","Green & Red","White & Red"},
			{"Apple","Latte","Oak","Koffing"},
			{"Water Lily","Rose","lotus","jasmine"},
			{"Sun Microsystem","Microsoft","Linux","Alphabet"}
			
			
	};
	
	char[] answers= { 
			'A',
			'C',
			'C',
			'A',
			'A'
	};
	
	//These variables are work like global
	char guess;
	char answer;
	int index;
	int correct_guesses=0;
	int total_question= questions.length;
	int result;
	int seconds= 15; 
	
	JFrame frame= new JFrame();
	JTextField textfield= new JTextField();
	JTextArea textarea= new JTextArea();
	JButton buttonA= new JButton();
	JButton buttonB= new JButton();
	JButton buttonC= new JButton();
	JButton buttonD= new JButton();
	JButton Start1= new JButton();
	JButton Exit= new JButton();
	//JButton buttonE= new JButton();
	
	JLabel Answer_lebelA= new JLabel();
	JLabel Answer_lebelB= new JLabel();
	JLabel Answer_lebelC= new JLabel();
	JLabel Answer_lebelD= new JLabel();
	JLabel Time_lebelA= new JLabel();
	JLabel Seconds_Left= new JLabel(); //Count down Time
	JTextField Number_Right= new JTextField(); //score calculate shown
	JTextField Percentage= new JTextField(); // after getting score shown
	JTextField Name= new JTextField();
	JTextField Congo= new JTextField();//message box
	
	Timer timer= new Timer(1000, new ActionListener(){ 
		@Override
		public void actionPerformed(ActionEvent e) {
			seconds--;
			Seconds_Left.setText(String.valueOf(seconds));
			if(seconds<=0) {
				displayAnswer();
			}
		}
	   });
	
	public Quiz() { //Constructor 
		   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   frame.setSize(700,700);
		   frame.getContentPane().setBackground(new Color(153,153,153)); //RGB for grey
		   frame.setLayout(null); //set size by hand
		   frame.setResizable(false); //do not want to resize compiler by user
		   
		   textfield.setBounds(0,0,700,50);
		   textfield.setBackground(new Color(051,051,051)); //up border dark grey
		   textfield.setForeground(new Color(255,255,153));//yellow RGB for text
		   textfield.setFont(new Font("Arial Black",Font.BOLD,30));
		   textfield.setBorder(BorderFactory.createBevelBorder(1));
		   textfield.setHorizontalAlignment(JTextField.CENTER);
		   textfield.setEditable(false);
		   //textfield.setText("Welcome to Prüfung");
		   
		   textarea.setBounds(0,50,700,50);
		   /*textarea.setLineWrap(true); //allow text how many words accepts
		   textarea.setWrapStyleWord(true); // wrapping boundaries text allowed*/
		   textarea.setBackground(new Color(051,051,051)); //up border dark grey
		   textarea.setForeground(new Color(255,255,153)); //the color in which text is shown.
		   textarea.setFont(new Font("Arial Black",Font.BOLD,30));
		   textarea.setBorder(BorderFactory.createBevelBorder(1)); //creating shadow line
		   textarea.setEditable(false); //user can not edit
		   //textarea.setText("Welcome to QUIZ GAME");
		   
		   buttonA.setBounds(25,125,100,100); //x,y coordinates rectangle size
		   buttonA.setBackground(new Color(255,204,051)); //gold option background
		   buttonA.setForeground(new Color(0,0,0));
		   buttonA.setFont(new Font("Century Gothic",Font.BOLD,35));
		   buttonA.setFocusable(false); //it will control the answer mode color
		   buttonA.addActionListener(this);
		   buttonA.setText("A");
		   
		   buttonB.setBounds(25,225,100,100); //x,y coordinates rectangle size
		   buttonB.setBackground(new Color(255,204,051)); //gold option background
		   buttonB.setForeground(new Color(0,0,0));//black text
		   buttonB.setFont(new Font("Century Gothic",Font.BOLD,35));
		   buttonB.setFocusable(false); //it will control the answer mode color
		   buttonB.addActionListener(this);
		   buttonB.setText("B");
		   
		   buttonC.setBounds(25,325,100,100); //x,y coordinates rectangle size
		   buttonC.setBackground(new Color(255,204,051)); //gold option background
		   buttonC.setForeground(new Color(0,0,0));
		   buttonC.setFont(new Font("Century Gothic",Font.BOLD,35));
		   buttonC.setFocusable(false); //it will control the answer mode color
		   buttonC.addActionListener(this);
		   buttonC.setText("C");
		   
		   buttonD.setBounds(25,425,100,100); //x,y coordinates rectangle size
		   buttonD.setBackground(new Color(255,204,051)); //gold option background
		   buttonD.setForeground(new Color(0,0,0));
		   buttonD.setFont(new Font("Century Gothic",Font.BOLD,35));
		   buttonD.setFocusable(false); //it will control the answer mode color
		   buttonD.addActionListener(this);
		   buttonD.setText("D");
		   
		   Answer_lebelA.setBounds(150,125,500,100);
		   Answer_lebelA.setBackground(new Color(50,50,50));
		   Answer_lebelA.setForeground(new Color(255,255,153)); //color light yellow
		   Answer_lebelA.setFont(new Font("Grandview",Font.BOLD,35));
		   //Answer_lebelA.setText("Hi A");
		   
		   Answer_lebelB.setBounds(150,225,500,100);
		   Answer_lebelB.setBackground(new Color(50,50,50));
		   Answer_lebelB.setForeground(new Color(255,255,153)); //color light yellow
		   Answer_lebelB.setFont(new Font("Grandview",Font.BOLD,35));
		   //Answer_lebelB.setText("Hi B");
		   
		   Answer_lebelC.setBounds(150,325,500,100);
		   Answer_lebelC.setBackground(new Color(50,50,50));
		   Answer_lebelC.setForeground(new Color(255,255,153)); //color light yellow
		   Answer_lebelC.setFont(new Font("Grandview",Font.BOLD,35));
		   //Answer_lebelC.setText("Hi C");
		   
		   Answer_lebelD.setBounds(150,425,500,100);
		   Answer_lebelD.setBackground(new Color(50,50,50));
		   Answer_lebelD.setForeground(new Color(255,255,153)); //color light yellow
		   Answer_lebelD.setFont(new Font("Grandview",Font.BOLD,35));
		   		   
		   //for timer
		   Seconds_Left.setBounds(535,510,100,100);
		   Seconds_Left.setBackground(new Color(25,25,25)); //black
		   Seconds_Left.setForeground(new Color(255,0,0)); //red
		   Seconds_Left.setFont(new Font("Arial",Font.BOLD,50)); 
		   Seconds_Left.setOpaque(true);
		   Seconds_Left.setHorizontalAlignment(JTextField.CENTER);
		   Seconds_Left.setText(String.valueOf(seconds));
		   
		   Number_Right.setBounds(0,150,700,100);   
		   Number_Right.setBackground(new Color(255,255,204));
		   Number_Right.setForeground(new Color(0,0,0));
		   Number_Right.setFont(new Font("Arial",Font.BOLD,30));
		   Number_Right.setBorder(BorderFactory.createBevelBorder(1));
		   Number_Right.setHorizontalAlignment(JTextField.CENTER);
		   Number_Right.setEditable(false);  //Non editable for user
		   
		   Percentage.setBounds(0,250,700,100);
		   Percentage.setBackground(new Color(255,255,153));
		   Percentage.setForeground(new Color(0,0,0));
		   Percentage.setFont(new Font("Arial",Font.BOLD,35));
		   Percentage.setBorder(BorderFactory.createBevelBorder(1));
		   Percentage.setHorizontalAlignment(JTextField.CENTER);
		   Percentage.setEditable(false);
		   
		   Name.setBounds(0,450,700,100);
		   Name.setBackground(new Color(255,204,0));
		   Name.setForeground(new Color(0,0,0));
		   Name.setFont(new Font("Arial",Font.BOLD,50));
		   Name.setBorder(BorderFactory.createBevelBorder(1));
		   Name.setHorizontalAlignment(JTextField.CENTER);
		   Name.setEditable(true);
		   
		   Congo.setBounds(0,350,700,100);
		   Congo.setBackground(new Color(255,255,0));
		   Congo.setForeground(new Color(0,0,0));
		   Congo.setFont(new Font("Arial",Font.BOLD,20));
		   Congo.setBorder(BorderFactory.createBevelBorder(1));
		   Congo.setHorizontalAlignment(JTextField.CENTER);
		   Congo.setEditable(false);
		   
		   frame.add(Seconds_Left);
		   frame.add(Answer_lebelA);
		   frame.add(Answer_lebelB);
		   frame.add(Answer_lebelC);
		   frame.add(Answer_lebelD);
		   frame.add(buttonA);
		   frame.add(buttonB);
		   frame.add(buttonC);
		   frame.add(buttonD);
		   frame.add(textarea);
		   frame.add(textfield);
		   frame.setVisible(true); // it is show Welcome text
		   nextquestion();
		   }
	       	    
   public void nextquestion() { 
	   if(index>=total_question) {
		   results();
	   }
	   else {
		   textfield.setText("Question "+(index+1));
		   textarea.setText(questions[index]);
		   Answer_lebelA.setText(options[index][0]);
		   Answer_lebelB.setText(options[index][1]);
		   Answer_lebelC.setText(options[index][2]);
		   Answer_lebelD.setText(options[index][3]);
		   timer.start();
	   }
	   
   }
   @Override
   public void actionPerformed(ActionEvent e) { //game performing controller  
	   buttonA.setEnabled(false);
	   buttonB.setEnabled(false);
	   buttonC.setEnabled(false);
	   buttonD.setEnabled(false);
	   if(e.getSource()==buttonA) {
		   answer='A';
		   if(answer==answers[index]) {
			   correct_guesses++;
		   }
	   }
	   if(e.getSource()==buttonB) {
		   answer='B';
		   if(answer==answers[index]) {
			   correct_guesses++;
		   }
	   }
	   if(e.getSource()==buttonC) {
		   answer='C';
		   if(answer==answers[index]) {
			   correct_guesses++;
		   }
	   }
	   if(e.getSource()==buttonD) {
		   answer='D';
		   if(answer==answers[index]) {
			   correct_guesses++;
		   }
	   }
	   displayAnswer(); 
   }
   
   public void displayAnswer() {  
	   
	   timer.stop();
	   
	   buttonA.setEnabled(false);
	   buttonB.setEnabled(false);
	   buttonC.setEnabled(false);
	   buttonD.setEnabled(false);
	   if(answers[index]!= 'A')
		   Answer_lebelA.setForeground(new Color(255,102,102)); //red
	   if(answers[index]!= 'B')
		   
		   Answer_lebelB.setForeground(new Color(255,102,102));
	   
	   if(answers[index]!= 'C')
		   Answer_lebelC.setForeground(new Color(255,102,102));
	   
	   if(answers[index]!= 'D')
		   Answer_lebelD.setForeground(new Color(255,102,102));
	   
	   Timer pause= new Timer(2000, new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e) {  //for answer  
			Answer_lebelA.setForeground(new Color(255,255,153)); //color light yellow
			Answer_lebelB.setForeground(new Color(255,255,153));
			Answer_lebelC.setForeground(new Color(255,255,153));
		    Answer_lebelD.setForeground(new Color(255,255,153));
			answer= ' ';
			seconds=15;
			Seconds_Left.setText(String.valueOf(seconds));
			buttonA.setEnabled(true);
			buttonB.setEnabled(true);
			buttonC.setEnabled(true);
			buttonD.setEnabled(true);
			index++;
			   nextquestion();
		}
	   });
	   pause.setRepeats(false);
	   pause.start();
   }
   
   public void results() { 
	   
	   buttonA.setVisible(false);
	   buttonB.setVisible(false);
	   buttonC.setVisible(false);
	   buttonD.setVisible(false);
	   Seconds_Left.setVisible(false);
	   textarea.setVisible(false);
	   Answer_lebelA.setVisible(false);
	   Answer_lebelB.setVisible(false);
	   Answer_lebelC.setVisible(false);
	   Answer_lebelD.setVisible(false);
	   
	   result= (int)((correct_guesses/(double)total_question)*100);
	   textfield.setText("Congratulations! The Prüfung Score");
	   
	   
	   Number_Right.setText(correct_guesses+ "/" + total_question);
	   if(result==100) {
		   Percentage.setText(result+"%\n"+"  Excellent!"); 
		   Congo.setText("You completed the quiz! Please enter your name below.");
		   Name.setVisible(true);
	   }
	   else if(result==80) {
		   Percentage.setText(result+"%\n"+"  Good!");
		   Congo.setText("You completed the quiz! Please enter your name below.");
		   Name.setVisible(true);
	   }
	   else if(result==60) {
		   Percentage.setText(result+"%\n"+"  Average");
		   Congo.setText("You completed the quiz! Please enter your name below.");
		   Name.setVisible(true);
	   }
	   else if(result==40) {
		   Percentage.setText(result+"%\n"+"  Not Good");
		   Congo.setText("Please try again!");
		   Name.setVisible(false);
	   }
	   else if(result==20) {
		   Percentage.setText(result+"%\n"+"\nFailed!");
		   Congo.setText("Please try again!");
		   Name.setVisible(false);
	   }
	   else {
		   Percentage.setText(result+"%\n"+"Failed!");
		   Congo.setText("Please try again!");
		   Name.setVisible(false);
	   }
	   //Percentage.setText(result+"%");
	   
	  /* Scanner N= new Scanner(System.in);
		String name=N.toString();
	   Name.setText(name);*/
	   //frame.add(Name);
	   frame.add(Name);
	   frame.add(Number_Right);
	   frame.add(Percentage);
	   frame.add(Congo);
	   
   }
}