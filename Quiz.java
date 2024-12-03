/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz.game;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Quiz extends JFrame implements ActionListener{
    JButton next, submit, lifeline;
    public static int count = 0;
    public static int timer = 60;
    public static int ans_given = 0;
    public static int score = 0;
    JLabel qno,question;
    String q[][] = new String[10][5]; //creating 2d array for questions and options
    String pa[][] = new String[10][1];//creating 2d array for persons Answer
    String qa[][] = new String[10][2];//creating 2d array for correct Answer
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup options;
    
    String username;
    Quiz(String username){
        this.username = username;
        setBounds(250,50,1440,950);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("quiz/game/icons/quiz.png"));
        JLabel l1 = new JLabel(i1);
        l1.setBounds(0,0,1440,392);
        add(l1);
        
        qno = new JLabel("");
        qno.setFont(new Font("Tahoma", Font.PLAIN,24));
        qno.setBounds(100, 450, 50, 30);
        add(qno);
        
        question = new JLabel("");
        question.setFont(new Font("Tahoma", Font.PLAIN,24));
        question.setBounds(150, 450, 900, 30);
        add(question);
        
        q[0][0] = "Who is known as the Supremo of the Katipunan.";
        q[0][1] = "Emilio Aguinaldo";
        q[0][2] = "Apolinario Mabini";
        q[0][3] = "Andres Bonifacio";
        q[0][4] = "Jose Rizal";

        q[1][0] = "What does KKKK stand for?";
        q[1][1] = "Kataastaasan, Kagalang-galang na Katipunan ng mga Anak ng Bayan";
        q[1][2] = "Kagitingan, Kasarinlan,Katapatan";
        q[1][3] = "Katipunan ng mga Kababayan para sa Kalayaan";
        q[1][4] = "Karunungan, Kataastaasan nang Kalayaan ng Bayan";

        q[2][0] = "Who is the first wife of Andres Bonifacio?";
        q[2][1] = "Gregoria";
        q[2][2] = "Maria";
        q[2][3] = "Gloria";
        q[2][4] = "Monica";

        q[3][0] = "Who founded La Solidaridad";
        q[3][1] = "Jose Rizal";
        q[3][2] = "Graciano Lopez Jaena";
        q[3][3] = "Marcelo H. del Pilar";
        q[3][4] = "Antonio Luna";

        q[4][0] = "The highest position that a Filipino could attain?";
        q[4][1] = "Gobernadorcillo";
        q[4][2] = "Gobernador-General";
        q[4][3] = "Alcalde Mayor";
        q[4][4] = "Corregidores";

        q[5][0] = "What is the longest river in the Philippines?";
        q[5][1] = "Pasig River";
        q[5][2] = "Cagayan River";
        q[5][3] = "Agusan River";
        q[5][4] = "Rio Grande de Mindanao";

        q[6][0] = "Who named the Philippines \"Maniolas\" in their maps??";
        q[6][1] = "Ferdinand Magellan";
        q[6][2] = "Antonio Pigafetta";
        q[6][3] = "Ruy Lopez de Villalobos";
        q[6][4] = "Claudius Ptolemy";

        q[7][0] = "Who was the second explorer to arrive in the Philippines?";
        q[7][1] = "Ferdinand Magellan";
        q[7][2] = "Antonio Pigafetta";
        q[7][3] = "Ruy Lopez de Villalobos";
        q[7][4] = "Miguel Lopez De Legazpi";

        q[8][0] = "When did the Philippines gain independence from America?";
        q[8][1] = "July 4, 1946";
        q[8][2] = "July  8, 1941";
        q[8][3] = "August 15, 1947";
        q[8][4] = "September 4, 1946";

        q[9][0] = "Who founded the Diariong Tagalog?";
        q[9][1] = "Jose Rizal";
        q[9][2] = "Graciano Lopez Jaena";
        q[9][3] = "Marcelo Hilario del Pilar";
        q[9][4] = "Andres Bonifacio";
        
        qa[0][1] = "Andres Bonifacio";
        qa[1][1] = "Kataastaasan, Kagalang-galang na Katipunan ng mga Anak ng Bayan";
        qa[2][1] = "Monica";
        qa[3][1] = "Graciano Lopez Jaena";
        qa[4][1] = "Gobernadorcillo";
        qa[5][1] = "Cagayan River";
        qa[6][1] = "Claudius Ptolemy";
        qa[7][1] = "Ruy Lopez de Villalobos";
        qa[8][1] = "July 4, 1946";
        qa[9][1] = "Marcelo Hilario del Pilar";
        
        
        opt1 = new JRadioButton("");
        opt1.setBounds(170, 520, 700, 30);
        opt1.setFont(new Font("Dialog", Font.PLAIN, 20));
        opt1.setBackground(Color.WHITE);
        add(opt1);
        
        opt2 = new JRadioButton("");
        opt2.setBounds(170, 560, 700, 30);
        opt2.setFont(new Font("Dialog", Font.PLAIN, 20));
        opt2.setBackground(Color.WHITE);
        add(opt2);
        
        opt3 = new JRadioButton("");
        opt3.setBounds(170, 600, 700, 30);
        opt3.setFont(new Font("Dialog", Font.PLAIN, 20));
        opt3.setBackground(Color.WHITE);
        add(opt3);
        
        opt4 = new JRadioButton("");
        opt4.setBounds(170, 640, 700, 30);
        opt4.setFont(new Font("Dialog", Font.PLAIN, 20));
        opt4.setBackground(Color.WHITE);
        add(opt4);
        
        
        options=new ButtonGroup();
        options.add(opt1);
        options.add(opt2);
        options.add(opt3);
        options.add(opt4);
        
        next = new JButton("Next");
        next.setFont(new Font("Tahoma", Font.PLAIN, 22));
        next.setBackground(new Color(204,102,0));
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        next.setBounds(1100, 550, 200, 40);
        add(next);
        
        lifeline = new JButton("50-50 Lifeline");
        lifeline.setFont(new Font("Tahoma", Font.PLAIN, 22));
        lifeline.setBackground(new Color(204,102,0));
        lifeline.setForeground(Color.WHITE);
        lifeline.setBounds(1100, 630, 200, 40);
        lifeline.addActionListener(this);
        add(lifeline);
        
        submit = new JButton("Submit");
        submit.setFont(new Font("Tahoma", Font.PLAIN, 22));
        submit.setEnabled(false);
        submit.setBackground(new Color(204,102,0));
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setBounds(1100, 710, 200, 40);
        add(submit);
        
        start(0); // to set the initial values
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == next){
            repaint();
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);
            
            ans_given =1;
            if(options.getSelection() == null){
                pa[count][0] = "";
            }else{
                pa[count][0] = options.getSelection().getActionCommand();
            }
            if(count == 8){
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            count++;
            start(count);
        }else if(ae.getSource() == submit){
            ans_given = 1;
            if(options.getSelection() == null){
                    pa[count][0] = "";
                }else{
                    pa[count][0] = options.getSelection().getActionCommand();
                }
                for(int i=0; i < pa.length ; i++){
                   if(pa[i][0].equals(qa[i][1])){
                    score+=10;
                }else{
                       score+=0;
                   }
                }
                this.setVisible(false);
                new Score(username, score).setVisible(true);
        }else if(ae.getSource() ==lifeline){
            if(count == 2 || count == 4 || count == 6 || count == 8 || count == 9){
                opt2.setEnabled(false);
                opt3.setEnabled(false);
            }else {
                opt1.setEnabled(false);
                opt4.setEnabled(false);
            }
            lifeline.setEnabled(false);
        }
    }
    
    public void paint(Graphics g){
        super.paint(g);
        String time = "Time Left - "+ timer +"seconds"; //59
        g.setColor(Color.red);
        g.setFont(new Font("Tahoma", Font.BOLD,25));
        
        
        if(timer > 0){
            g.drawString(time, 1110, 500);
        }else{
            g.drawString("Times Up!", 1110, 500);
        }
        timer--;
        
        try{
            Thread.sleep(1000);
            repaint();
        }catch(Exception e){
            e.printStackTrace();
        }
            
        if(ans_given == 1){
            ans_given = 0;
            timer = 60;
        }else if(timer < 0){
            timer = 60;
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);
            if(count == 8){
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            if (count == 9){
                if(options.getSelection() == null){
                    pa[count][0] = "";
                }else{
                    pa[count][0] = options.getSelection().getActionCommand();
                }
                for(int i=0; i < pa.length ; i++){
                   if(pa[i][0].equals(qa[i][1])){
                        score+=10;
                    }else{
                        score+=0;
                   }
                }
                this.setVisible(false);
                new Score(username, score).setVisible(true);
            }else{
                if(options.getSelection() == null){
                    pa[count][0] = "";
                }else{
                    pa[count][0] = options.getSelection().getActionCommand();
                }
                count++;
                start(count);
                
            }
        }
    }
    public void start(int count){
        qno.setText(""+(count+1)+". ");
        question.setText(q[count][0]);
        opt1.setLabel(q[count][1]);
        opt1.setActionCommand(q[count][1]);
        opt2.setLabel(q[count][2]);
        opt2.setActionCommand(q[count][2]);
        opt3.setLabel(q[count][3]);
        opt3.setActionCommand(q[count][3]);
        opt4.setLabel(q[count][4]);
        opt4.setActionCommand(q[count][4]);
        options.clearSelection();
    }
    
    public static void main(String[] args){
        new Quiz("").setVisible(true);
    }
}
