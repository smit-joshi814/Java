import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

public class P05RubberLineMain extends Frame implements MouseListener{

    private int xc1, yc1, xc2, yc2;
    
    public P05RubberLineMain(){
        
        super("Practical:05 Rubber Band Line Using Mouse...");
        
        setSize(500,500);
        setLayout(new BorderLayout());
        
        addMouseListener(this);
        addWindowListener(
                new WindowAdapter(){
                    public void windowClosing(WindowEvent e){
                        System.exit(0);
                    }
                });
        show();       
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
        xc1 = e.getX(); yc1 = e.getY();
        System.out.println(xc1 + " " + yc2);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        xc2 = e.getX(); yc2 = e.getY();
        
        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
       
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
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
        
        //Definition and drawing of the two curves that define the letter.
        Line2D.Double d = new Line2D.Double (xc1,yc1,xc2,yc2);  
        
        g2d.draw(d);
    }
    
    public static void main(String[] args) {

        new P05RubberLineMain();
    }
}
