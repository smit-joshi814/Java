/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pkg;

import java.rmi.Naming;

/**
 *
 * @author smitj
 */
public class Server {
    public static void main(String args[]) throws Exception{
        SumImplementer obj=new SumImplementer();
        Naming.rebind("SUM", obj);
        System.out.println("Server Started");
    }
}
