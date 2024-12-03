package quiz.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Score extends JFrame implements ActionListener {
    JButton playAgainButton, answerKeysButton;

    Score(String username, int score) {
        // Increase window size for better display
        setBounds(400, 50, 1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set layout to null for absolute positioning
        setLayout(null);

        // Add a full background image with a historical theme
        ImageIcon backgroundIcon = new ImageIcon(ClassLoader.getSystemResource("quiz/game/icons/score.png"));
        Image backgroundImage = backgroundIcon.getImage().getScaledInstance(1000, 700, Image.SCALE_DEFAULT);
        ImageIcon resizedBackground = new ImageIcon(backgroundImage);
        JLabel backgroundLabel = new JLabel(resizedBackground);
        backgroundLabel.setBounds(0, 0, 1000, 700);
        add(backgroundLabel);

        // Add a thank-you message centered at the top
        JLabel thankYouLabel = new JLabel("Thank you, " + username + ", for Playing Time Trail Quiz!");
        thankYouLabel.setBounds(0, 20, 1000, 50);
        thankYouLabel.setFont(new Font("Serif", Font.BOLD, 30));
        thankYouLabel.setForeground(new Color(92, 64, 51)); // Deep brown
        thankYouLabel.setHorizontalAlignment(SwingConstants.CENTER);
        backgroundLabel.add(thankYouLabel);

        // Add "SCORE:" label
        JLabel scoreTitleLabel = new JLabel("SCORE:");
        scoreTitleLabel.setBounds(300, 250, 200, 50);
        scoreTitleLabel.setFont(new Font("Serif", Font.BOLD, 40));
        scoreTitleLabel.setForeground(new Color(139, 69, 19)); // Brown
        backgroundLabel.add(scoreTitleLabel);

        // Add "Your Score" beside "SCORE:"
        JLabel scoreLabel = new JLabel(String.valueOf(score));
        scoreLabel.setBounds(500, 250, 150, 50);
        scoreLabel.setFont(new Font("Verdana", Font.BOLD, 40));
        scoreLabel.setForeground(new Color(139, 69, 19)); // Brown
        backgroundLabel.add(scoreLabel);

        // Add a Play Again button
        playAgainButton = new JButton("Play Again");
        playAgainButton.setBounds(350, 450, 150, 40);
        playAgainButton.setBackground(new Color(205, 133, 63)); // Peru color
        playAgainButton.setForeground(Color.WHITE);
        playAgainButton.setFont(new Font("Arial", Font.BOLD, 16));
        playAgainButton.setFocusPainted(false);
        playAgainButton.addActionListener(this);
        backgroundLabel.add(playAgainButton);

        // Add an Answer Keys button
        answerKeysButton = new JButton("Answer Keys");
        answerKeysButton.setBounds(550, 450, 150, 40);
        answerKeysButton.setBackground(new Color(205, 133, 63)); // Peru color
        answerKeysButton.setForeground(Color.WHITE);
        answerKeysButton.setFont(new Font("Arial", Font.BOLD, 16));
        answerKeysButton.setFocusPainted(false);
        answerKeysButton.addActionListener(this);
        backgroundLabel.add(answerKeysButton);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == playAgainButton) {
            // Return to the quiz game
            this.setVisible(false);
            new Quiz("Player").setVisible(true);
        } else if (ae.getSource() == answerKeysButton) {
            // Show answer keys in a new window
            JFrame answerFrame = new JFrame("Answer Keys");
            answerFrame.setBounds(300, 50, 800, 600);
            answerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            // Create a container with brown background
            JPanel panel = new JPanel(new BorderLayout());
            panel.setBackground(new Color(139, 69, 19)); // Brown

            // Create the text area for answer keys
            JTextArea answersArea = new JTextArea();
            answersArea.setFont(new Font("Monospaced", Font.PLAIN, 18));
            answersArea.setForeground(Color.WHITE);
            answersArea.setBackground(new Color(139, 69, 19)); // Match background
            answersArea.setEditable(false);
            answersArea.setText(
                "Answer Keys:\n" +
                "1. Andres Bonifacio\n" +
                "2. Kataastaasan, Kagalang-galang na Katipunan ng mga Anak ng Bayan\n" +
                "3. Monica\n" +
                "4. Graciano Lopez Jaena\n" +
                "5. Gobernadorcillo\n" +
                "6. Cagayan River\n" +
                "7. Claudius Ptolemy\n" +
                "8. Ruy Lopez de Villalobos\n" +
                "9. July 4, 1946\n" +
                "10. Marcelo Hilario del Pilar"
            );

            // Add a scroll pane for the text area
            JScrollPane scrollPane = new JScrollPane(answersArea);
            panel.add(scrollPane, BorderLayout.CENTER);

            // Close button for the answer keys window
            JButton closeButton = new JButton("Close");
            closeButton.setFont(new Font("Arial", Font.BOLD, 16));
            closeButton.setBackground(new Color(205, 133, 63)); // Peru color
            closeButton.setForeground(Color.WHITE);
            closeButton.addActionListener(e -> answerFrame.dispose());
            panel.add(closeButton, BorderLayout.SOUTH);

            answerFrame.add(panel);
            answerFrame.setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Score("User", 40).setVisible(true);
    }
}
