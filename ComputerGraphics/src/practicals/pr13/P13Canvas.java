/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicals.pr13;

import Halper.PrintArray;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Arrays;

/**
 *
 * @author Lab5_6
 */
public class P13Canvas extends Canvas {

    double halfX, halfY;
    int xc[], yc[], points;
    int xMax, yMax;

    public P13Canvas() {
        repaint();
    }

    public void DrawPoly(String xco, String yco, int choice) {
        String[] xco1 = xco.split(",");
        String[] yco1 = yco.split(",");
        xc = Arrays.stream(xco1).mapToInt(Integer::parseInt).toArray();
        yc = Arrays.stream(yco1).mapToInt(Integer::parseInt).toArray();
        points = xc.length;
        System.out.println("Choice: " + choice);
        switch (choice) {
            case 1:
                //Original polygon
                for (int i = 0; i < xc.length; i++) {
                    xc[i] = (int) halfX + xc[i];
                }

                for (int i = 0; i < yc.length; i++) {
                    yc[i] = (int) halfY - yc[i];
                }
                PrintArray.printArray(xc, "xc");
                PrintArray.printArray(yc, "yc");
                break;
            case 2:
                //reflection on X
                for (int i = 0; i < xc.length; i++) {
                    xc[i] = (int) halfX + xc[i];
                }
                for (int i = 0; i < yc.length; i++) {
                    yc[i] = (int) halfY + yc[i];
                }
                PrintArray.printArray(xc, "xc");
                PrintArray.printArray(yc, "yc");
                break;
            case 3:
                //reflection on Y
                for (int i = 0; i < xc.length; i++) {
                    xc[i] = (int) halfX - xc[i];
                }
                for (int i = 0; i < yc.length; i++) {
                    yc[i] = (int) halfY - yc[i];
                }
                PrintArray.printArray(xc, "xc");
                PrintArray.printArray(yc, "yc");
                break;
            case 4:
                //reflection on XY
                for (int i = 0; i < xc.length; i++) {
                    xc[i] = (int) halfX - xc[i];
                }

                for (int i = 0; i < yc.length; i++) {
                    yc[i] = (int) halfY + yc[i];
                }
                PrintArray.printArray(xc, "xc");
                PrintArray.printArray(yc, "yc");
                break;
            default:
                System.err.print("Error");
        }
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        drawXY(g);
        System.out.println("\n In Paint");
        if (points > 0) {
            g.drawPolygon(xc, yc, points);
        }
    }

    @Override
    public void update(Graphics g) {
        paint(g);
    }

    private void drawXY(Graphics g) {
        Dimension d = getSize();
        xMax = d.width;
        yMax = d.height;
        halfX = xMax / 2;
        halfY = yMax / 2;

        g.drawRect(0, 0, xMax, yMax);

        g.drawLine(0, (int) halfY, xMax, (int) halfY);
        g.drawLine((int) halfX, 0, (int) halfX, yMax);
        //Print Labels
        g.drawString("(0,0)", (int) halfX + 5, (int) halfY - 5);
        g.drawString("(-X,Y)", 5, 10);
        g.drawString("(X,Y)", xMax - 25, 10);
        g.drawString("(X,-Y)", xMax - 30, yMax - 10);
        g.drawString("(-X,-Y)", 10, yMax - 10);
    }
}
