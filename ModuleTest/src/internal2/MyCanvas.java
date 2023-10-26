/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internal2;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

/**
 *
 * @author smitj
 */
public class MyCanvas extends Canvas {

    boolean DrawFlag = false;
    boolean transFlag = false;
    int tx, ty;

    public MyCanvas() {
        repaint();
    }

    public void drawPoly() {
        DrawFlag = true;
        repaint();
    }

    public void transformPoly(int tx, int ty) {
        this.tx = tx;
        this.ty = ty;
        transFlag = true;
        repaint();
    }

    @Override
    public void paint(Graphics g) {

        drawXY(g);
        int[] xPoints = {100, 300, 350, 400, 400, 350, 50, 50};
        int[] yPoints = {100, 100, 150, 150, 200, 200, 200, 150};
        int points = xPoints.length;

        if (DrawFlag) {
            g.setColor(Color.cyan);
            g.fillPolygon(xPoints, yPoints, points);
            g.setColor(Color.black);
            g.drawPolygon(xPoints, yPoints, points);
            g.setColor(Color.red);
            g.fillOval(100, 175, 50, 50);
            g.fillOval(275, 175, 50, 50);
            g.setColor(Color.black);
            g.drawOval(100, 175, 50, 50);
            g.drawOval(275, 175, 50, 50);
            DrawFlag = false;
        }
        if (transFlag) {
            for (int i = 0; i < xPoints.length; i++) {
                xPoints[i] += tx;
            }
            for (int i = 0; i < yPoints.length; i++) {
                yPoints[i] += ty;
            }
            g.setColor(Color.cyan);
            g.fillPolygon(xPoints, yPoints, points);
            g.setColor(Color.black);
            g.drawPolygon(xPoints, yPoints, points);
            g.setColor(Color.red);
            g.fillOval(100 + tx, 175 + ty, 50, 50);
            g.fillOval(275 + tx, 175 + ty, 50, 50);
            g.setColor(Color.black);
            g.drawOval(100 + tx, 175 + ty, 50, 50);
            g.drawOval(275 + tx, 175 + ty, 50, 50);
            transFlag = false;
        }
    }

    private void drawXY(Graphics g) {
        Dimension d = getSize();
        int xMax = d.width;
        int yMax = d.height;

        g.drawRect(0, 0, xMax, yMax);
        for (int i = 0; i < xMax; i += 50) {
            g.drawString("" + i, i, 10);
        }

        for (int i = 0; i < yMax; i += 50) {
            g.drawString("" + i, 0, i);
        }
    }
}
