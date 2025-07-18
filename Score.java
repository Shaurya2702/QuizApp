package QuizApp;

import QuizApp.Color_Button.FrameColorSize;
import QuizApp.Round.RoundedButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JEditorPane;
import javax.swing.SwingUtilities;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Score extends JFrame implements ActionListener {

    String name;
    int phoneNumber;
    int score;
    RoundedButton exit;
    RoundedButton tryAgain;
    RoundedButton home;

    Score (String name, int phoneNumber, int score) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.score = score;
        FrameColorSize.setFrameProperties(this);
        FrameColorSize.addContentPanel(this);

        JLabel scoreLable = new JLabel("Your score : " + score);
        scoreLable.setBounds(500, 100, 400, 45);
        scoreLable.setFont(new Font("Devanagari", Font.BOLD, 40));
        scoreLable.setForeground(Color.decode("#0000FF"));
        add(scoreLable);

        // Create an HTML table with a transparent background
        String htmlContent = "<html>" +
                "<body>" +
                "<table border='1' style='width:100%; font-size:20px; background-color:transparent;'>" +
                "<tr style='background-color:transparent;'>" +
                "<th>Name</th>" +
                "<th>Phone Number</th>" +
                "<th>Score</th>" +
                "</tr>" +
                "<tr style='background-color:transparent;'>" +
                "<td>" + name + "</td>" +
                "<td>" + phoneNumber + "</td>" +
                "<td>" + score + "</td>" +
                "</tr>" +
                "</table>" +
                "</body>" +
                "</html>";

        JEditorPane htmlPane = new JEditorPane("text/html", htmlContent);
        htmlPane.setBounds(200, 200, 800, 150);
        htmlPane.setOpaque(false); // Make the JEditorPane transparent
        htmlPane.setEditable(false);
        add(htmlPane);

        home = new RoundedButton("घर / Home");
        home.setBounds(400, 400, 300, 45);
        home.setFont(new Font("Devanagari", Font.BOLD, 20));
        home.setForeground(Color.WHITE);
        home.addActionListener(this);
        add(home);

        tryAgain = new RoundedButton("दुबारा / Try Again");
        tryAgain.setBounds(400, 460, 300, 45);
        tryAgain.setFont(new Font("Devanagari", Font.BOLD, 20));
        tryAgain.setForeground(Color.WHITE);
        tryAgain.addActionListener(this);
        add(tryAgain);

        exit = new RoundedButton("बाहर / Exit");
        exit.setBounds(400, 520, 300, 45);
        exit.setFont(new Font("Devanagari", Font.BOLD, 20));
        exit.setForeground(Color.WHITE);
        exit.addActionListener(this);
        add(exit);
    }

    public static void main (String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Score("User", 1234567890, 95).setVisible(true);
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exit) {
            System.exit(0);
        } else if (e.getSource() == tryAgain) {
            setVisible(false);
            new Quiz(name,phoneNumber);
        } else if (e.getSource() == home) {
            setVisible(false);
            new Login();
        }
    }
}
