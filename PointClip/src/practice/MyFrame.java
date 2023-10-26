/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author smitj
 */
public class MyFrame extends Frame implements MouseListener {

    int x1, y1, x2, y2;
    boolean flag = true;
    boolean show = false;
    int xx1, xy1, xx2, xy2;
    Graphics g;
    //  MyCanvas can = new MyCanvas();

    public MyFrame() {
        this.setVisible(true);
        this.setSize(600, 600);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        //   add("Center", can);
        addMouseListener(this);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (flag) {
            x1 = e.getX();
            y1 = e.getY();
        } else {
            xx1 = e.getX();
            xy1 = e.getY();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (flag) {
            x2 = e.getX();
            y2 = e.getY();
            show = true;
            flag = false;
            repaint();
        } else {
            xx2 = e.getX();
            xy2 = e.getY();
            repaint();
        }
        // can.drawWindow(x1, y1, x2, y2);

    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void paint(Graphics g) {
        if (!flag && show) {
            g.setColor(Color.red);
            g.drawRect(x1, y1, x2, y2);
            show = false;
        } else {
            if (xx1 >= x1 && xx2 <= x2 && xy1 >= y1 && xy2 <= y2) {
                g.drawLine(xx1, xy1, xx2, xy2);
            }
        }
    }

    @Override
    public void update(Graphics g) {
        paint(g);
    }

    public static void main(String[] a) {
        new MyFrame();
    }
}
