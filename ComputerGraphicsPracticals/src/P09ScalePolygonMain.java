/*Computer Graphics P09: Write a Graphic program to scale a  
  Polygon in which values of polygon edges and scaling points
  will be given by user. */

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

public class P09ScalePolygonMain extends Frame implements ActionListener{
    
    Label lblXYCoord, lblScale;
    TextField tfx, tfy, tfsx, tfsy;
    Button btnDraw, btnScale;
    Panel p1;
    P09ScalePolygonCanvas can = new P09ScalePolygonCanvas();
    
    public P09ScalePolygonMain(){
        
        super("Practical:09 Polygon Scaling...");
        
        lblXYCoord = new Label("Co-Ordinate X[0..n] and Y[0..n] : ");
        lblScale = new Label("Scaling Points (sx, sy) : ");
        
        tfx = new TextField(3);
        tfy = new TextField(3);
        tfsx = new TextField(3);
        tfsy = new TextField(3);
        
        
        btnDraw = new Button("Draw Polygon");
        btnScale = new Button("Scale Polygon");
        
        p1 = new Panel(new GridLayout(3,3));
        p1.add(lblXYCoord);
        p1.add(tfx);
        p1.add(tfy);
        p1.add(lblScale);
        p1.add(tfsx);
        p1.add(tfsy);
        p1.add(btnDraw);
        p1.add(btnScale);
        
        setSize(500,500);
        setLayout(new BorderLayout());
        add(can,"Center");
        add(p1,"South");
        
        addWindowListener(
                new WindowAdapter(){
                    public void windowClosing(WindowEvent e){
                        System.exit(0);
                    }
                });
                btnDraw.addActionListener(this);
                btnScale.addActionListener(this);
        show();       
    }
    
    public void actionPerformed(ActionEvent ae){
        
        String X = tfx.getText();
        String Y = tfy.getText();
        
        if(ae.getSource() == btnDraw) can.drawPoly(X, Y);      
        
        if(ae.getSource() == btnScale){
            int sx = Integer.parseInt(tfsx.getText());
            int sy = Integer.parseInt(tfsy.getText());
            can.scalePoly(X, Y, sx, sy);
        }
    }
   
    public static void main(String[] args) {
        
        new P09ScalePolygonMain();
    }
}
