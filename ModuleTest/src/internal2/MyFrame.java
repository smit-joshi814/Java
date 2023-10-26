/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internal2;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
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
public class MyFrame extends Frame implements ActionListener {

    Button b1, b2;
    Panel p;
    MyCanvas can = new MyCanvas();
    TextField tx,ty;
    Label lbl;
    MyFrame() {
        setVisible(true);
        setSize(600, 600);
        setLayout(new BorderLayout());
        tx=new TextField();
        ty=new TextField();
        lbl=new Label("Enter TX & TY :");
        b1 = new Button("Draw");
        b2 = new Button("Transform");
        p = new Panel(new GridLayout(2, 3));
        p.add(lbl);
        p.add(tx);
        p.add(ty);
        p.add(b1);
        p.add(b2);

        add("South", p);
        add("Center", can);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        b1.addActionListener(this);
        b2.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            can.drawPoly();
        } else if (e.getSource() == b2) {
            int Tx=Integer.parseInt(tx.getText());
            int Ty=Integer.parseInt(ty.getText());
            can.transformPoly(Tx,Ty);
        }
    }
}
