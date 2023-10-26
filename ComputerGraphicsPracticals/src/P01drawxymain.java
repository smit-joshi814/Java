/*Computer Graphics P01: Write a Graphic program to draw XY AXE.*/
import java.awt.Frame;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

public class P01drawxymain extends Frame
{
    P01drawxycanvas can = new P01drawxycanvas();
    
    public P01drawxymain(){
        
        super("Practical:01 DRAW XY...");
        
     
        add(can,"Center");
               
        addWindowListener(
                new WindowAdapter(){
                    public void windowClosing(WindowEvent e){
                        System.exit(0);
                    }
                } );
           
        show();       
     }
     public static void main(String[] args)
    {
        
        new P01drawxymain();
    }
}

