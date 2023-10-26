/*Computer Graphics P03: Write a Graphic program to draw Circle using Mid
 * Point Circle algorithm.
 */

import java.awt.*;
import java.awt.event.*;

public class P03MidPointCircleMain extends Frame implements ActionListener {
    
    Label lblRadius;
    TextField tfRadius;
    Button btnDraw;
    Panel p1;
    P03MidPointCircleCanvas can = new P03MidPointCircleCanvas();
    
    public P03MidPointCircleMain() {
        
        super("Practical:013 Mid Point Circle  Drawing...");
        
        lblRadius = new Label("Radius : ");
        tfRadius = new TextField(3);        
        btnDraw = new Button("Draw Circle");
        
        p1 = new Panel(new GridLayout(1, 3));
        p1.add(lblRadius);
        p1.add(tfRadius);        
        p1.add(btnDraw);
        
        setSize(500, 500);
        setLayout(new BorderLayout());
        add(can, "Center");
        add(p1, "South");
        
        addWindowListener(
                new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        System.exit(0);
                    }
                });
        
        btnDraw.addActionListener(this);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        String btnvalue = ae.getActionCommand();
        
        float radius = Float.parseFloat(tfRadius.getText());
        
        if (btnvalue.equals("Draw Circle")) {
            can.drawMidPointCircle(radius);
        }
        
    }
    
    public static void main(String[] args) {
        
        P03MidPointCircleMain p03MidPointCircleMain = new P03MidPointCircleMain();
    }
}
