
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author smitj
 */
public class MyCanvas extends Canvas implements Runnable {

    private final int xcenter = 250;
    private final int ycenter = 250;
    Thread thread = null;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("s", Locale.getDefault());
    Date currDate;
    private int lastxs = 0;
    private int lastys = 0;
    private int lastxm;
    private int lastym;
    private int lastxh;
    private int lastyh;

    public MyCanvas() {

        currDate = new Date();
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void paint(Graphics g) {
        Dimension d = getSize();
        int maxH = d.height;
        int maxW = d.width;
//
        g.drawRect(0, 0, maxW, maxH);
//
//        for (int i = 0; i < maxW - 1; i += 50) {
//            g.drawString("" + i, i, 10);
//        }
//        for (int i = 0; i < maxH - 1; i += 50) {
//            g.drawString("" + i, 0, i);
//        }

        drawStructure(g);

        //getting system time
        currDate = new Date();
        simpleDateFormat.applyPattern("s");
        int second = Integer.parseInt(simpleDateFormat.format(currDate));
        simpleDateFormat.applyPattern("m");
        int munite = Integer.parseInt(simpleDateFormat.format(currDate));
        simpleDateFormat.applyPattern("h");
        int hour = Integer.parseInt(simpleDateFormat.format(currDate));

        int xsecond = (int) (Math.cos(second * 3.14f / 30 - 3.14f / 2) * 120 + xcenter);
        int ysecond = (int) (Math.sin(second * 3.14f / 30 - 3.14f / 2) * 120 + ycenter);
        int xmunite = (int) (Math.cos(munite * 3.14f / 30 - 3.14f / 2) * 100 + xcenter);
        int ymunite = (int) (Math.sin(munite * 3.14f / 30 - 3.14f / 2) * 100 + ycenter);
        int xhour = (int) (Math.cos((hour * 30 + munite / 2) * 3.14f / 180 - 3.14f / 2) * 80 + xcenter);
        int yhour = (int) (Math.sin((hour * 30 + munite / 2) * 3.14f / 180 - 3.14f / 2) * 80 + ycenter);

//        g.setColor(Color.magenta);
//        if (xsecond != lastxs || ysecond != lastys) {
//            g.drawLine(xcenter, ycenter, lastxs, lastys);
//        }
//        if (xmunite != lastxm || ymunite != lastym) {
//            g.drawLine(xcenter, ycenter - 1, lastxm, lastym);
//            g.drawLine(xcenter - 1, ycenter, lastxm, lastym);
//        }
//        if (xhour != lastxh || yhour != lastyh) {
//            g.drawLine(xcenter, ycenter - 1, lastxh, lastyh);
//            g.drawLine(xcenter - 1, ycenter, lastxh, lastyh);
//        }
        g.setColor(Color.magenta);
        g.drawLine(xcenter, ycenter, xsecond, ysecond);
        g.setColor(Color.red);
        g.drawLine(xcenter, ycenter, xmunite, ymunite);
        // g.drawLine(xcenter, ycenter, xmunite, ymunite);
        g.setColor(Color.green);
        g.drawLine(xcenter, ycenter, xhour, yhour);
        //g.drawLine(xcenter, ycenter, xhour, yhour);

    }

    @Override
    public void run() {
        System.out.print("in run");
        while (true) {
            try {
                Thread.sleep(100);
                repaint();
            } catch (InterruptedException e) {
            }
        }
    }

    @Override
    public void update(Graphics g){
        paint(g);
    }
   

    private void drawStructure(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.drawOval(xcenter - 140, ycenter - 140, 300, 300);

        g2d.setColor(Color.BLUE);
        g2d.drawString("9", xcenter - 135, ycenter);
        g2d.drawString("3", xcenter + 145, ycenter);
        g2d.drawString("6", xcenter, ycenter + 150);
        g2d.drawString("12", xcenter, ycenter - 125);
    }
}
