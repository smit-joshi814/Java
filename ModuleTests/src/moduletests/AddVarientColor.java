/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package moduletests;

/**
 *
 * @author smitj
 */
public class AddVarientColor {
    public static void main(String[] args){
        String colorsString="maroon,dark red,brown,red,tomato,indian red,orange red,dark orange,orange,gold,dark golden rod,golden rod,pale golden rod,dark khaki,khaki,olive,yellow,yellow green,lawn green,dark green,green,light green,cyan,deep sky blue,sky blue,navy,blue,royal blue,blue violet,indigo,medium purple,purple,violet,Magenta,deep pink,hot pink,pink,antique white,wheat,corn silk,light yellow,chocolate,burly wood,moccasin,lavender blush,light slate gray,light steel blue,lavender,alice blue,black,gray,dark gray,silver,light gray,white";
        String[] colors=colorsString.split(",");
        
        for(String color:colors){
            System.out.print(color);
        }
        
    }
}
