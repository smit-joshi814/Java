/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CGINTERNAL2;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author smitj
 */
public class Myframe extends Frame implements ActionListener {

    TextField tx1, tx2, arg1, arg2;
    Panel p;
    Button b1, b2;
    MyCanvas can = new MyCanvas();

    public Myframe() {
        super("EXAM");
        setVisible(true);
        setSize(600, 600);
        setLayout(new BorderLayout());
        tx1 = new TextField();
        tx2 = new TextField();
        arg1 = new TextField();
        arg2 = new TextField();
        b1 = new Button("Draw");
        b2 = new Button("scale");
        p = new Panel(new GridLayout(3, 2));
        p.add(tx1);
        p.add(tx2);
        p.add(arg1);
        p.add(arg2);
        p.add(b1);
        p.add(b2);
        add("South", p);
        add("Center", can);
        b1.addActionListener(this);
        b2.addActionListener(this);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
           String xc=tx1.getText();
           String yc=tx2.getText();
           can.drawPoly(xc, yc);
        }
        if(e.getSource()==b2){
             String xc=tx1.getText();
           String yc=tx2.getText();
           int sx=Integer.parseInt(arg1.getText());
           int sy=Integer.parseInt(arg2.getText());
           can.ActionOnObject(xc, yc, sx, sy);  
        }
    }
}
