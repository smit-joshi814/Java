/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg;

import java.rmi.Remote;

/**
 *
 * @author smitj
 */
public interface SumInterface extends Remote{

    int sum(int a, int b) throws Exception;

}
