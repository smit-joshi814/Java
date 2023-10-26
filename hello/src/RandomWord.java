
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author smitj
 */
public class RandomWord {

    public static void main(String[] args) {
          String champion = null;
        float i = 1.0F;
        float p;

    while (!StdIn.isEmpty()){
        p=1/i;
        if (StdRandom.bernoulli(p)){
            champion=StdIn.readString();
        }
        i= (float) (i+1.0);
    }
    StdOut.println(champion);
    }

}
