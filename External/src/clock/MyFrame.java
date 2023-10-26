/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clock;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author smitj
 */
public class MyFrame extends Frame {
    MyClock clock=new MyClock();
    public MyFrame() {
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.setVisible(true);
        this.setSize(600,600);
        add("Center",clock);
    }
    
    public static void main(String ar[]){
        new MyFrame();
    }
}
