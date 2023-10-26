/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg;

import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author smitj
 */
public class SumImplementer extends UnicastRemoteObject implements SumInterface {

    public SumImplementer() throws Exception{
        super();
    }
        
    @Override
    public int sum(int a, int b) throws Exception {
        return a + b;
    }

}
