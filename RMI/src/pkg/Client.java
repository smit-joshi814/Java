/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg;

import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.util.Scanner;

/**
 *
 * @author smitj
 */
public class Client {

    public static void main(String[] arg) throws Exception {
        SumInterface obj = (SumInterface) Naming.lookup("SUM");
        Scanner s = new Scanner(System.in);
        System.out.print("Enter A: ");
        int a = s.nextInt();
        System.out.print("\nEnter B: ");
        int b = s.nextInt();

        int sum = obj.sum(a, b);
        System.out.println("Sum Is " + sum);
    }
}
