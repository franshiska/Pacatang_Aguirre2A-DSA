package quiz.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuizGame extends JFrame implements ActionListener {

    JButton b1, b2, b3; // Buttons
    JTextField t1;

    QuizGame() {
        // Set window properties
        setBounds(300, 100, 1400, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        // Set background image
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon backgroundImage = new ImageIcon(ClassLoader.getSystemResource("quiz/game/icons/login.png"));
                g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), null);
            }
        };
        backgroundPanel.setLayout(null);
        setContentPane(backgroundPanel);

        // Centered panel for content
        JPanel contentPanel = new JPanel();
        contentPanel.setBounds(500, 300, 400, 300); // Adjusted position for centered and slightly lower layout
        contentPanel.setOpaque(false); // Transparent background
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        backgroundPanel.add(contentPanel);

        // Add name prompt
        JLabel l3 = new JLabel("Enter Your Name");
        l3.setFont(new Font("Mongolian Baiti", Font.BOLD, 22));
        l3.setForeground(new Color(51, 0, 0));
        l3.setAlignmentX(Component.CENTER_ALIGNMENT);
        contentPanel.add(l3);

        // Add spacing
        contentPanel.add(Box.createRigidArea(new Dimension(0, 15)));

        // Add text field
        t1 = new JTextField();
        t1.setMaximumSize(new Dimension(300, 30));
        t1.setFont(new Font("Times New Roman", Font.BOLD, 20));
        contentPanel.add(t1);

        // Add spacing
        contentPanel.add(Box.createRigidArea(new Dimension(0, 30)));

        // Add "Rules" button
        b1 = new JButton("Rules");
        styleButton(b1);
        contentPanel.add(b1);

        // Add spacing
        contentPanel.add(Box.createRigidArea(new Dimension(0, 15)));

        // Add "Exit" button
        b2 = new JButton("Exit");
        styleButton(b2);
        contentPanel.add(b2);

        // Add spacing
        contentPanel.add(Box.createRigidArea(new Dimension(0, 15)));

        // Add "Credits" button
        b3 = new JButton("Credits");
        styleButton(b3);
        contentPanel.add(b3);

        setVisible(true);
    }

    // Method to style buttons
    private void styleButton(JButton button) {
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setBackground(new Color(204, 102, 0));
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Tahoma", Font.PLAIN, 16));
        button.setMaximumSize(new Dimension(200, 30));
        button.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            String name = t1.getText();
            this.setVisible(false);
            new Rules(name); // Assumes a "Rules" class exists
        } else if (ae.getSource() == b3) {
            new Credits();
        } else {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new QuizGame();
    }
}

// Credits window class
class Credits extends JFrame {

    Credits() {
        // Set larger window dimensions
        setBounds(300, 100, 1200, 800);
        getContentPane().setBackground(new Color(139, 69, 19));
        setLayout(null);

        // Add title
        JLabel title = new JLabel("Credits");
        title.setFont(new Font("Viner Hand ITC", Font.BOLD, 50)); // Larger font for bigger window
        title.setForeground(Color.WHITE);
        title.setBounds(450, 30, 300, 60); // Centered position
        add(title);

        // Add credits text
        JLabel text = new JLabel(
                "<html>" +
                "<b>Leader:</b> Franshiska Michaella P. Pacatang<br>" +
                "Email: franshiskapacatang@gmail.com<br>" +
                "Role: Coded quiz, quizgame, score window<br><br>" +
                "Number: 09958235505<br><br>" +

                "<b>Member:</b> Lady Samantha S. Aguirre<br>" +
                "Email: ladysamanthaaguirre@gmail.com<br>" +
                "Role: Gathered history lessons, Created questionnaires, Created script, coded rules window, designer<br><br>" +
                "Number: 09958235505<br>" +
                "</html>"
        );
        text.setFont(new Font("Mongolian Baiti", Font.PLAIN, 22)); // Larger font
        text.setForeground(Color.WHITE);

        // Scroll pane for content
        JScrollPane scrollPane = new JScrollPane(text);
        scrollPane.setBounds(200, 150, 800, 500); // Scalable content area
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBorder(null);
        add(scrollPane);

        // Add back button
        JButton back = new JButton("Back");
        back.setBounds(550, 700, 100, 40); // Centered at bottom
        back.setBackground(new Color(204, 102, 0));
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Tahoma", Font.PLAIN, 18));
        back.addActionListener(e -> this.setVisible(false));
        add(back);

        setVisible(true);
    }
}
