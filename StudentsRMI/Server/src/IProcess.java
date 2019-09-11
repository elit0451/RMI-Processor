import java.io.File;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface IProcess extends Remote {
    ArrayList<IStudent> fromTxtFile(File file) throws RemoteException;
    ArrayList<IStudent> fromDatabase() throws RemoteException;
}
