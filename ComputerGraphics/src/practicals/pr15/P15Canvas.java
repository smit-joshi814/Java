/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicals.pr15;

import Halper.PrintArray;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.Arrays;

/**
 *
 * @author smitj
 */
public class P15Canvas extends Canvas {

    int[] xPoints;
    int[] yPoints;
    int[][] original;
    int[][] scale = new int[3][3];
    int[][] tpose;
    int[][] mmulti;
    int points = 0;
    double Xmin, Ymin, Xmax, Ymax;
    double Xvmin, Yvmin, Xvmax, Yvmax;

    public void drawPoly(String xc, String yc, double Xwmn, double Ywmn, double Xwmx, double Ywmx) {

        Xmin = Xwmn;
        Ymin = Ywmn;
        Xmax = Xwmx;
        Ymax = Ywmx;
        xPoints = Arrays.stream(xc.split(",")).mapToInt(Integer::parseInt).toArray();
        yPoints = Arrays.stream(yc.split(",")).mapToInt(Integer::parseInt).toArray();
        points = xPoints.length;
        repaint();
    }

    public void clipPoly(String xc, String yc, double Xvmn, double Yvmn, double Xvmx, double Yvmx) {

        Xvmin = Xvmn;
        Yvmin = Yvmn;
        Xvmax = Xvmx;
        Yvmax = Yvmx;

        int sx = (int) ((Xvmax - Xvmin) / (Xmax - Xmin));
        int sy = (int) ((Yvmax - Yvmin) / (Ymax - Ymin));

        original = new int[points][3];
        tpose = new int[3][points];
        mmulti = new int[3][points];

        xPoints = Arrays.stream(xc.split(",")).mapToInt(Integer::parseInt).toArray();
        yPoints = Arrays.stream(yc.split(",")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < xPoints.length; i++) {
            original[i][0] = xPoints[i];
            original[i][1] = yPoints[i];
            original[i][2] = 1;
        }
        PrintArray.printArray(original, "Original");

        //Transpose Original Matrix
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < points; j++) {
                tpose[i][j] = original[j][i];
            }
        }
        PrintArray.printArray(tpose, "Transpose");
        //Scaling Matrix
        //First Row
        scale[0][0] = sx;
        scale[0][1] = 0;
        scale[0][2] = (int) (Xvmin - (sx * Xmin));

        //Second Row
        scale[1][0] = 0;
        scale[1][1] = sy;
        scale[1][2] = (int) (Yvmin - (sy * Ymin));

        //Third Row
        scale[2][0] = 0;
        scale[2][1] = 0;
        scale[2][2] = 1;

        PrintArray.printArray(scale, "Scale");

        //Matrix Multiplication
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < points; j++) {
                mmulti[i][j] = 0;
                for (int k = 0; k < 3; k++) {
                    mmulti[i][j] += scale[i][k] * tpose[k][j];
                }
            }
        }
        PrintArray.printArray(mmulti, "Multiplication");

        //Again Transpose to Original Matrix
        for (int i = 0; i < points; i++) {
            for (int j = 0; j < 3; j++) {
                original[i][j] = mmulti[j][i];
            }
            xPoints[i] = original[i][0];
            yPoints[i] = original[i][1];
        }

        PrintArray.printArray(original,"Original");
        
        Xmin = Xvmn;
        Ymin = Yvmn;
        Xmax = Xvmx;
        Ymax = Yvmx;
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

    //public void update(Graphics g){paint(g);}
    @Override
    public void paint(Graphics g) {
        drawXY(g);
        Graphics2D g2d = (Graphics2D) g.create();
        if (points > 0) {
            Rectangle2D.Double Rect = new Rectangle2D.Double(Xmin, Ymin, Xmax - Xmin, Ymax - Ymin);
            g2d.draw(Rect);
            g.drawPolygon(xPoints, yPoints, points);
        }
    }
}
