/*Computer Graphics P14: Write a Graphic program to shear a  
 * Polygon relative to different reference lines.
 */

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

public class P14ShearPolygonMain extends Frame implements ActionListener{
    
    Label lblXYCoord, lblTranslate;
    TextField tfx, tfy, tfsh, tfaxe;
    Button btnDraw, btnShear;
    Panel p1;
    P14ShearPolygonCanvas can = new P14ShearPolygonCanvas();
    
    public P14ShearPolygonMain(){
        
        super("Practical:14 Shear Polygon...");
        
        lblXYCoord = new Label("Co-Ordinate X[0..n] and Y[0..n] : ");
        lblTranslate = new Label("Shear Value [sh, axe] : ");
        
        tfx = new TextField(3);
        tfy = new TextField(3);
        tfsh = new TextField(3);
        tfaxe = new TextField(3);
        
        
        btnDraw = new Button("Draw Polygon");
        btnShear = new Button("Shear Polygon");
        
        p1 = new Panel(new GridLayout(3,3));
        p1.add(lblXYCoord);
        p1.add(tfx);
        p1.add(tfy);
        p1.add(lblTranslate);
        p1.add(tfsh);
        p1.add(tfaxe);
        p1.add(btnDraw);
        p1.add(btnShear);
        
        setSize(600,600);
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
                btnShear.addActionListener(this);
        show();       
    }
    
    public void actionPerformed(ActionEvent ae){
        
        String X = tfx.getText();
        String Y = tfy.getText();
        
        if(ae.getSource() == btnDraw) can.drawPoly(X, Y);      
        
        if(ae.getSource() == btnShear){
            
            int sh = Integer.parseInt(tfsh.getText());
            char axe = tfaxe.getText().charAt(0);
            can.shearPoly(X, Y, sh, axe);
        }
    }
   
    public static void main(String[] args) {
        
        new P14ShearPolygonMain();
    }
}
