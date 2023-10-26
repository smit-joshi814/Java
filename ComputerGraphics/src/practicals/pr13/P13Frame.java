/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicals.pr13;

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
public class P13Frame extends Frame implements ActionListener {

    String xco, yco;
    Label lblx, lbly;
    Button draw, refX, refY, refXY;
    TextField txtx, txty;
    Panel p;
    P13Canvas can = new P13Canvas();

    public P13Frame() {
        super("Pcactical 13");
        setVisible(true);
        setSize(600, 600);
        p = new Panel(new GridLayout(4, 4));
        lblx = new Label("Enter x[]: ");
        lbly = new Label("Enter y[]: ");
        draw = new Button("Draw");
        refX = new Button("Reflaction-X");
        refY = new Button("Reflaction-Y");
        refXY = new Button("Reflaction-XY");
        txtx = new TextField();
        txty = new TextField();
        p.add(lblx);
        p.add(txtx);
        p.add(lbly);
        p.add(txty);
        p.add(draw);
        p.add(refX);
        p.add(refY);
        p.add(refXY);

        add(p, "South");
        add(can, "Center");
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        draw.addActionListener(this);
        refX.addActionListener(this);
        refY.addActionListener(this);
        refXY.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        xco = txtx.getText();
        yco = txty.getText();
        if (e.getSource() == draw) {
            can.DrawPoly(xco, yco, 1);
        } else if (e.getSource() == refX) {
            can.DrawPoly(xco, yco, 2);
        } else if (e.getSource() == refY) {
            can.DrawPoly(xco, yco, 3);
        } else if (e.getSource() == refXY) {
            can.DrawPoly(xco, yco, 4);
        }
    }
}
