
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class SumServer extends UnicastRemoteObject implements SumInterface {

    public SumServer() throws RemoteException {
        super();
    }                         

    @Override
    public int sum(int a, int b) throws RemoteException {
        return (a + b);
    }
}
