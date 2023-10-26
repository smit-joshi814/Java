/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clock;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author smitj
 */
public class MyClock extends Canvas implements Runnable{

    Thread thread;
    SimpleDateFormat format = new SimpleDateFormat("s", Locale.getDefault());
    Date date;
    final int xcenter = 250;
    final int ycenter = 250;

    public MyClock() {
        repaint();
        thread=new Thread(this);
        thread.start();
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        Dimension d = getSize();
        g2d.drawRect(0, 0, d.width, d.height);

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.drawOval(xcenter - 145, ycenter - 145, 300, 300);

        g2d.drawString("9", xcenter - 140, ycenter);
        g2d.drawString("3", xcenter + 140, ycenter);
        g2d.drawString("12", xcenter, ycenter - 130);
        g2d.drawString("6", xcenter, ycenter + 150);

        date = new Date();
        format.applyPattern("s");
        int second = Integer.parseInt(format.format(date));
        format.applyPattern("m");
        int minute = Integer.parseInt(format.format(date));
        format.applyPattern("h");
        int hour = Integer.parseInt(format.format(date));

        int xsecond = (int) (Math.cos(second * 3.14f / 30 - 3.14f / 2) * 120 + xcenter);
        int ysecond = (int) (Math.sin(second * 3.14f / 30 - 3.14f / 2) * 120 + ycenter);

        g2d.setColor(Color.red);
        g2d.drawLine(xcenter, ycenter, xsecond, ysecond);

    }

    @Override
    public void run() {
       while(true){
           try {
               Thread.sleep(100);
               repaint();
           } catch (InterruptedException ex) {
               Logger.getLogger(MyClock.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
    }
}
