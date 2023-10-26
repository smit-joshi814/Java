/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicals.pr6;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *
 * @author Lab5_6
 */
public class p6Canvas extends Canvas {

    Dimension d = null;
    int xPoints[], yPoints[], point = 0;
    double x, y, xMin, xMax, yMin, yMax;

    public void drawPoly(String xc, String yc) {
        System.out.println("in drawPoly");
        StringTokenizer xst = new StringTokenizer(xc, ",");
        xPoints = new int[xst.countTokens()];
        int i = 0;
        while (xst.hasMoreTokens()) {
            xPoints = new int[Integer.parseInt(xst.nextElement().toString())];
            i++;
        }

        StringTokenizer yst = new StringTokenizer(yc, ",");
        yPoints = new int[yst.countTokens()];

        point = i;
        while (yst.hasMoreTokens()) {
            yPoints = new int[Integer.parseInt(yst.nextElement().toString())];
        }
        repaint();
    }

    private void initCoordinates(Dimension d, Graphics g, boolean Grids) {
        d = getSize();
        int xAxis = d.width - 1;
        int yAxis = d.height - 1;

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
    public void paint(Graphics g) {
       // initCoordinates(d, g, true);
        Graphics2D g2d = (Graphics2D) g.create();
        Polygon p;
        System.out.println("in Paint");
        if (point > 0) {
            System.out.println("in P > 0"+xPoints+"\n"+yPoints);
            p = new Polygon(xPoints, yPoints, point);
            int min = Arrays.stream(xPoints).boxed().min(Integer::compare).get();
            int max = Arrays.stream(yPoints).boxed().max(Integer::compare).get();

            for (int i = min; i <= max; i++) {
                for (int j = min; j <= max; j++) {
                    x = (double) j;
                    y = (double) i;
                    Point.Double pixel = new Point.Double();
                    pixel.setLocation(x, y);
                    if (p.contains(pixel)) {
                        g2d.setColor(Color.red);
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException ex) {
                        }
                        g2d.draw(new Line2D.Double(pixel, pixel));
                    }
                }
            }
            g2d.drawPolygon(p);
        }

    }
}
