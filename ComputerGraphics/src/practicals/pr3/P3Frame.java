/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicals.pr3;

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
public class P3Frame extends Frame implements ActionListener {
    
    Button draw;
    Label l1;
    TextField txtradious;
    Panel p;
    P3Canvas can = new P3Canvas();
    
    public P3Frame() {
        super("Practical3");
        setVisible(true);
        setSize(600, 600);
        setLayout(new BorderLayout());
        draw = new Button("draw");
        l1 = new Label("Enter radious");
        txtradious = new TextField(3);
        p = new Panel(new GridLayout(1, 3));
        
        p.add(l1);
        p.add(txtradious);
        p.add(draw);
        
        add(p, "South");
        add(can, "Center");
        
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent ex) {
                System.exit(0);
            }
        });
        
        draw.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String btn = e.getActionCommand();
        float radious = Float.parseFloat(txtradious.getText());
        if (btn.equals("draw")) {
            can.DrawCiorcle(radious);
        }
    }
}
