/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicals.pr11;

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
 * @author Lab5_6
 */
public class P11Frame extends Frame implements ActionListener {

    Label lbl1, lbl2;
    TextField txtx1, txty1, txtx, txty,fx,fy;
    Button b1, b2;
    Panel p1;
    P11Canvas can = new P11Canvas();

    P11Frame() {
        super("Practical 11");
        setLayout(new BorderLayout());
        setSize(600, 600);
        lbl1 = new Label("Co-ordiate x[0..n] and y[0..n]: ");
        lbl2 = new Label("Scale : ");
        txtx1 = new TextField(3);
        txty1 = new TextField(3);
        txtx = new TextField(3);
        txty = new TextField(3);
        fx=new TextField();
        fy=new TextField();
        b1 = new Button("Draw");
        b2 = new Button("Scale");
        p1 = new Panel(new GridLayout(4, 3));
        p1.add(lbl1);
        p1.add(txtx1);
        p1.add(txty1);
        p1.add(lbl2);
        p1.add(txtx);
        p1.add(txty);
        p1.add(new Label("Enter Fix Poinst: "));
        p1.add(fx);
        p1.add(fy);
        p1.add(b1);
        p1.add(b2);

        add(can, "Center");
        add(p1, "South");
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        b1.addActionListener(this);
        b2.addActionListener(this);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String xc = txtx1.getText();
        String yc = txty1.getText();
        if (e.getSource() == b1) {
            can.Drawpoly(xc, yc);
        }
        if (e.getSource() == b2) {
            if(!fx.getText().isEmpty() && !fy.getText().isEmpty()){
              int fxv=Integer.parseInt(fx.getText());
              int fyv=Integer.parseInt(fy.getText());
              can.Scale(xc, yc, Double.parseDouble(txtx.getText()),Double.parseDouble(txty.getText()),fxv,fyv);
            }else{
                can.Scale(xc, yc, Double.parseDouble(txtx.getText()),Double.parseDouble(txty.getText()),0,0);
            }
            
        }
    }
}
