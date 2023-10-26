/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package moduletests;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author smitj
 */
public class GetUniqueSet {
    public static void main(String[] arg){
        HashSet<String> set=new HashSet<>();
        set.add("hello");
        set.add("123");
        set.add("hello");
        
        System.out.print(set);
    }
}
