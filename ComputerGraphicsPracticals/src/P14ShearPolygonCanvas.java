//Canvas for Practical-14

import java.awt.*;
import java.awt.geom.*;
import java.util.StringTokenizer;

public class P14ShearPolygonCanvas extends Canvas {
    
    int []xPoints; 
    int []yPoints;
    int points=0;
    
    public void drawPoly(String xc, String yc){
        
        StringTokenizer xst = new StringTokenizer(xc,",");
        xPoints = new int[xst.countTokens()];
        int i=0;
        while(xst.hasMoreTokens()){
            xPoints[i++] = Integer.parseInt(xst.nextElement().toString());
        }
        
        points = i;
        
        StringTokenizer yst = new StringTokenizer(yc,",");
        yPoints = new int[yst.countTokens()];
        i=0;
        while(yst.hasMoreTokens()){
            yPoints[i++] = Integer.parseInt(yst.nextElement().toString());
        }
        repaint();
    }
    
    public void shearPoly(String xc, String yc, int sh, char axe){
        
        drawPoly(xc, yc);
        
        if(Character.toUpperCase(axe) == 'X'){
         
            for(int i=0; i<xPoints.length; i++){
                xPoints[i] += sh*(yPoints[i] - xPoints[0]);
            }
        }
        
        if(Character.toUpperCase(axe) == 'Y'){
            
            for(int i=0; i<yPoints.length; i++){
                yPoints[i] += sh*(xPoints[i] - yPoints[0]);
            }
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
    
    public void update(Graphics g){paint(g);}
    
    public void paint(Graphics g){
        
        drawXY(g);
        Graphics2D g2d = (Graphics2D) g.create();
        
        //Use of antialiasing to have nicer lines
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        
        //Draw the shapes a little bit thicker or thinner.
        BasicStroke bsThick = new BasicStroke(2.0f);
        g2d.setStroke(bsThick);
        
        if(points > 0) g2d.drawPolygon(xPoints, yPoints, points); 
    }
}
