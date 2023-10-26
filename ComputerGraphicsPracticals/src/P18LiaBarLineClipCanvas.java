//Canvas for Practical-18
import java.awt.*;
import java.awt.geom.*;
import java.util.StringTokenizer;


public class P18LiaBarLineClipCanvas extends Canvas{ 

    int []xPoints; 
    int []yPoints;
    int pTotal=0;
    float x, y, x1, y1, x2, y2;
    float dx, dy, u1=0.0f, u2=1.0f;
    float []p = new float[4];
    float []q = new float[4];
    float []r = new float[4];
    boolean winFlag = false, lineFlag=false, mesFlag=false;
    double Xwmin, Ywmin, Xwmax, Ywmax;
    String sMessage = null;
    
    public void drawWindow(String xc, String yc, double Xwmn, double Ywmn, double Xwmx, double Ywmx){
        
        Xwmin = Xwmn; Ywmin = Ywmn;
        Xwmax = Xwmx; Ywmax = Ywmx;
        
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
        
        x1 = (float)xPoints[0];   x2 = (float)xPoints[1];
        y1 = (float)yPoints[0];   y2 = (float)yPoints[1];
        winFlag = true;
        lineFlag = true;
        mesFlag = false;
        repaint();
    }
    
    public void clipLine(){
    
        dx = x2 - x1;
        dy = y2 - y1;
        p[0] = -dx;
        p[1] = dx;
        p[2] = -dy;
        p[3] = dy;
        q[0] = x1 - (float)Xwmin;
        q[1] = (float)Xwmax - x1;
        q[2] = y1 - (float)Ywmin;
        q[3] = (float)Ywmax - y1;
        
        System.out.println(dx + " " + dy);
        for(int k = 0; k <= 3; k++){
            
            System.out.println(p[k] + " " + q[k]);
            if(p[k] == 0 && q[k] < 0){
                
                sMessage ="THE LINE IS COMPLETELY 11 outSIDE THE CLIPPING WINDOW.........";
                mesFlag = true;
                winFlag = false;
                lineFlag = false;
                break;
            }
        }
        
        for(int k = 0; k <= 3; k++){
        
            if(p[k] < 0){
        
                r[k] = q[k] / p[k];
                u1 = Math.max(u1, r[k]);
            }
            if(p[k] > 0){
        
                r[k] = q[k] / p[k];
                u2 = Math.min(u2, r[k]);
            }
            System.out.println(r[k] + " " + u1 + " " + u2);
        }
        
        if(u1 > u2){
            
            sMessage = "THE LINE IS COMPLETELY 12 OUTSIDE THE CLIPPING WINDOW.........";
            mesFlag = true;
            winFlag = false;
            lineFlag = false;
        }
        
        if(u1 == 0.0 && u2 == 1.0){
        
            sMessage = "THE LINE IS COMPLETELY 11 INSIDE THE CLIPPING WINDOW.........";
            mesFlag = true;
            winFlag = false;
            lineFlag = false;
        }
        
        if(u1 < u2 && (u1 >= 0.0 || u2 >= 1.0)){
        
            x2 = x1 + (dx * u2);
            y2 = y1 + (dy * u2);
            x1 = x1 + (dx * u1);
            y1 = y1 + (dy * u1);
            winFlag=true;
            lineFlag=true;
            mesFlag = false;
        }
        repaint();        
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
    
    //public void update(Graphics g){paint(g);}
    
    public void paint(Graphics g){
        
        drawXY(g);
        Graphics2D g2d = (Graphics2D) g.create();
        Point2D.Float spoint = new Point2D.Float();
        Point2D.Float epoint = new Point2D.Float();
        
        //Use of antialiasing to have nicer lines
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        
        //Draw the shapes a little bit thicker or thinner.
        BasicStroke bsThick = new BasicStroke(2.0f);
        
        if(mesFlag){
            g2d.setStroke(bsThick);
            g2d.drawString(sMessage, 50, 400);
        }
        
        if(winFlag){
            
            Rectangle2D.Double Rect = new Rectangle2D.Double(Xwmin, Ywmin, Xwmax-Xwmin, Ywmax-Ywmin);
            g2d.setStroke(bsThick);
            g2d.draw(Rect);
            winFlag = false;
        }
        
        if(lineFlag){
            
            spoint.setLocation(x1, y1);        
            epoint.setLocation(x2, y2);
            g2d.draw(new Line2D.Float(spoint, epoint));
            lineFlag = false;
        }
    }
}