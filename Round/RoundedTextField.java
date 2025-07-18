package QuizApp.Round;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class RoundedTextField extends JTextField {

    private Shape shape;

    public RoundedTextField(int columns) {
        super(columns);
        setup();
    }

    private void setup() {
        setOpaque(false); // Make the text field transparent
        setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10)); // Add padding
        setBackground(new Color(255, 255, 255, 255)); // Set white background
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(getBackground());
        g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15); // Rounded rectangle shape
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15); // Rounded rectangle border
    }

    @Override
    public boolean contains(int x, int y) {
        if (shape == null || !shape.getBounds().equals(getBounds())) {
            shape = new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
        }
        return shape.contains(x, y);
    }
}
