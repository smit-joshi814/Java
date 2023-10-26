/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moduletest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/**
 *
 * @author smitj
 */
public class GetUniqueSet {

    public static void main(String[] arg) {
        HashSet<String> set = new HashSet<>();
        String variations = "High Rise,Mid Rise,Low Rise";

        String[] values = variations.split(",");

        for (String val : values) {
            if (val.length() < 50) {
                set.add(val);
            }
        }

        Iterator<String> it = set.iterator();
        String value = "";
        while (it.hasNext()) {
            value += it.next() + ",";
        }
        System.out.print(value);
    }
}
