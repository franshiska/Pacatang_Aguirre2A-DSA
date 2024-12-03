package quiz.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Rules extends JFrame implements ActionListener {
    JButton b1, b2;
    String username;

    Rules(String username) {
        this.username = username;

        // Set the frame properties
        setBounds(500, 100, 900, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Add the background image
        ImageIcon backgroundIcon = new ImageIcon(ClassLoader.getSystemResource("quiz/game/icons/rules.png"));
        Image backgroundImage = backgroundIcon.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
        JLabel backgroundLabel = new JLabel(new ImageIcon(backgroundImage));
        backgroundLabel.setBounds(0, 0, 900, 700);
        add(backgroundLabel);

        // Add a welcome label
        JLabel l1 = new JLabel("Welcome " + username + " to Time Trail Quiz!");
        l1.setForeground(new Color(204, 102, 0)); // Orange-brown color
        l1.setFont(new Font("Viner Hand ITC", Font.BOLD, 28));
        l1.setBounds(50, 20, 800, 30);
        backgroundLabel.add(l1);

        // Add "Rules of The Game" title
        JLabel rulesTitle = new JLabel("Rules of The Game");
        rulesTitle.setForeground(new Color(204, 102, 0)); // Orange-brown color
        rulesTitle.setFont(new Font("Viner Hand ITC", Font.BOLD, 26));
        rulesTitle.setHorizontalAlignment(SwingConstants.CENTER); // Center align text
        rulesTitle.setBounds(50, 80, 800, 30);
        backgroundLabel.add(rulesTitle);

        // Add the rules text
        JLabel l2 = new JLabel();
        l2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        l2.setBounds(50, 130, 800, 300);
        l2.setHorizontalAlignment(SwingConstants.CENTER); // Center align text
        l2.setVerticalAlignment(SwingConstants.TOP); // Ensure text aligns from the top
        l2.setText(
            "<html><div style='text-align: center;'>" + // Center align text in HTML
                "1. Answer each question to the best of your ability.<br><br>" +
                "2. You have 60 seconds to answer each question.<br><br>" +
                "3. After the timer runs out, you cannot answer the question.<br><br>" +
                "4. All questions are mandatory; skipping is not allowed.<br><br>" +
                "5. Once you submit an answer, you cannot change it.<br><br>" +
                "6. The 50-50 lifeline removes two incorrect options from a multiple-choice question.<br><br>" +
                "7. Stay calm and focused, you've got this!<br><br>" +
                "Good Luck!!!" +
            "</div></html>"
        );
        backgroundLabel.add(l2);

        // Add a "Back" button
        b1 = new JButton("Back");
        b1.setBounds(300, 500, 100, 30);
        b1.setBackground(new Color(204, 102, 0)); // Orange-brown color
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        backgroundLabel.add(b1);

        // Add a "Start" button
        b2 = new JButton("Start");
        b2.setBounds(500, 500, 100, 30);
        b2.setBackground(new Color(204, 102, 0)); // Orange-brown color
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        backgroundLabel.add(b2);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            this.setVisible(false);
            new QuizGame().setVisible(true);
        } else if (ae.getSource() == b2) {
            this.setVisible(false);
            new Quiz(username).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Rules("User");
    }
}


