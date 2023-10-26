/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicals.pr14;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Arrays;

/**
 *
 * @author smitj
 */
public class P14Canvas extends Canvas {

    int[] xPoints;
    int[] yPoints;
    int points = 0;

    public void drawPoly(String xc, String yc) {
        xPoints = Arrays.stream(xc.split(",")).mapToInt(Integer::parseInt).toArray();
        yPoints = Arrays.stream(yc.split(",")).mapToInt(Integer::parseInt).toArray();
        points = xPoints.length;
        repaint();
    }

    public void shearPoly(String xc, String yc, int sh, char axe) {
        drawPoly(xc, yc);
        if (Character.toUpperCase(axe) == 'X') {
            for (int i = 0; i < xPoints.length; i++) {
                xPoints[i] += sh * (yPoints[i] - xPoints[0]);
            }
        }
        if (Character.toUpperCase(axe) == 'Y') {
            for (int i = 0; i < yPoints.length; i++) {
                yPoints[i] += sh * (xPoints[i] - yPoints[0]);
            }
        }
        repaint();
    }

    public void drawXY(Graphics g) {
        Dimension d = getSize();
        int maxX = d.width - 1;
        int maxY = d.height - 1;
        g.drawRect(0, 0, maxX, maxY);//Canvas Border-Size Rectangle
        //Graph Value on Y-Axe
        for (int i = 0; i <= maxY; i = i + 50) {
            g.drawString(Integer.toString(i), 0, i);
        }
        //Graph Value on X-Axe
        for (int i = 0; i <= maxX; i = i + 50) {
            g.drawString(Integer.toString(i), i, 10);
        }
    }

    @Override
    public void update(Graphics g) {
        paint(g);
    }

    @Override
    public void paint(Graphics g) {
        drawXY(g);
        if (points > 0) {
            g.drawPolygon(xPoints, yPoints, points);
        }
    }
}
