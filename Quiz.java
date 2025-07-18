package QuizApp;

import QuizApp.Color_Button.FrameColorSize;
import QuizApp.Round.RoundedButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.ImageIcon;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Quiz extends JFrame implements ActionListener {

    String[][] questions = new String[10][5];
    String[][] answers = new String[10][2];
    String[][] useranswers = new String[10][1];

    JLabel qno, question;
    JRadioButton opt1, opt2, opt3, opt4;

    RoundedButton next;
    RoundedButton submit;
    ButtonGroup groupoptions;

    public static int timer;
    public static int ansGiven;
    public static int count;
    public static int score;

    String name;
    int phoneNumber;

    Quiz(String name, int phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;

        // Reset static variables
        timer = 27;
        ansGiven = 0;
        count = 0;
        score = 0;

        FrameColorSize.setFrameProperties(this);
        FrameColorSize.addContentPanel(this);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("QuizApp/icons/quiz.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, FrameColorSize.frameWidth, FrameColorSize.frameHeight / 2);
        add(image);

        qno = new JLabel();
        qno.setBounds(100, FrameColorSize.frameHeight / 2 + 20, 50, 30);
        qno.setFont(new Font("Devanagari", Font.BOLD, 24));
        qno.setForeground(Color.decode("#FFC0CB"));
        add(qno);

        question = new JLabel();
        question.setBounds(150, FrameColorSize.frameHeight / 2 + 20, 900, 30);
        question.setFont(new Font("Devanagari", Font.BOLD, 24));
        question.setForeground(Color.decode("#FFC0CB"));
        add(question);

        // Initialize questions and answers
        initializeQuestions();

        opt1 = new JRadioButton("Option 1");
        opt1.setBounds(120, FrameColorSize.frameHeight / 2 + 70, 700, 30);
        opt1.setFont(new Font("Devanagari", Font.BOLD, 20));
        opt1.setForeground(Color.decode("#FFC0CB"));
        opt1.setOpaque(false);
        add(opt1);

        opt2 = new JRadioButton("Option 2");
        opt2.setBounds(120, FrameColorSize.frameHeight / 2 + 100, 700, 30);
        opt2.setFont(new Font("Devanagari", Font.BOLD, 20));
        opt2.setForeground(Color.decode("#FFC0CB"));
        opt2.setOpaque(false);
        add(opt2);

        opt3 = new JRadioButton("Option 3");
        opt3.setBounds(120, FrameColorSize.frameHeight / 2 + 130, 700, 30);
        opt3.setFont(new Font("Devanagari", Font.BOLD, 20));
        opt3.setForeground(Color.decode("#FFC0CB"));
        opt3.setOpaque(false);
        add(opt3);

        opt4 = new JRadioButton("Option 4");
        opt4.setBounds(120, FrameColorSize.frameHeight / 2 + 160, 700, 30);
        opt4.setFont(new Font("Devanagari", Font.BOLD, 20));
        opt4.setForeground(Color.decode("#FFC0CB"));
        opt4.setOpaque(false);
        add(opt4);

        groupoptions = new ButtonGroup();
        groupoptions.add(opt1);
        groupoptions.add(opt2);
        groupoptions.add(opt3);
        groupoptions.add(opt4);

        next = new RoundedButton("अगला / Next");
        next.setBounds(FrameColorSize.frameWidth - 250, FrameColorSize.frameHeight - 150, 240, 30);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);

        submit = new RoundedButton("जमा करना / Submit");
        submit.setBounds(FrameColorSize.frameWidth - 250, FrameColorSize.frameHeight - 100, 240, 30);
        submit.setForeground(Color.WHITE);
        submit.setEnabled(false);
        submit.addActionListener(this);
        add(submit);

        start(count);
    }

    private void initializeQuestions() {
        questions[0][0] = "Which is used to find and fix bugs in the Java programs.?";
        questions[0][1] = "JVM";
        questions[0][2] = "JDB";
        questions[0][3] = "JDK";
        questions[0][4] = "JRE";

        questions[1][0] = "What is the return type of the hashCode() method in the Object class?";
        questions[1][1] = "int";
        questions[1][2] = "Object";
        questions[1][3] = "long";
        questions[1][4] = "void";

        questions[2][0] = "Which package contains the Random class?";
        questions[2][1] = "java.util package";
        questions[2][2] = "java.lang package";
        questions[2][3] = "java.awt package";
        questions[2][4] = "java.io package";

        questions[3][0] = "An interface with no fields or methods is known as?";
        questions[3][1] = "Runnable Interface";
        questions[3][2] = "Abstract Interface";
        questions[3][3] = "Marker Interface";
        questions[3][4] = "CharSequence Interface";

        questions[4][0] = "In which memory a String is stored, when we create a string using new operator?";
        questions[4][1] = "Stack";
        questions[4][2] = "String memory";
        questions[4][3] = "Random storage space";
        questions[4][4] = "Heap memory";

        questions[5][0] = "Which of the following is a marker interface?";
        questions[5][1] = "Runnable interface";
        questions[5][2] = "Remote interface";
        questions[5][3] = "Readable interface";
        questions[5][4] = "Result interface";

        questions[6][0] = "Which keyword is used for accessing the features of a package?";
        questions[6][1] = "import";
        questions[6][2] = "package";
        questions[6][3] = "extends";
        questions[6][4] = "export";

        questions[7][0] = "In java, jar stands for?";
        questions[7][1] = "Java Archive Runner";
        questions[7][2] = "Java Archive";
        questions[7][3] = "Java Application Resource";
        questions[7][4] = "Java Application Runner";

        questions[8][0] = "Which of the following is a mutable class in java?";
        questions[8][1] = "java.lang.StringBuilder";
        questions[8][2] = "java.lang.Short";
        questions[8][3] = "java.lang.Byte";
        questions[8][4] = "java.lang.String";

        questions[9][0] = "Which of the following option leads to the portability and security of Java?";
        questions[9][1] = "Bytecode is executed by JVM";
        questions[9][2] = "The applet makes the Java code secure and portable";
        questions[9][3] = "Use of exception handling";
        questions[9][4] = "Dynamic binding between objects";

        answers[0][1] = "JDB";
        answers[1][1] = "int";
        answers[2][1] = "java.util package";
        answers[3][1] = "Marker Interface";
        answers[4][1] = "Heap memory";
        answers[5][1] = "Remote interface";
        answers[6][1] = "import";
        answers[7][1] = "Java Archive";
        answers[8][1] = "java.lang.StringBuilder";
        answers[9][1] = "Bytecode is executed by JVM";
    }

    public void start(int count) {        // use to show questions automatically
        qno.setText("" + (count + 1));
        question.setText(questions[count][0]);

        opt1.setText(questions[count][1]);               // used to show option
        opt1.setActionCommand(questions[count][1]);      // tells that this option is selected

        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);

        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);

        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);

        groupoptions.clearSelection();   // option is selected in last option shows in next option
    }

    public void paint(Graphics g) {      // paint method is automatically calls so no need to call
        super.paint(g);

        // timer
        String time = "Time Left : " + timer + "sec";
        g.setColor(Color.red);
        g.setFont(new Font("Devanagari", Font.BOLD, 20));

        if (timer > 0) {
            g.drawString(time, FrameColorSize.frameWidth - 200, FrameColorSize.frameHeight / 2 - 20);
        } else {
            g.drawString("Times up", FrameColorSize.frameWidth - 200, (FrameColorSize.frameHeight / 2) - 20);
        }
        timer--;

        try {
            Thread.sleep(1000);
            repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (ansGiven == 1) {   // check answer selected
            ansGiven = 0;
            timer = 27;
        } else if (timer < 0) {
            timer = 15;

            if (count == 8) {
                next.setEnabled(false);  // in last question next is disabled
                submit.setEnabled(true);  // in last question submit is enabled
            }

            if (groupoptions.getSelection() == null) { // check which option is selected
                useranswers[count][0] = "";
            } else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
                // all 4 options.selected option.value
            }

            if (count == 9) {  // submit on time up
                for (int i = 0; i < useranswers.length; i++) {
                    if (useranswers[i][0].equals(answers[i][1])) {
                        score += 10;
                    }
                }
                setVisible(false);
                new Score(name, phoneNumber, score).setVisible(true);
            } else {   // next question
                count++;
                start(count);  // next question
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Quiz("User", 2354).setVisible(true);
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == next) {
            repaint(); // refresh

            ansGiven = 1;
            if (groupoptions.getSelection() == null) { // check which option is selected
                useranswers[count][0] = "";
            } else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
                // all 4 options.selected option.value
            }

            if (count == 8) {
                next.setEnabled(false);  // in last question next is disabled
                submit.setEnabled(true);  // in last question submit is enabled
            }

            count++;
            start(count); // next question
        } else if (e.getSource() == submit) {
            ansGiven = 1;
            if (groupoptions.getSelection() == null) { // check which option is selected for last option
                useranswers[count][0] = "";
            } else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
                // all 4 options.selected option.value
            }

            if (count == 9) {  // submit on time up
                for (int i = 0; i < useranswers.length; i++) {
                    if (useranswers[i][0].equals(answers[i][1])) {
                        score += 10;
                    }
                }
                setVisible(false);
                new Score(name, phoneNumber, score).setVisible(true);
            }
        }
    }
}
