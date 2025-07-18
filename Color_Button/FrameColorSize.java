package QuizApp.Color_Button;

import javax.swing.*;
import java.awt.*;

public class FrameColorSize {
    public static int frameWidth;
    public static int frameHeight;
    public static void setFrameProperties(JFrame frame) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int sW = screenSize.width;
        int sH = screenSize.height;

        frameWidth = (int) (sW * 0.8);
        frameHeight = sH;

        int x = (sW - frameWidth) / 2;
        int y = (sH - frameHeight) / 2;

        frame.setSize(frameWidth, frameHeight);
        frame.setLocation(x, y);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setUndecorated(true);
    }

    public static void addContentPanel(JFrame frame) {
        GradientPanel contentPanel = new GradientPanel();
        frame.setContentPane(contentPanel);
        contentPanel.setLayout(null);
        frame.setVisible(true);
    }
}

class GradientPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        int width = getWidth();
        int height = getHeight();

        Color c1 = Color.decode("#0000FF");
        Color c2 = Color.decode("#FFC0CB");

        Point startPoint = new Point(0, 0);
        Point endPoint = new Point(width, 0);

        GradientPaint gradient = new GradientPaint(startPoint, c1, endPoint, c2);
        g2d.setPaint(gradient);
        g2d.fillRect(0, 0, width, height);
    }
}

