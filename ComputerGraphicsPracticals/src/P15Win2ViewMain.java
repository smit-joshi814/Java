/*Computer Graphics P15: Write a Graphic program to translate a polygon
 * from Windows-to-Viewpoint co-ordinate transformations.
 */

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

public class P15Win2ViewMain extends Frame implements ActionListener{
    
    Label lblXYCoord, lblWinMin, lblWinMax, lblViewMin, lblViewMax;
    TextField tfx, tfy, tfxwmn, tfywmn, tfxwmx, tfywmx; 
    TextField tfxvmn, tfyvmn, tfxvmx, tfyvmx;
    Button btnDraw, btnClip;
    Panel p1;
    P15Win2ViewCanvas can = new P15Win2ViewCanvas();
    
    public P15Win2ViewMain(){
        
        super("Practical:15 Polygon Clipping [Window-to-Viewport]...");
        
        lblXYCoord = new Label("Co-Ordinate X[0..n] and Y[0..n] : ");
        lblWinMin = new Label("Window Min-points (X,Y) : ");
        lblWinMax = new Label("Window Max-points (X,Y) : ");
        lblViewMin = new Label("Viewport Min-points (X,Y) : ");
        lblViewMax = new Label("Viewport Max-points (X,Y) : ");
        
        tfx = new TextField(3);
        tfy = new TextField(3);
        
        tfxwmn = new TextField(3);
        tfywmn = new TextField(3);
        tfxwmx = new TextField(3);
        tfywmx = new TextField(3);
        
        tfxvmn = new TextField(3);
        tfyvmn = new TextField(3);
        tfxvmx = new TextField(3);
        tfyvmx = new TextField(3);
        
        btnDraw = new Button("Draw Polygon");
        btnClip = new Button("view Polygon");
        
        p1 = new Panel(new GridLayout(6,3));
        p1.add(lblXYCoord);
        p1.add(tfx);
        p1.add(tfy);
        
        p1.add(lblWinMin);
        p1.add(tfxwmn);
        p1.add(tfywmn);
        
        p1.add(lblWinMax);
        p1.add(tfxwmx);
        p1.add(tfywmx);
        
        p1.add(lblViewMin);
        p1.add(tfxvmn);
        p1.add(tfyvmn);
        
        p1.add(lblViewMax);
        p1.add(tfxvmx);
        p1.add(tfyvmx);
        
        p1.add(btnDraw);
        p1.add(btnClip);
        
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
                btnClip.addActionListener(this);
        show();       
    }
    
    public void actionPerformed(ActionEvent ae){
        
        String X = tfx.getText();
        String Y = tfy.getText();
        
        if(ae.getSource() == btnDraw){
            double xwmn = Double.parseDouble(tfxwmn.getText());
            double ywmn = Double.parseDouble(tfywmn.getText());
            double xwmx = Double.parseDouble(tfxwmx.getText());
            double ywmx = Double.parseDouble(tfywmx.getText());
            
            can.drawPoly(X, Y, xwmn, ywmn, xwmx, ywmx);
        }      
        
        if(ae.getSource() == btnClip){
            
            double xvmn = Double.parseDouble(tfxvmn.getText());
            double yvmn = Double.parseDouble(tfyvmn.getText());
            double xvmx = Double.parseDouble(tfxvmx.getText());
            double yvmx = Double.parseDouble(tfyvmx.getText());
            
            can.clipPoly(X, Y, xvmn, yvmn, xvmx, yvmx);
        }
    }
   
    public static void main(String[] args) {
        
        new P15Win2ViewMain();
    }
}
