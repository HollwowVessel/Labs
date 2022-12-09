import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JFrame;

class Picture extends Canvas {
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Rectangle r = g.getClipBounds();

        g.setColor(Color.orange);
        g.fillOval(r.x + 10, r.y + 480, 30, 30);
        g.setColor(new Color(0, 127, 0));
        g.drawOval(r.x + 10, r.y + 480, 30, 30);

        g.setColor(Color.black);
        g.fillOval(r.x + 480, r.y + 10, 30, 30);
        g.setColor(new Color(0, 127, 0));
        g.drawOval(r.x + 480, r.y + 10, 30, 30);

        g.setColor(Color.cyan);
        g.fillOval(r.x + 480, r.y + 480, 30, 30);
        g.setColor(new Color(0, 127, 0));
        g.drawOval(r.x + 480, r.y + 480, 30, 30);

        g.setColor(Color.blue);
        g.fillOval(r.x + 10, r.y + 10, 30, 30);
        g.setColor(new Color(0, 127, 0));
        g.drawOval(r.x + 10, r.y + 10, 30, 30);

        g.setColor(Color.magenta);
        int[]x={220,150,20,90,50,220,400,350,440,290};
        int[]y={60,170,170,300,430,350,430,300,170,170};
        g.fillPolygon(x, y,10);
        setForeground(Color.magenta);

        g.setColor(Color.green);
        g.drawRect(r.x + 10, r.y + 10, 500, 500);
    }
}

class Form extends JFrame {
    public Form() {
        super("Рисунок");
        setBounds(100, 50, 800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new Picture());
        validate();
        setVisible(true);
    }
}

public class Main {
    public static void main(String[] args) {
        new Form();
    }
}