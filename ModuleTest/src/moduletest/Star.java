/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moduletest;

/**
 *
 * @author smitj
 */
public class Star {

    public static void main(String[] args) {
       double TOTAL_RECORDS=9;
       int LIMIT=6;
       double PAGES=Math.ceil(TOTAL_RECORDS/LIMIT);
       System.out.println(PAGES);
    }
}
