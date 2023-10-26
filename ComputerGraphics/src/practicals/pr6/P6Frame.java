/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicals.pr6;

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
public class P6Frame extends Frame implements ActionListener {
    
    Button fill;
    Label lblX,lblY;
    Panel p;
    TextField txtX, txtY;
    p6Canvas cn=new p6Canvas();
    
    public P6Frame() {
        super("Pr5actical 6");
        setVisible(true);
        setSize(600, 600);
        setLayout(new BorderLayout());
        fill=new Button("Fill");
        lblX=new Label("Enter xCo-ordinates:");
        lblY=new Label("Enter yCo-ordinates:");
        txtX=new TextField(3);
        txtY=new TextField(3);
        p=new Panel(new GridLayout(3, 2));
        
        p.add(lblX);
        p.add(txtX);
        p.add(lblY);
        p.add(txtY);
        p.add(fill);
        
        add("South",p);
        add("Center",cn);
        
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        fill.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String btn=e.getActionCommand();
        if(btn.equals("Fill")){
            cn.drawPoly(txtX.getText(), txtY.getText());
        }
    }
}
