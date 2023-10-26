//Practical-02: Bresenham Line Draw Canvas

import java.awt.*;
import java.awt.geom.*;

public class P02BhamLineCanvas extends Canvas implements Runnable {

    float x, y, x1, y1, x2, y2, dx, dy, e;

    public void drawBhamLine(float xP, float yP, float xQ, float yQ) {

        x1 = xP;
        y1 = yP;
        x2 = xQ;
        y2 = yQ;

        new Thread(this).start();
    }

    @Override
    public void run() {
        dx = Math.abs(x2 - x1);
        dy = Math.abs(y2 - y1);

        x = x1;
        y = y1;
        e = 2 * dy - dx;
        int i = 1;
        do {
            repaint();
            while (e >= 0) {
                y++;
                e -= 2 * dx;
            }
            x++;
            e += 2 * dy;
            i++;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(e.toString());
            }
        } while (i <= dx);
    }

    public void drawXY(Graphics g) {

        Dimension d = getSize();
        int maxX = d.width - 1;
        int maxY = d.height - 1;
//        Graphics2D g2d = (Graphics2D) g.create();

//        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
//        BasicStroke bsThick = new BasicStroke(3.0f);
//        g2d.setStroke(bsThick);
//        g2d.drawRect(0, 0, maxX, maxY);//Canvas Border-Size Rectangle
        g.drawRect(0, 0, maxX, maxY);

        //Graph Value on Y-Axe
        for (int i = 0; i <= maxY; i = i + 50) {
            g.drawString("" + i, 0, i);
        }

        //Graph Value on X-Axe
        for (int i = 0; i <= maxX; i = i + 50) {
            g.drawString("" + i, i, 10);
        }
    }

    @Override
    public void update(Graphics g) {
        paint(g);
    }

    @Override
    public void paint(Graphics g) {

        drawXY(g);
        Graphics2D g2d = (Graphics2D) g.create();

        //Use of antialiasing to have nicer lines
//        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        //Draw the shapes a little bit thicker or thinner.
//        BasicStroke bsThick = new BasicStroke(2.0f);
        Point2D.Float point = new Point2D.Float();

        point.setLocation(x, y);
//        g2d.setStroke(bsThick);
        g2d.draw(new Line2D.Float(point, point));
    }
}
