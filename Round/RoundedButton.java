package QuizApp.Round;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class RoundedButton extends JButton {

    private Shape shape;
    private Color borderColor = Color.BLACK; // Border color
    private Color normalColor = new Color(47, 60, 126); // Normal background color
    private Color pressedColor = new Color(25, 33, 70); // Darker blue color when pressed

    public RoundedButton(String label) {
        super(label);
        setup();
    }

    private void setup() {
        setOpaque(false); // Make the button transparent
        setContentAreaFilled(false); // Do not fill content area
        setBorderPainted(false); // Do not paint default border
        setFocusPainted(false); // Do not paint focus state
        setBackground(normalColor); // Set normal background color
        setForeground(Color.WHITE); // Set foreground color (text color)
        setFont(new Font("Devanagari", Font.BOLD, 19)); // Set font
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        if (getModel().isPressed()) {
            g2d.setColor(pressedColor); // Use darker blue color when pressed
        } else {
            g2d.setColor(getBackground()); // Use normal background color
        }
        g2d.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15); // Rounded rectangle shape

        // Draw border
        g2d.setColor(borderColor);
        g2d.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15); // Rounded rectangle border

        g2d.dispose();
        super.paintComponent(g);
    }

    @Override
    public boolean contains(int x, int y) {
        if (shape == null || !shape.getBounds().equals(getBounds())) {
            shape = new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
        }
        return shape.contains(x, y);
    }
}
