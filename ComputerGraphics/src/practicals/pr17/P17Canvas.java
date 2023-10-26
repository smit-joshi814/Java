package practicals.pr17;

//Canvas for Practical-17
import java.awt.*;
import java.awt.geom.*;
import java.util.Arrays;

public class P17Canvas extends Canvas {

    int[] xPoints, yPoints;
    int pTotal = 0;
    float x, y, x1, y1, x2, y2;
    boolean winFlag = false, lineFlag = false;
    double Xwmin, Ywmin, Xwmax, Ywmax;
    char code, code1, code2, outcode;
    final char LEFT = 0x1;
    final char RIGHT = 0x2;
    final char BOTTOM = 0x4;
    final char TOP = 0x8;

    private char calCode(float x, float y) {

        code = 0x00;

        if (x < Xwmin) {
            code = (char) (code | LEFT);
        }
        if (x > Xwmax) {
            code = (char) (code | RIGHT);
        }
        if (y < Ywmin) {
            code = (char) (code | BOTTOM);
        }
        if (y > Ywmax) {
            code = (char) (code | TOP);
        }

        return code;
    }

    public void drawWindow(String xc, String yc, double Xwmn, double Ywmn, double Xwmx, double Ywmx) {

        Xwmin = Xwmn;
        Ywmin = Ywmn;
        Xwmax = Xwmx;
        Ywmax = Ywmx;

        xPoints = Arrays.stream(xc.split(",")).mapToInt(Integer::parseInt).toArray();
        yPoints = Arrays.stream(yc.split(",")).mapToInt(Integer::parseInt).toArray();
        pTotal = xPoints.length;

        x1 = (float) xPoints[0];
        x2 = (float) xPoints[1];
        y1 = (float) yPoints[0];
        y2 = (float) yPoints[1];
        winFlag = true;
        lineFlag = true;
        repaint();
    }

    public void clipLine() {

        int accept = 0, done = 0;

        code1 = calCode(x1, y1);
        code2 = calCode(x2, y2);

        do {
            if (code1 == 0 && code2 == 0)//line is completely inside
            {
                accept = 1;
                done = 1;
                break;
            } else if ((code1 & code2) > 0) //true if line complete outside
            {
                done = 1;
            } else //check for intersections
            {
                if (code1 != 0) {
                    outcode = code1;
                } else {
                    outcode = code2;
                }

                if ((outcode & LEFT) > 0) {
                    x = (float) Xwmin;

                    y = y1 + (y2 - y1) * (x - x1) / (x2 - x1);
                } else if ((outcode & RIGHT) > 0) {
                    x = (float) Xwmax;

                    y = y1 + (y2 - y1) * (x - x1) / (x2 - x1);
                } else if ((outcode & BOTTOM) > 0) {
                    y = (float) Ywmin;

                    x = x1 + (x2 - x1) * (y - y1) / (y2 - y1);
                } else {
                    y = (float) Ywmax;

                    x = x1 + (x2 - x1) * (y - y1) / (y2 - y1);
                }
            }
            if (outcode == code1) {
                x1 = x;
                y1 = y;
                code1 = calCode(x1, y1);
            } else {
                x2 = x;
                y2 = y;
                code2 = calCode(x2, y2);
            }
        } while (done == 0);

        if (accept == 1) {
            winFlag = true;
            lineFlag = true;
        } else {
            winFlag = true;
        }
        repaint();
    }

    public void drawXY(Graphics g) {

        Dimension d = getSize();
        int maxX = d.width - 1;
        int maxY = d.height - 1;
        g.drawRect(0, 0, maxX, maxY);//Canvas Border-Size Rectangle

        //Graph Value on Y-Axe
        for (int i = 0; i <= maxY; i = i + 50) {
            g.drawString("" + i, 0, i);
        }

        //Graph Value on X-Axe
        for (int i = 0; i <= maxX; i = i + 50) {
            g.drawString("" + i, i, 10);
        }
    }

    //public void update(Graphics g){paint(g);}
    @Override
    public void paint(Graphics g) {

        drawXY(g);
        Graphics2D g2d = (Graphics2D) g.create();
        Point2D.Float spoint = new Point2D.Float();
        Point2D.Float epoint = new Point2D.Float();

        if (winFlag) {
            Rectangle2D.Double Rect = new Rectangle2D.Double(Xwmin, Ywmin, Xwmax - Xwmin, Ywmax - Ywmin);
            g2d.draw(Rect);
            winFlag = false;
        }
        if (lineFlag) {
            spoint.setLocation(x1, y1);
            epoint.setLocation(x2, y2);
            g2d.draw(new Line2D.Float(spoint, epoint));
            lineFlag = false;
        }
    }
}