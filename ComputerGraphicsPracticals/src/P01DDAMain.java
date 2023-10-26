/*Computer Graphics P01: Write a Graphic program to draw line using DDA 
 * line draw algorithm.
 */

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

public class P01DDAMain extends Frame implements ActionListener{
    
    Label lblCoord1, lblCoord2;
    TextField tfx1, tfx2, tfy1, tfy2;
    Button btnDraw, btnReset;
    Panel p1;
    P01DDACanvas can = new P01DDACanvas();
    
    public P01DDAMain(){
        
        super("Practical:01 DDA Line Drawing...");
        
        lblCoord1 = new Label("Co-Ordinate (x1, y1) : ");
        lblCoord2 = new Label("Co-Ordinate (x2, y2) : ");
        
        tfx1 = new TextField(3);
        tfy1 = new TextField(3);
        tfx2 = new TextField(3);
        tfy2 = new TextField(3);
        
        btnDraw = new Button("Draw Line");
        
        p1 = new Panel(new GridLayout(3,3));
        p1.add(lblCoord1);
        p1.add(tfx1);
        p1.add(tfy1);
        p1.add(lblCoord2);
        p1.add(tfx2);
        p1.add(tfy2);
        p1.add(btnDraw);
        
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
        show();       
    }
    
    public void actionPerformed(ActionEvent ae){
        
        String btnvalue = ae.getActionCommand();
        
        float x1 = Float.parseFloat(tfx1.getText());
        float y1 = Float.parseFloat(tfy1.getText());
        float x2 = Float.parseFloat(tfx2.getText());
        float y2 = Float.parseFloat(tfy2.getText());
        
        if(btnvalue.equals("Draw Line")) can.drawDDALine(x1, y1, x2, y2);
        
    }

    
    public static void main(String[] args) {
        
        new P01DDAMain();
    }
}