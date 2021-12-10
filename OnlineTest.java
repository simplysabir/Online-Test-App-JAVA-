
package com.mycompany.onlinetestapp2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

/**
 *
 * @author Sabir Khan
 */
public class OnlineTest extends JFrame implements ActionListener {
    
    JLabel label;
    JRadioButton radioButtons [] = new JRadioButton[5];
    JButton btnNext,btnResult;
    ButtonGroup bg;
    int count = 0, current = 0, x = 1,y = 1, now = 0;
    int[] m = new int[10]; // for passing no. of question like 10 or 20
    
    OnlineTest(String s){
        super(s);
        label = new JLabel();
        add(label);
        bg = new ButtonGroup();
        for(int i=0; i<5; i++){
            radioButtons[i] = new JRadioButton();
            add(radioButtons[i]);
            bg.add(radioButtons[i]);
        }
        btnNext = new JButton("Next");
        btnResult = new JButton("Result");
        btnResult.setVisible(false); // so that result cant be seen initially 
        btnResult.addActionListener(this);
        btnNext.addActionListener(this);
        add(btnNext);
        add(btnResult);
        setData();
        label.setBounds(30,40,450,20);
        radioButtons[0].setBounds(50,80,450,20);
        radioButtons[1].setBounds(50,110,200,20);
        radioButtons[2].setBounds(50,140,200,20);
        radioButtons[3].setBounds(50,170,200,20);
        btnNext.setBounds(100,240,100,30);
        btnResult.setBounds(270,240,100,30);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocation(250,100);
        setVisible(true);
        setSize(600,350);
        
        
        
        
    }
    
    void setData(){// Questions and Answer With Solution and all
        radioButtons[4].setSelected(true);
        if(current==0){
            label.setText("Q1: By Using Which of the Following You Can Use Multiple Inheritance in JAVA ");
            radioButtons[0].setText("Interface");
            radioButtons[1].setText("Abstract Classes");
            radioButtons[2].setText("ArrayList");
            radioButtons[3].setText("Vector");
        }
        if(current==1){
            label.setText("Q2:Which of the Following is not a JAVA Feature ? ");
            radioButtons[0].setText("Dynamic");
            radioButtons[1].setText("Architecture Neutral");
            radioButtons[2].setText("Use of Pointers");
            radioButtons[3].setText("Object Oriented");
        }
        if(current==2){
            label.setText("Q3: What is the Size of Boolean Variable ?  ");
            radioButtons[0].setText("8 bit");
            radioButtons[1].setText("16 bit");
            radioButtons[2].setText("32 bit");
            radioButtons[3].setText("Not Known");
        }
        if(current==3){
            label.setText("Q4: What is the default value of long variable ? ");
            radioButtons[0].setText("0");
            radioButtons[1].setText("0.0");
            radioButtons[2].setText("0L");
            radioButtons[3].setText("not known");
        }
        if(current==4){
            label.setText("Q5: Which of the Following is Threadsafe ?");
            radioButtons[0].setText("StringBuilder");
            radioButtons[1].setText("StringBuffer");
            radioButtons[2].setText("None of them");
            radioButtons[3].setText("Both of them");
        }
        if(current==5){
            label.setText("Q6: What is the Default Value of Boolean");
            radioButtons[0].setText("true");
            radioButtons[1].setText("false");
            radioButtons[2].setText("0");
            radioButtons[3].setText("null");
        }
        if(current==6){
            label.setText("Q7: The \u0021 article referred to as a ");
            radioButtons[0].setText("Unicode Escape Sequence");
            radioButtons[1].setText("Octal Escape");
            radioButtons[2].setText("Hexadecimal");
            radioButtons[3].setText("Line Feed");
        }
        if(current==7){
            label.setText("Q8: Which of the Following is Used to Find and Fix Bugs in the JAVA Programs ");
            radioButtons[0].setText("JVM");
            radioButtons[1].setText("JRE");
            radioButtons[2].setText("JDK");
            radioButtons[3].setText("JDB");
        }
        if(current==8){
            label.setText("Q9: What is the return type of the hashCode() method in the Object Class");
            radioButtons[0].setText("Object");
            radioButtons[1].setText("int");
            radioButtons[2].setText("long");
            radioButtons[3].setText("void");
        }
        if(current==9){
            label.setText("Q10 :What Does the Expression float a = 35/0 return ? ");
            radioButtons[0].setText("0");
            radioButtons[1].setText("Not a Number");
            radioButtons[2].setText("Infinity");
            radioButtons[3].setText("Run Time Exception");
        }
        label.setBounds(30,40,450,20);
        for(int i=0,j=0;i<=90; i+=30,j++){
            radioButtons[j].setBounds(50,80+i,200,20);
        }
        
        
        
    }
    //for checking ans
    //checking by index value of correct answer
    boolean checkAns(){
        if(current==0){
            return (radioButtons[0].isSelected());
        }
        
         if(current==1){
            return (radioButtons[2].isSelected());
        }
         
          if(current==2){
            return (radioButtons[1].isSelected());
        }
          
           if(current==3){
            return (radioButtons[2].isSelected());
        }
           
            if(current==4){
            return (radioButtons[1].isSelected());
        }
            
             if(current==5){
            return (radioButtons[1].isSelected());
        }
             
              if(current==6){
            return (radioButtons[0].isSelected());
        }
              
               if(current==7){
            return (radioButtons[3].isSelected());
        }
                if(current==8){
            return (radioButtons[1].isSelected());
        }
                
                 if(current==9){
            return (radioButtons[2].isSelected());
        }
                 
                 
        
        
        return false;
    }
    
    public static void main(String[] args){
      new  OnlineTest("Online Test App");
      
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnNext){
            if(checkAns())
                count = count+1;
            current++;
            setData();
            if(current==9){
                btnNext.setEnabled(false);
                btnResult.setVisible(true);
                btnResult.setText("Result");
            }
        }
        
        if(e.getActionCommand().equals("Result")){
            if(checkAns())
                count = count + 1;
            current++;
            JOptionPane.showMessageDialog(this, "Correct Answers are " + count);
            System.exit(0);
            
        }
    }
    
}
