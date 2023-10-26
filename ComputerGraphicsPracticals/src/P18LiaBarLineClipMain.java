/*Computer Graphics P18: Write a Graphic program for Lian-Barsky
 * Line Clipping Algorithm.
 */

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

public class P18LiaBarLineClipMain extends Frame implements ActionListener{
    
    Label lblXYCoord, lblWinMin, lblWinMax;
    TextField tfx, tfy, tfxwmn, tfywmn, tfxwmx, tfywmx; 
    Button btnDraw, btnClip;
    Panel p1;
    P18LiaBarLineClipCanvas can = new P18LiaBarLineClipCanvas();
    
    public P18LiaBarLineClipMain(){
        
        super("Practical:18 Liang-Barsky Line Clipping...");
        
        lblXYCoord = new Label("Co-Ordinate X[0..n] and Y[0..n] : ");
        lblWinMin = new Label("Window Min-points (X,Y) : ");
        lblWinMax = new Label("Window Max-points (X,Y) : ");
        
        tfx = new TextField(3);
        tfy = new TextField(3);
        
        tfxwmn = new TextField(3);
        tfywmn = new TextField(3);
        tfxwmx = new TextField(3);
        tfywmx = new TextField(3);
        
        btnDraw = new Button("Draw Window");
        btnClip = new Button("Clip Line");
        
        p1 = new Panel(new GridLayout(4,3));
        
        p1.add(lblWinMin);
        p1.add(tfxwmn);
        p1.add(tfywmn);
        
        p1.add(lblWinMax);
        p1.add(tfxwmx);
        p1.add(tfywmx);
        
        p1.add(lblXYCoord);
        p1.add(tfx);
        p1.add(tfy);
        
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
            
            can.drawWindow(X, Y, xwmn, ywmn, xwmx, ywmx);
        }      
        
        if(ae.getSource() == btnClip){
            
            can.clipLine();
        }
    }
   
    public static void main(String[] args) {
        
        new P18LiaBarLineClipMain();
    }
}
