import java.awt.*;
import java.awt.event.*;

public class P13PolyReflectionMain extends Frame implements ActionListener{

    Label lblXYCoord;
    TextField tfx, tfy;
    Button btnDraw, btnDrawX, btnDrawY, btnDrawXY;
    Panel p1;
    
    P13PolyReflectionCanvas can = new P13PolyReflectionCanvas();
    
    public P13PolyReflectionMain(){
        
        super("Practical:13 Polygon Reflaction...");
        
        lblXYCoord = new Label("Co-Ordinate X[0..n] and Y[0..n] : ");
        
        tfx = new TextField(3);
        tfy = new TextField(3);       
        
        btnDraw = new Button("Draw Polygon");
        btnDrawX = new Button("X-Axe Draw");
        btnDrawY = new Button("Y-Axe Draw");
        btnDrawXY = new Button("XY-Axe Draw");
        
        p1 = new Panel(new GridLayout(3,3));
        p1.add(lblXYCoord);
        p1.add(tfx);
        p1.add(tfy);
        p1.add(btnDraw);
        p1.add(new Label());
        p1.add(new Label());
        p1.add(btnDrawX);
        p1.add(btnDrawY);
        p1.add(btnDrawXY);
        
        setSize(600,600);
        setLayout(new BorderLayout());
        add(can,"Center");
        add(p1,"South");
        
        btnDraw.addActionListener(this);
        btnDrawX.addActionListener(this);
        btnDrawY.addActionListener(this);
        btnDrawXY.addActionListener(this);
        
        addWindowListener(
                new WindowAdapter(){
                    public void windowClosing(WindowEvent e){
                        System.exit(0);
                    }
                });
        
        show();       
    }
    
    public void actionPerformed(ActionEvent ae){
        
        String X = tfx.getText();
        String Y = tfy.getText();
        String action = ae.getActionCommand();
        if(action.equals("Draw Polygon")) can.drawPoly(X, Y, 1);
        if(action.equals("X-Axe Draw")) can.drawPoly(X, Y, 2);
        if(action.equals("Y-Axe Draw")) can.drawPoly(X, Y, 3);
        if(action.equals("XY-Axe Draw")) can.drawPoly(X, Y, 4);       
    } 
    
    public static void main(String[] args) {
        
        new P13PolyReflectionMain();
    }
}
