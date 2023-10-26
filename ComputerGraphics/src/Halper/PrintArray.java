/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Halper;

/**
 *
 * @author Lab5_6
 */
public class PrintArray {

    public static void printArray(double arr[][], String name) {
        System.out.print("\n" + name + "\n");
        for (double x[] : arr) {
            for (double i : x) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }
    }

    public static void printArray(int arr[][], String name) {
        System.out.print("\n" + name + "\n");
        for (int x[] : arr) {
            for (int i : x) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }
    }

    public static void printArray(int arr[], String name) {
        System.out.print("\n" + name + "\n");
        for (int i : arr) {
            System.out.print(i + "\t");
        }
    }
}
