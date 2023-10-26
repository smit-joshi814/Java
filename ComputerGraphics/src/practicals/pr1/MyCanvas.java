/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicals.pr1;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;

/**
 *
 * @author smitj
 */
public class MyCanvas extends Canvas {

    Dimension d = null;

    @Override
    public void paint(Graphics g) {
        initCoordinates(d, g, false);
        g.drawLine(250, 250, 250, 250);
    }

    private void initCoordinates(Dimension d, Graphics g, boolean Grids) {
        d = getSize();
        int xAxis = d.width;
        int yAxis = d.height;

        g.drawLine(0, 10, xAxis, 10);
        g.drawLine(10, 0, 10, yAxis);

        for (int i = 0; i < xAxis; i += 50) {
            g.drawString("" + i, i, 10);
            if (Grids) {
                g.drawLine(i, 0, i, yAxis);
            }
        }
        for (int i = 0; i < yAxis; i += 50) {
            g.drawString("" + i, 10, i);
            if (Grids) {
                g.drawLine(0, i, xAxis, i);
            }
        }
    }
}
