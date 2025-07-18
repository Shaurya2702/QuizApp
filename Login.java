package QuizApp;

import QuizApp.Color_Button.FrameColorSize;
import QuizApp.Round.RoundedButton;
import QuizApp.Round.RoundedTextField;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;

import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {

    RoundedButton rules;
    RoundedButton exit;

    RoundedTextField tName;
    RoundedTextField tNumber;

    Login() {
        FrameColorSize.setFrameProperties(this);
        FrameColorSize.addContentPanel(this);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("QuizApp/icons/login.jpeg"));
        JLabel image = new JLabel(i1);
        int frameWidth = getWidth();
        int frameHeight = getHeight();
        int imgWidth = (int) (frameWidth * 0.5);
        int imgHeight = (int) (frameHeight * 0.8);
        image.setBounds(0, (frameHeight - imgHeight) / 2, imgWidth, imgHeight);
        add(image);

        JLabel heading = new JLabel("SS परीक्षा ");
        heading.setBounds(700, 200, 300, 45);
        heading.setFont(new Font("Devanagari", Font.BOLD, 40));
        heading.setForeground(Color.decode("#0000FF"));
        add(heading);

        JLabel name = new JLabel("नाम/Name           : ");
        name.setBounds(650, 350, 160, 24);
        name.setFont(new Font("Devanagari", Font.BOLD, 19));
        name.setForeground(Color.decode("#0000FF"));
        add(name);

        tName = new RoundedTextField(15);
        tName.setBounds(820,350 , 190, 24);
        tName.setForeground(Color.decode("#0000FF"));
        add(tName);

        JLabel number = new JLabel("Phone Number  : ");
        number.setBounds(650,400 , 160, 24); // Increased width
        number.setFont(new Font("Devanagari", Font.BOLD, 19));
        number.setForeground(Color.decode("#0000FF"));
        add(number);

        tNumber = new RoundedTextField(15);
        tNumber.setBounds(820,400 , 190, 24);
        tNumber.setForeground(Color.decode("#0000FF"));
        ((AbstractDocument) tNumber.getDocument()).setDocumentFilter(new DigitFilter()); // Restrict to digits
        add(tNumber);

        rules = new RoundedButton("नियम / Rules");
        rules.setBounds(600, 570, 200, 25);
        rules.setForeground(Color.WHITE);
        rules.addActionListener(this);
        add(rules);

        exit = new RoundedButton("बाहर / Exit");
        exit.setBounds(850, 570, 200, 25);
        exit.setForeground(Color.WHITE);
        exit.addActionListener(this);
        add(exit);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Login().setVisible(true);
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == rules) {
            String name = tName.getText();
            int phoneNumber = Integer.parseInt(tNumber.getText());
            setVisible(false);
            new Rules(name, phoneNumber);
        } else if (e.getSource() == exit) {
            System.exit(0);
        }
    }

    // DocumentFilter to restrict input to digits only
    static class DigitFilter extends DocumentFilter {
        private boolean isDigitsOnly(String text) {
            return text != null && text.matches("\\d*");
        }

        @Override
        public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
            if (isDigitsOnly(string)) {
                super.insertString(fb, offset, string, attr);
            }
        }

        @Override
        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
            if (isDigitsOnly(text)) {
                super.replace(fb, offset, length, text, attrs);
            }
        }
    }
}
