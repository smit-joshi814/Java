/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicals.pr14;

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
public class P14Frame extends Frame implements ActionListener {

    Label lblXYCoord, lblTranslate;
    TextField tfx, tfy, tfsh, tfaxe;
    Button btnDraw, btnShear;
    Panel p1;
    P14Canvas can = new P14Canvas();

    public P14Frame() {
        super("Practical:14 Shear Polygon...");
        setVisible(true);
        setSize(600, 600);
        lblXYCoord = new Label("Co-Ordinate X[0..n] and Y[0..n] : ");
        lblTranslate = new Label("Shear Value [sh, axe] : ");

        tfx = new TextField(3);
        tfy = new TextField(3);
        tfsh = new TextField(3);
        tfaxe = new TextField(3);

        btnDraw = new Button("Draw Polygon");
        btnShear = new Button("Shear Polygon");

        p1 = new Panel(new GridLayout(3, 3));
        p1.add(lblXYCoord);
        p1.add(tfx);
        p1.add(tfy);
        p1.add(lblTranslate);
        p1.add(tfsh);
        p1.add(tfaxe);
        p1.add(btnDraw);
        p1.add(btnShear);

       
        setLayout(new BorderLayout());
        add(can, "Center");
        add(p1, "South");

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        btnDraw.addActionListener(this);
        btnShear.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String X = tfx.getText();
        String Y = tfy.getText();
        if (ae.getSource() == btnDraw) {
            can.drawPoly(X, Y);
        }
        if (ae.getSource() == btnShear) {
            int sh = Integer.parseInt(tfsh.getText());
            char axe = tfaxe.getText().charAt(0);
            can.shearPoly(X, Y, sh, axe);
        }
    }
}
