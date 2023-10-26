
import java.rmi.Naming;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author smitj
 */
public class SumRegister{

    public static void main(String[] args) {
        try{
        SumServer ss=new SumServer();
        Naming.rebind("/sum", ss);
        System.out.print("Registered SuccessFully"+ss);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
