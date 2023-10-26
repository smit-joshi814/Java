/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicals.pr16;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.Arrays;

/**
 *
 * @author smitj
 */
public class P16Canvas extends Canvas implements Runnable {

    int[] xPoints;
    int[] yPoints;
    int pTotal = 0;
    float x, y;
    boolean winFlag = false, pointFlag = false;
    double Xwmin, Ywmin, Xwmax, Ywmax;

    public void drawWindow(double Xwmn, double Ywmn, double Xwmx, double Ywmx) {

        Xwmin = Xwmn;
        Ywmin = Ywmn;
        Xwmax = Xwmx;
        Ywmax = Ywmx;
        winFlag = true;
        repaint();
    }

    public void clipPoints(String xc, String yc) {
        xPoints = Arrays.stream(xc.split(",")).mapToInt(Integer::parseInt).toArray();
        yPoints = Arrays.stream(yc.split(",")).mapToInt(Integer::parseInt).toArray();
        pTotal = xPoints.length;
        new Thread(this).start();
    }

    @Override
    public void run() {
        for (int i = 0; i < pTotal; i++) {
            pointFlag = true;
            if ((Xwmin <= xPoints[i] && xPoints[i] <= Xwmax) && (Ywmin <= yPoints[i] && yPoints[i] <= Ywmax)) {
                x = xPoints[i];
                y = yPoints[i];
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
            repaint();
        }
    }

    public void drawXY(Graphics g) {
        Dimension d = getSize();
        int maxX = d.width - 1;
        int maxY = d.height - 1;
        g.drawRect(0, 0, maxX, maxY);//Canvas Border-Size Rectangle
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
        if (winFlag) {
            Rectangle2D.Double Rect = new Rectangle2D.Double(Xwmin, Ywmin, Xwmax - Xwmin, Ywmax - Ywmin);
            g2d.draw(Rect);
        }
        if (pointFlag) {
            Point2D.Float point = new Point2D.Float(x, y);
            g2d.draw(new Line2D.Float(point, point));
        }
    }
}
