/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CGINTERNAL2;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Arrays;

/**
 *
 * @author smitj
 */
public class MyCanvas extends Canvas {

    int[] xPoints, yPoints;
    double[][] original, tpose, scale, multi;
    int points;

    public MyCanvas() {
        repaint();
    }

    public void drawPoly(String xc, String yc) {
        xPoints = Arrays.stream(xc.split(",")).mapToInt(Integer::parseInt).toArray();
        yPoints = Arrays.stream(yc.split(",")).mapToInt(Integer::parseInt).toArray();
        points = xPoints.length;
        repaint();
    }

    public void ActionOnObject(String xc, String yc, int arg1, int arg2) {
        xPoints = Arrays.stream(xc.split(",")).mapToInt(Integer::parseInt).toArray();
        yPoints = Arrays.stream(yc.split(",")).mapToInt(Integer::parseInt).toArray();
        points = xPoints.length;

        original = new double[points][3];
        tpose = new double[3][points];
        scale = new double[3][points];
        multi = new double[3][points];

        for (int i = 0; i < points; i++) {
            original[i][0] = xPoints[i];
            original[i][1] = yPoints[i];
            original[i][2] = 1;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < points; j++) {
                tpose[i][j] = original[j][i];
            }
        }

        double rad = arg1 * (Math.PI / 180);

        scale[0][0] = Math.cos(rad);
        scale[0][1] = -Math.sin(rad);
        scale[0][2] = 0;

        scale[1][0] = Math.sin(rad);
        scale[1][1] = Math.cos(rad);
        scale[1][2] = 0;

        scale[2][0] = 0;
        scale[2][1] = 0;
        scale[2][2] = 1;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < points; j++) {
                multi[i][j] = 0;
                for (int k = 0; k < 3; k++) {
                    multi[i][j] += scale[i][k] * tpose[k][j];
                }
            }
        }

        for (int i = 0; i < points; i++) {
            for (int j = 0; j < 3; j++) {
                original[i][j] = multi[j][i];
            }
            xPoints[i] = (int) original[i][0];
            yPoints[i] = (int) original[i][1];
        }
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        drawXY(g);
        if (points > 0) {
            g.drawPolygon(xPoints, yPoints, points);
        }
    }

    private void drawXY(Graphics g) {
        Dimension d = getSize();
        int xMax = d.width;
        int yMax = d.height;

        g.drawRect(0, 0, xMax, yMax);

        for (int i = 0; i < xMax; i += 50) {
            g.drawString("" + i, 0, i);
        }
        for (int i = 0; i < yMax; i += 50) {
            g.drawString("" + i, i, 10);
        }
    }
}
