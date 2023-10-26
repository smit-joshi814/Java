/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicals.pr8;

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
public class P8Frame extends Frame implements ActionListener {

    Label lbl1, lbl2, lbl;
    TextField txtx1, txty1, txtr;
    Button b1, b2;
    Panel p1;
    P8Canvas can = new P8Canvas();

    P8Frame() {
        super("Practical 8");
        setLayout(new BorderLayout());
        setSize(600, 600);
        lbl1 = new Label("Co-ordiate x[0..n] and y[0..n]: ");
        lbl2 = new Label("Roation angle Theta: ");
        txtx1 = new TextField(3);
        txty1 = new TextField(3);
        txtr = new TextField(6);
        lbl = new Label("");
        b1 = new Button("Draw");
        b2 = new Button("Rotate");
        p1 = new Panel(new GridLayout(3, 3));
        p1.add(lbl1);
        p1.add(txtx1);
        p1.add(txty1);
        p1.add(lbl2);
        p1.add(txtr);
        p1.add(lbl);
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
            can.Rotate(xc, yc, Integer.parseInt(txtr.getText()));
        }
    }
}
