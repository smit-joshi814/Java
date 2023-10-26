/*Computer Graphics P11: Write a Graphic program to scale a  
Polygon using fixed point in which values of polygon edges, fixed point and  scaling points will be given by user. */

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

public class P11FixedScalePolyMain extends Frame implements ActionListener{
    
    Label lblXYCoord, lblScale, lblPoint;
    TextField tfx, tfy, tfsx, tfsy, tffx, tffy;
    Button btnDraw, btnScale;
    Panel p1;
    P11FixedScalePolyCanvas can = new P11FixedScalePolyCanvas();
    
    public P11FixedScalePolyMain(){
        
        super("Practical:11 Polygon Scaling on Fixed Point...");
        
        lblXYCoord = new Label("Co-Ordinate X[0..n] and Y[0..n] : ");
        lblScale = new Label("Scaling Points (sx, sy) : ");
        lblPoint = new Label("Fixed Point (X, Y) : ");
        
        tfx = new TextField(3);
        tfy = new TextField(3);
        tfsx = new TextField(3);
        tfsy = new TextField(3);
        tffx = new TextField(3);
        tffy = new TextField(3);
        
        btnDraw = new Button("Draw Polygon");
        btnScale = new Button("Scale Polygon");
        
        p1 = new Panel(new GridLayout(4,3));
        p1.add(lblXYCoord);
        p1.add(tfx);
        p1.add(tfy);
        p1.add(lblScale);
        p1.add(tfsx);
        p1.add(tfsy);
        p1.add(lblPoint);
        p1.add(tffx);
        p1.add(tffy);
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
            int fx = Integer.parseInt(tffx.getText());
            int fy = Integer.parseInt(tffy.getText());
            can.scalePoly(X, Y, sx, sy, fx, fy);
        }
    }
   
    public static void main(String[] args) {
        
        new P11FixedScalePolyMain();
    }
}