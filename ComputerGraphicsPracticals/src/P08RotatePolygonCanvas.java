//Canvas for Practical-08

import java.awt.*;
import java.awt.geom.*;
import java.util.StringTokenizer;

public class P08RotatePolygonCanvas extends Canvas {
    
    int []xPoints; 
    int []yPoints;
    double [][]original;
    double [][]trans = new double[3][3];
    double [][]tpose;
    double [][]mmulti;
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
    
    public void rotatePoly(String xc, String yc, int theta ){
        
        StringTokenizer xst = new StringTokenizer(xc,",");
        StringTokenizer yst = new StringTokenizer(yc,",");
        points = xst.countTokens();
        original = new double[points][3];
        tpose = new double[3][points];
        mmulti = new double[3][points];
        
        int i=0;
        
        while(xst.hasMoreTokens()){
            original[i][0] = Double.parseDouble(xst.nextElement().toString());
            original[i][1] = Double.parseDouble(yst.nextElement().toString());
            original[i][2] = 1;
            i++;
        }
        
        //Transpose Original Matrix
        for(i=0; i<3; i++){
            for(int j=0; j<points; j++){
                tpose[i][j] = original[j][i];
            }
        }
        
        for(int angle=0; angle<theta; angle++){
            
            double rad = (double)angle * (Math.PI/180);
            
            //First Row
            trans[0][0]= Math.cos(rad); trans[0][1]= -Math.sin(rad); trans[0][2]=0;
            //Second Row
            trans[1][0]=Math.sin(rad); trans[1][1]=Math.cos(rad); trans[1][2]=0;
            //Third Row
            trans[2][0]=0; trans[2][1]=0; trans[2][2]=1;
            
            
            //Matrix Multiplication
            for(i=0; i<3; i++){
                for(int j=0; j<points; j++){
                    mmulti[i][j]=0;
                    for(int k=0; k<3; k++){
                        mmulti[i][j] += trans[i][k] * tpose[k][j];                    
                    }                
                }
            }

            //Again Transpose to Original Matrix
            for(i=0; i<points; i++){
                for(int j=0; j<3; j++){
                    original[i][j] = mmulti[j][i];
                }            
                xPoints[i] = (int) original[i][0];
                yPoints[i] = (int) original[i][1];
            }
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
        g2d.setStroke(bsThick);
        
        if(points > 0)
            g2d.drawPolygon(xPoints, yPoints, points);   
    }
}
