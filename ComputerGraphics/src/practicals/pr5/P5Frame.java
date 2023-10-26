/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicals.pr5;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author Lab5_6
 */
public class P5Frame extends Frame implements MouseListener {

    int xc1, yc1, xc2, yc2;
    Dimension d = null;
    Graphics g = null;

    public P5Frame() {
        super("Practical 5");
        setVisible(true);
        setSize(600, 600);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent ex) {
                System.exit(0);
            }
        });
        addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        xc1 = e.getX();
        yc1 = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        xc2 = e.getX();
        yc2 = e.getY();
        System.out.print(xc1 + "\t" + yc2);
        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void update(Graphics g) {
        paint(g);
    }

    @Override
    public void paint(Graphics g) {
        initCoordinates(d, g, false);
        //System.out.print(xc1 + "\t" + yc2);
        g.drawLine(xc1, yc1, xc2, yc2);
    }

    private void initCoordinates(Dimension d, Graphics g, boolean Grids) {
        d = getSize();
        int xAxis = d.width - 1;
        int yAxis = d.height - 1;

//        g.drawLine(0, 10, xAxis, 10);
//        g.drawLine(10, 0, 10, yAxis);
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

    public static void main(String[] args) {
        P5Frame p5Frame = new P5Frame();
    }
}
