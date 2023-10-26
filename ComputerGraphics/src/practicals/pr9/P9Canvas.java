/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicals.pr9;

import Halper.PrintArray;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Arrays;

/**
 *
 * @author Lab5_6
 */
public class P9Canvas extends Canvas {

    int xco[], yco[], points;
    int[][] original;
    double[][] scale = new double[3][3];
    int[][] tpose;
    int[][] mmulti;

    public void Drawpoly(String xc, String yc) {
        xco = Arrays.stream(xc.split(",")).mapToInt(Integer::parseInt).toArray();
        yco = Arrays.stream(yc.split(",")).mapToInt(Integer::parseInt).toArray();
        points = xco.length;
        repaint();
    }

    public void Scale(String xc, String yc, double xinc, double yinc) {
        xco = Arrays.stream(xc.split(",")).mapToInt(Integer::parseInt).toArray();
        yco = Arrays.stream(yc.split(",")).mapToInt(Integer::parseInt).toArray();
        points = xco.length;
        original = new int[points][3];
        tpose = new int[3][points];
        mmulti = new int[3][points];

        for (int i = 0; i < points; i++) {
            original[i][0] = xco[i];
            original[i][1] = yco[i];
            original[i][2] = 1;
        }
        PrintArray.printArray(original, "Origional");

        //transpose origional matrix
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < points; j++) {
                tpose[i][j] = original[j][i];
            }
        }
        PrintArray.printArray(tpose, "tpose");

        //for (int ang = 0; ang < theta; ang++) {
        

        //Rotation Matrix
        //First Row
        scale[0][0] = xinc;
        scale[0][1] = 0;
        scale[0][2] = 0;

        //Second Row
        scale[1][0] = 0;
        scale[1][1] = yinc;
        scale[1][2] = 0;

        //Third Row
        scale[2][0] = 0;
        scale[2][1] = 0;
        scale[2][2] = 1;
        // }
        PrintArray.printArray(scale, "Rotation");

        //Matrix Multiplication
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < points; j++) {
                mmulti[i][j] = 0;
                for (int k = 0; k < 3; k++) {
                    mmulti[i][j] += scale[i][k] * tpose[k][j];
                }
            }
        }
        PrintArray.printArray(mmulti, "Multiplaction");

        //Again Transpose To Origional Matrix
        for (int i = 0; i < points; i++) {
            for (int j = 0; j < 3; j++) {
                original[i][j] = mmulti[j][i];
                xco[i] = original[i][0];
                yco[i] = original[i][1];
            }
        }
        PrintArray.printArray(original, "After Multiplaction origional");
        repaint();
    }

    @Override
    public void update(Graphics g) {
        paint(g);
    }

    @Override
    public void paint(Graphics g) {
        Dimension d = null;
        initCoordinates(d, g, false);
        if (points > 0) {
            g.drawPolygon(xco, yco, points);
        }
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
}
