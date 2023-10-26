import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

public class P06ScanLineFillMain extends Frame{

    
    private double x, y, Xmin, Xmax, Ymin, Ymax;
    
    public P06ScanLineFillMain(){
        
        super("Practical:06 Scan-Line Fill Polygon...");
        
      
        
        setSize(500,500);
        setLayout(new BorderLayout());
      
        
        addWindowListener(
                new WindowAdapter(){
                    public void windowClosing(WindowEvent e){
                        System.exit(0);
                    }
                });
        
        show();
       
        
    }
    
    public void drawXY(Graphics g){
    
        Dimension d = getSize();
        int maxX = d.width - 1;
        int maxY = d.height - 1;
        Graphics2D g2d = (Graphics2D) g.create();
        
       
        g2d.drawRect(0, 0, maxX, maxY);//Canvas Border-Size Rectangle
        
        //Graph Value on Y-Axe
        for(int i=0; i<=maxY; i=i+50)
            g.drawString(Integer.toString(i), 10, i);
        
        //Graph Value on X-Axe
        for(int i=0; i<=maxX; i=i+50)
            g.drawString(Integer.toString(i), i, 40);
    }
       
    public void update(Graphics g){paint(g);}
    
    public void paint(Graphics g){
    
        drawXY(g);
        
        Graphics2D g2d = (Graphics2D) g;

        //Use of antialiasing to have nicer lines.
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);

        //The lines should have a thickness of 3.0 instead of 1.0.
        BasicStroke bs = new BasicStroke(3.0f);
        g2d.setStroke(bs);
        
        Rectangle2D.Double rect = new Rectangle2D.Double(100, 100, 200, 200);
       g2d.draw(rect);
        Xmin = rect.getMinX();
        Xmax = rect.getMaxX();
        Ymin = rect.getMinY();
        Ymax = rect.getMaxY();
        
        for(int i = (int)Ymin+3; i <= Ymax-3;i++){
            
            for(int j = (int)Xmin+3; j <= Xmax-3; j++){
                
               x = (double)j;
                y = (double)i; 
                Point2D.Double point = new Point2D.Double();
               point.setLocation(x, y);
                g2d.setColor(Color.RED);
                try{
                    Thread.sleep(1);
                }catch(Exception e){}
                g2d.draw(new Line2D.Double(point, point));
          }
        }
    }
    
    public static void main(String[] args) {

        new P06ScanLineFillMain();
    }
}
