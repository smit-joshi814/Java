//Canvas for Practical-01
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
public class P01drawxycanvas extends Canvas
{
    public void drawXY(Graphics g){
        Dimension d = getSize();
        int maxX = d.width - 1;
        int maxY = d.height - 1;
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.drawRect(0,0, maxX,maxY);
        
        //Graph Value on Y-Axe
        for(int i=0; i<=maxY; i=i+50)
            g.drawString(Integer.toString(i), 0, i);
        //Graph Value on X-Axe
        for(int i=0; i<=maxX; i=i+50)
            g.drawString(Integer.toString(i), i, 10);
        g.drawLine(50, 50, 50, 50);
}
public void paint(Graphics g){
        
        drawXY(g);    
      
    }
}