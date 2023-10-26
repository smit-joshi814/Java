//Canvas for Practical-16
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.StringTokenizer;


public class P16PointClipCanvas extends Canvas implements Runnable{ 

    int []xPoints; 
    int []yPoints;
    int pTotal=0;
    float x, y;
    boolean winFlag = false, pointFlag=false;
    double Xwmin, Ywmin, Xwmax, Ywmax;
    
    public void drawWindow(double Xwmn, double Ywmn, double Xwmx, double Ywmx){
        
        Xwmin = Xwmn; Ywmin = Ywmn;
        Xwmax = Xwmx; Ywmax = Ywmx;
        winFlag = true;
        repaint();
    }
    
    public void clipPoints(String xc, String yc){
        
        StringTokenizer xst = new StringTokenizer(xc,",");
        xPoints = new int[xst.countTokens()];
        int i=0;
        while(xst.hasMoreTokens()){
            xPoints[i++] = Integer.parseInt(xst.nextElement().toString());
        }
        
        pTotal = i;
        
        StringTokenizer yst = new StringTokenizer(yc,",");
        yPoints = new int[yst.countTokens()];
        i=0;
        while(yst.hasMoreTokens()){
            yPoints[i++] = Integer.parseInt(yst.nextElement().toString());
        }            
        new Thread(this).start();
    }
    
    public void run(){
        
        int i=0;
        while(i<pTotal){
         
           pointFlag = true;
           if((Xwmin<=xPoints[i] && xPoints[i]<=Xwmax) && (Ywmin<=yPoints[i] && yPoints[i]<=Ywmax)){
                x = xPoints[i];
                y = yPoints[i];
               // System.out.println("Hello"); 
            }
           
            try{
                Thread.sleep(100);
            }catch(InterruptedException e){};     
           
            repaint();
           
           i++;
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
        
        if(winFlag){
            
            Rectangle2D.Double Rect = new Rectangle2D.Double(Xwmin, Ywmin, Xwmax-Xwmin, Ywmax-Ywmin);
            g2d.setStroke(bsThick);
            g2d.draw(Rect);
        }
        
        if(pointFlag){
            
            Point2D.Float point = new Point2D.Float();
            point.setLocation(x, y);
            g2d.setStroke(bsThick);
            g2d.draw(new Line2D.Float(point, point));
        }
    }
}