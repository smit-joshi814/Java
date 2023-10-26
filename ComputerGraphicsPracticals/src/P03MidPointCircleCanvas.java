//Canvas for Practical-03

import java.awt.*;
import java.awt.geom.*;

public class P03MidPointCircleCanvas extends Canvas implements Runnable {

    float x, y, p, r;

    public void drawMidPointCircle(float r) {
        this.r = r;

        new Thread(this).start();
    }

    @Override
    public void run() {

        Graphics g = null;

        x = 0;
        y = r;
        p = 1.25f - r;

        do {
            repaint();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }

            if (p < 0) {
                x = x + 1;
                p = p + (2 * x) + 2;
            } else {
                x = x + 1;
                y = y - 1;
                p = p + (2 * (x - y)) + 1;
            }
        } while (x < y);
    }

    public void drawXY(Graphics g) {
        Dimension d = getSize();
        int maxX = d.width - 1;
        int maxY = d.height - 1;
//        Graphics2D g2d = (Graphics2D) g.create();
//        
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
//        g2d.setStroke(bsThick);
        Point2D.Float point = new Point2D.Float();

        //Point-1
        point.setLocation(200 + x, 200 + y);
        g2d.draw(new Line2D.Float(point, point));

        //Point-2
        point.setLocation(200 + y, 200 + x);
        g2d.draw(new Line2D.Float(point, point));

        //Point-3
        point.setLocation(200 + x, 200 - y);
        g2d.draw(new Line2D.Float(point, point));

        //Point-4
        point.setLocation(200 + y, 200 - x);
        g2d.draw(new Line2D.Float(point, point));

        //Poin-5
        point.setLocation(200 - x, 200 - y);
        g2d.draw(new Line2D.Float(point, point));

        //Point-6
        point.setLocation(200 - y, 200 - x);
        g2d.draw(new Line2D.Float(point, point));

        //Point-7
        point.setLocation(200 - x, 200 + y);
        g2d.draw(new Line2D.Float(point, point));

        //Point-8
        point.setLocation(200 - y, 200 + x);
        g2d.draw(new Line2D.Float(point, point));
    }
}