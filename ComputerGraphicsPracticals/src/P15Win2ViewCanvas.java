//Canvas for Practical-15

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.StringTokenizer;

public class P15Win2ViewCanvas extends Canvas {
    
    int []xPoints; 
    int []yPoints;
    int [][]original;
    int [][]scale = new int[3][3];
    int [][]tpose;
    int [][]mmulti;
    int points=0;
    double Xmin, Ymin, Xmax, Ymax;
    double Xvmin, Yvmin, Xvmax, Yvmax;
    
    public void drawPoly(String xc, String yc, double Xwmn, double Ywmn, double Xwmx, double Ywmx){
        
        Xmin = Xwmn; Ymin = Ywmn;
        Xmax = Xwmx; Ymax = Ywmx;
        
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
    
    public void clipPoly(String xc, String yc, double Xvmn, double Yvmn, double Xvmx, double Yvmx){
        
        Xvmin = Xvmn; Yvmin = Yvmn;
        Xvmax = Xvmx; Yvmax = Yvmx;
        
        int sx=(int)((Xvmax-Xvmin)/(Xmax-Xmin));
	int sy=(int)((Yvmax-Yvmin)/(Ymax-Ymin));
        
        StringTokenizer xst = new StringTokenizer(xc,",");
        StringTokenizer yst = new StringTokenizer(yc,",");
        points = xst.countTokens();
        original = new int[points][3];
        tpose = new int[3][points];
        mmulti = new int[3][points];
        
        int i=0;
        
        while(xst.hasMoreTokens()){
            original[i][0] = Integer.parseInt(xst.nextElement().toString());
            original[i][1] = Integer.parseInt(yst.nextElement().toString());
            original[i][2] = 1;
            i++;
        }
        
        //Transpose Original Matrix
        for(i=0; i<3; i++){
            for(int j=0; j<points; j++){
                tpose[i][j] = original[j][i];
            }
        }
        
        //Scaling Matrix
         //First Row
        scale[0][0] = sx;
        scale[0][1] = 0;
        scale[0][2] = (int) (Xvmin - (sx * Xmin));

        //Second Row
        scale[1][0] = 0;
        scale[1][1] = sy;
        scale[1][2] = (int) (Yvmin - (sy * Ymin));

        //Third Row
        scale[2][0] = 0;
        scale[2][1] = 0;
        scale[2][2] = 1;
        
        //Matrix Multiplication
        for(i=0; i<3; i++){
            for(int j=0; j<points; j++){
                mmulti[i][j]=0;
                for(int k=0; k<3; k++){
                    mmulti[i][j] += scale[i][k] * tpose[k][j];                    
                }  
            }
        }
        
        //Again Transpose to Original Matrix
        for(i=0; i<points; i++){
            for(int j=0; j<3; j++){
                original[i][j] = mmulti[j][i];
            }            
            xPoints[i] = original[i][0];
            yPoints[i] = original[i][1];
        }
        
        Xmin = Xvmn; Ymin = Yvmn;
        Xmax = Xvmx; Ymax = Yvmx;
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
        
        //Use of antialiasing to have nicer lines
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        
        //Draw the shapes a little bit thicker or thinner.
        BasicStroke bsThick = new BasicStroke(2.0f);
        g2d.setStroke(bsThick);
        
        if(points > 0){
            
            Rectangle2D.Double Rect = new Rectangle2D.Double(Xmin, Ymin, Xmax-Xmin, Ymax-Ymin);
            g2d.draw(Rect);
            g2d.drawPolygon(xPoints, yPoints, points);    
        }
            
    }
}
