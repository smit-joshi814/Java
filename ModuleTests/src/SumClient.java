
import java.rmi.Naming; 

public class SumClient{
    public static void main(String[] args){
        try{
        SumInterface si=(SumInterface)Naming.lookup("/sum");
        int sum=si.sum(10, 20);
        System.out.print("The Summation is "+sum);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
