/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 *
 * @author smitj
 */
public class MyCanvas extends Canvas {

    int x1, x2, y1, y2;

    public void drawWindow(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        System.out.println(x1);
        System.out.println(y1);
        System.out.println(x2);
        System.out.println(y2);
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.drawRect(x1, y1, x2, y2);
    }
}
