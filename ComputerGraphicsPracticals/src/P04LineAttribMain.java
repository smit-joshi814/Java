/* Computer Graphics P04 : Write a graphic program to draw line using different
 * line attributes using DDA Line draw algorithm.
 */

import java.awt.*;
import java.awt.event.*;

public class P04LineAttribMain extends Frame implements ActionListener {
    
    Label lblCoord1, lblCoord2;
    TextField tfx1, tfx2, tfy1, tfy2;
    
    Button btnSolidLine, btnDotLine, btnDashLine;
    Panel p2;
    P04LineAttribCanvas can = new P04LineAttribCanvas();
    
    public P04LineAttribMain(){
        
        super("Practical:04");
        
        lblCoord1 = new Label("Co-Ordinate (x1, y1) : ");
        lblCoord2 = new Label("Co-Ordinate (x2, y2) : ");
        
        tfx1 = new TextField(3);
        tfy1 = new TextField(3);
        tfx2 = new TextField(3);
        tfy2 = new TextField(3);
        
        btnSolidLine = new Button("Solid Line");
        btnDotLine = new Button("Dotted Line");
        btnDashLine = new Button("Dashed Line");
        
        p2 = new Panel(new GridLayout(3,3));
        p2.add(lblCoord1);
        p2.add(tfx1);
        p2.add(tfy1);
        p2.add(lblCoord2);
        p2.add(tfx2);
        p2.add(tfy2);
        p2.add(btnSolidLine);
        p2.add(btnDotLine);
        p2.add(btnDashLine);
       
        
        setSize(500,500);
        setLayout(new BorderLayout());
        add(can,"Center");
        add(p2,"South");
        
        addWindowListener(
                new WindowAdapter(){
                    public void windowClosing(WindowEvent e){
                        System.exit(0);
                    }
                });
        
        btnSolidLine.addActionListener(this);
        btnDotLine.addActionListener(this);
        btnDashLine.addActionListener(this);
        
        show();     
    }

    public void actionPerformed(ActionEvent ae){
        
       String btnvalue = ae.getActionCommand();
      
        float x1 = Float.parseFloat(tfx1.getText());
        float y1 = Float.parseFloat(tfy1.getText());
        float x2 = Float.parseFloat(tfx2.getText());
        float y2 = Float.parseFloat(tfy2.getText());
        
        if(btnvalue.equals("Solid Line")) can.drawDDALine(x1, y1, x2, y2, 1);
        if(btnvalue.equals("Dotted Line")) can.drawDDALine(x1, y1, x2, y2, 2);
        if(btnvalue.equals("Dashed Line")) can.drawDDALine(x1, y1, x2, y2, 3);
    }
    
    public static void main(String[] args) {
  
        new P04LineAttribMain();
    }
}
