//Canvas for Practical-13
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.StringTokenizer;


public class P13PolyReflectionCanvas extends Canvas{ 
    
    int []xPoints; 
    int []yPoints;
    int points=0;
    float maxX, maxY, halfX, halfY;
    
    public void drawPoly(String xc, String yc, int choice){
        
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
        
        switch(choice){
            
            case 1: //Original Polygon
                    for(i=0; i<xPoints.length; i++)
                        xPoints[i] = (int)halfX + xPoints[i];
                    
                    for(i=0; i<yPoints.length; i++)
                        yPoints[i] = (int)halfY - yPoints[i];
                break;
                
            case 2: //X-Axe Reflection
              //  System.out.print("Hello");
                 for(i=0; i<xPoints.length; i++)
                        xPoints[i] = (int)halfX + xPoints[i];
                    
                    for(i=0; i<yPoints.length; i++)
                        yPoints[i] = (int)halfY + yPoints[i];
                break;
                
            case 3: //Y-Axe Reflection
                 for(i=0; i<xPoints.length; i++)
                        xPoints[i] = (int)halfX - xPoints[i];
                    
                    for(i=0; i<yPoints.length; i++)
                        yPoints[i] = (int)halfY - yPoints[i];
                break;
                
            case 4: //XY-Axe Reflection
                 for(i=0; i<xPoints.length; i++)
                        xPoints[i] = (int)halfX - xPoints[i];
                    
                    for(i=0; i<yPoints.length; i++)
                        yPoints[i] = (int)halfY + yPoints[i];
                break;
        }
        
        
        repaint();
    }
    
    public void drawXY(Graphics g){
    
        Dimension d = getSize();
        maxX = d.width - 1; 
        maxY = d.height - 1;
        halfX = maxX/2;
        halfY= maxY/2;
        
        Graphics2D g2d = (Graphics2D) g.create();
        Point2D.Float spoint = new Point2D.Float();
        Point2D.Float epoint = new Point2D.Float();
        
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        BasicStroke bsThick = new BasicStroke(3.0f);
        g2d.setStroke(bsThick);
        
        //Draw Vertical Line at Half of the Canvas       
        spoint.setLocation(halfX, 0);        
        epoint.setLocation(halfX, maxY);
        g2d.draw(new Line2D.Float(spoint, epoint));
        
        //Draw Horizontal Line at Half of the Canvas
        spoint.setLocation(0, halfY);
        epoint.setLocation(maxX, halfY);
        g2d.draw(new Line2D.Float(spoint, epoint));  
        
        //Print Labels
        g2d.drawString("(0,0)", halfX+5, halfY-5);
        g2d.drawString("(-X,Y)",5,10);
        g2d.drawString("(X,Y)",maxX-25,10);
        g2d.drawString("(X,-Y)",maxX-30,maxY-10);
        g2d.drawString("(-X,-Y)",10,maxY-10);
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
        System.out.println("repaint");
        if(points > 0)
            g2d.drawPolygon(xPoints, yPoints, points);    
    }
}