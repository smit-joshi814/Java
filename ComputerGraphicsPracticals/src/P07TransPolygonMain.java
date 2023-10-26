/*Computer Graphics P07: Write a Graphic program to translate a  
 * Polygon in which values of polygon edges and translation points
 * will be given by user.
 */

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

public class P07TransPolygonMain extends Frame implements ActionListener{
    
    Label lblXYCoord, lblTranslate;
    TextField tfx, tfy, tftx, tfty;
    Button btnDraw, btnTranslate;
    Panel p1;
    P07TransPolygonCanvas can = new P07TransPolygonCanvas();
    
    public P07TransPolygonMain(){
        
        super("Practical:07 Polygon Translation...");
        
        lblXYCoord = new Label("Co-Ordinate X[0..n] and Y[0..n] : ");
        lblTranslate = new Label("Translation Points (tx, ty) : ");
        
        tfx = new TextField(3);
        tfy = new TextField(3);
        tftx = new TextField(3);
        tfty = new TextField(3);
        
        
        btnDraw = new Button("Draw Polygon");
        btnTranslate = new Button("Translate Polygon");
        
        p1 = new Panel(new GridLayout(3,3));
        p1.add(lblXYCoord);
        p1.add(tfx);
        p1.add(tfy);
        p1.add(lblTranslate);
        p1.add(tftx);
        p1.add(tfty);
        p1.add(btnDraw);
        p1.add(btnTranslate);
        
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
                btnTranslate.addActionListener(this);
        show();       
    }
    
    public void actionPerformed(ActionEvent ae){
        
        String X = tfx.getText();
        String Y = tfy.getText();
        
        if(ae.getSource() == btnDraw) can.drawPoly(X, Y);      
        
        if(ae.getSource() == btnTranslate){
            int tx = Integer.parseInt(tftx.getText());
            int ty = Integer.parseInt(tfty.getText());
            can.translatePoly(X, Y, tx, ty);
        }
    }
   
    public static void main(String[] args) {
        
        new P07TransPolygonMain();
    }
}
