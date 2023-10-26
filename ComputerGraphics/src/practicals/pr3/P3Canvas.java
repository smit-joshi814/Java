/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicals.pr3;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Line2D;

/**
 *
 * @author smitj
 */
public class P3Canvas extends Canvas implements Runnable {

    Dimension d = null;
    float radious, x, y, p;

    @Override
    public void paint(Graphics g) {
        initCoordinates(d, g, true);
        Graphics2D g2d = (Graphics2D) g.create();

        Point.Float point = new Point.Float();

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

    @Override
    public void update(Graphics g) {
        paint(g);
    }

    public void DrawCiorcle(float r) {
        radious = r;

        new Thread(this).start();
    }

    private void initCoordinates(Dimension d, Graphics g, boolean Grids) {
        d = getSize();
        int xAxis = d.width - 1;
        int yAxis = d.height - 1;

//        g.drawLine(0, 10, xAxis, 10);
//        g.drawLine(10, 0, 10, yAxis);
        g.drawRect(0, 0, xAxis, yAxis);
        for (int i = 0; i < xAxis; i += 50) {
            g.drawString("" + i, i, 10);
            if (Grids) {
                g.drawLine(i, 0, i, yAxis);
            }
        }
        for (int i = 0; i < yAxis; i += 50) {
            g.drawString("" + i, 0, i);
            if (Grids) {
                g.drawLine(0, i, xAxis, i);
            }
        }
    }

    @Override
    public void run() {
        x = 0;
        y = radious;
        p = 1.25f - radious;

        do {
            repaint();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            };
            if (p < 0) {
                p = p + (2 * x) + 2;
            } else {
                y--;
                p = p + (2 * (x - y)) + 1;
            }
            x++;
        } while (x < y);
    }
}
