//Canvas for Practical-04
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;


public class P04LineAttribCanvas extends Canvas implements Runnable{ 
    float x,y,x1,y1,x2,y2,dx,dy,length;
    int flag=4;
    public void drawDDALine(float xP, float yP, float xQ, float yQ, int flg){
        x1 = xP; y1 = yP;
        x2 = xQ; y2 = yQ;
        flag = flg;
        new Thread(this).start();
    }
    
    public void run(){
        
        switch(flag){
            case 1:
                solidLine();
                break;
            case 2:
                dottedLine();
                break;
            case 3:
                dashedLine();
                break;
        }
    }
    
    public void solidLine(){
        
        dx = Math.abs(x2 - x1);
        dy = Math.abs(y2 - y1);
        
        length = (dx >= dy)? dx : dy;
        
        dx = (x2 - x1)/length;
        dy = (y2 - y1)/length;
        
        x = x1;
        y = y1;
        
        int i=1;
        while(i<=length){
         
            x = x + dx;
            y = y + dy;
            i++;
            try{
                Thread.sleep(100);
            }catch(InterruptedException e){};
            
            repaint();
        }
    }
    
    public void dottedLine(){
        
        dx = Math.abs(x2 - x1);
        dy = Math.abs(y2 - y1);
        
        length = (dx >= dy)? dx : dy;
        
        dx = (x2 - x1)/length;
        dy = (y2 - y1)/length;
        
        x = x1;
        y = y1;
        
        int i=1;
        while(i<=length){
         
            x = x + dx;
            y = y + dy;
            i++;
            try{
                Thread.sleep(100);
            }catch(InterruptedException e){};
            
            if(i%2 == 0)
                repaint();
        }       
    }
    
    public void dashedLine(){
        
        dx = Math.abs(x2 - x1);
        dy = Math.abs(y2 - y1);
        
        length = (dx >= dy)? dx : dy;
        
        dx = (x2 - x1)/length;
        dy = (y2 - y1)/length;
        
        x = x1;
        y = y1;
        
        int i=1;
        while(i<=length){
         
            x = x + dx;
            y = y + dy;
            i++;
            try{
                Thread.sleep(100);
            }catch(InterruptedException e){};
            
            if(i%10 != 0)
                repaint();
        }
    }
  
    public void drawXY(Graphics g){
        
        Dimension d = getSize();
        int maxX = d.width - 1;
        int maxY = d.height - 1;
        Graphics2D g2d = (Graphics2D) g.create();
       
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        BasicStroke bsThick = new BasicStroke(3.0f);
        g2d.setStroke(bsThick);
        g2d.drawRect(0, 0, maxX, maxY);//Canvas Border-Size Rectangle
        
        //Graph Value on Y-Axe
        for(int i=0; i<=maxY; i=i+50)
            g.drawString(Integer.toString(i), 0, i);
        
        //Graph Value on X-Axe
        for(int i=0; i<=maxX; i=i+50)
            g.drawString(Integer.toString(i), i, 10);
    }
    
    public void update(Graphics g){paint(g);}
    
    public void paint(Graphics g){
        
           drawXY(g);
           Graphics2D g2d = (Graphics2D) g.create();

            //Use of antialiasing to have nicer lines
                      g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);

            //Draw the shapes a little bit thicker or thinner.
            BasicStroke bsThick = new BasicStroke(2.0f);

            Point2D.Float point = new Point2D.Float();

            point.setLocation(x, y);
            g2d.setStroke(bsThick);
            g2d.draw(new Line2D.Float(point, point));
        
    }
}