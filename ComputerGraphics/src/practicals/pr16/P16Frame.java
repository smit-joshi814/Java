/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicals.pr16;

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
public class P16Frame extends Frame implements ActionListener {

    Label lblXYCoord, lblWinMin, lblWinMax;
    TextField tfx, tfy, tfxwmn, tfywmn, tfxwmx, tfywmx;
    Button btnDraw, btnClip;
    Panel p;
    P16Canvas can = new P16Canvas();

    public P16Frame() {
        super("Practical:16 Point Clipping...");

        lblXYCoord = new Label("Co-Ordinate X[0..n] and Y[0..n] : ");
        lblWinMin = new Label("Window Min-points (X,Y) : ");
        lblWinMax = new Label("Window Max-points (X,Y) : ");

        tfx = new TextField(3);
        tfy = new TextField(3);

        tfxwmn = new TextField(3);
        tfywmn = new TextField(3);
        tfxwmx = new TextField(3);
        tfywmx = new TextField(3);

        btnDraw = new Button("Draw Window");
        btnClip = new Button("Clip Points");

        p = new Panel(new GridLayout(4, 3));

        p.add(lblWinMin);
        p.add(tfxwmn);
        p.add(tfywmn);

        p.add(lblWinMax);
        p.add(tfxwmx);
        p.add(tfywmx);

        p.add(lblXYCoord);
        p.add(tfx);
        p.add(tfy);

        p.add(btnDraw);
        p.add(btnClip);

        setSize(600, 600);
        setVisible(true);
        setLayout(new BorderLayout());
        add(can, "Center");
        add(p, "South");

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        btnDraw.addActionListener(this);
        btnClip.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        String X = tfx.getText();
        String Y = tfy.getText();

        if (ae.getSource() == btnDraw) {
            double xwmn = Double.parseDouble(tfxwmn.getText());
            double ywmn = Double.parseDouble(tfywmn.getText());
            double xwmx = Double.parseDouble(tfxwmx.getText());
            double ywmx = Double.parseDouble(tfywmx.getText());

            can.drawWindow(xwmn, ywmn, xwmx, ywmx);
        }
        if (ae.getSource() == btnClip) {
            can.clipPoints(X, Y);
        }
    }

}
