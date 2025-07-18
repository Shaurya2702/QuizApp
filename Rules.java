package QuizApp;

import QuizApp.Color_Button.FrameColorSize;
import QuizApp.Round.RoundedButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Rules extends JFrame implements ActionListener {

    RoundedButton back;
    RoundedButton start;

    String name;
    int phoneNumber;

    Rules(String name, int phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;

        FrameColorSize.setFrameProperties(this);
        FrameColorSize.addContentPanel(this);

        JLabel heading = new JLabel("Welcome " + name + "(" + phoneNumber + ") Rules of the Quiz");
        heading.setBounds(100, 50, FrameColorSize.frameWidth, 25);
        heading.setFont(new Font("Devanagari", Font.BOLD, 20));
        heading.setForeground(Color.decode("#FFC0CB"));
        add(heading);

        JLabel rulesText = new JLabel();
        rulesText.setBounds(90, 120, FrameColorSize.frameWidth-10, 350);
        rulesText.setFont(new Font("Arial", Font.BOLD, 16));
        rulesText.setForeground(Color.decode("#FFC0CB"));
        rulesText.setText(
                "<html>"+
                        "1. You are trained to be a programmer and not a story teller, answer point to point" + "<br><br>" +
                        "2. Do not unnecessarily smile at the person sitting next to you, they may also not know the answer" + "<br><br>" +
                        "3. You may have lot of options in life but here all the questions are compulsory" + "<br><br>" +
                        "4. Crying is allowed but please do so quietly." + "<br><br>" +
                        "5. Only a fool asks and a wise answers (Be wise, not otherwise)" + "<br><br>" +
                        "6. Do not get nervous if your friend is answering more questions, may be he/she is doing Jai Mata Di" + "<br><br>" +
                        "7. Brace yourself, this paper is not for the faint hearted" + "<br><br>" +
                        "8. May you know more than what John Snow knows, Good Luck" + "<br><br>" +
                        "<html>"
        );
        add(rulesText);

        back = new RoundedButton("पीछे / Back");
        back.setBounds(250, 500, 160, 30);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        start = new RoundedButton("अरहम्ब / Start");
        start.setBounds(600, 500, 160, 30);
        start.setForeground(Color.WHITE);
        start.addActionListener(this);
        add(start);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Rules("User", 2986).setVisible(true);
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            setVisible(false);
            new Login();
        } else if (e.getSource() == start) {
            setVisible(false);
            new Quiz(name, phoneNumber);
        }
    }
}
