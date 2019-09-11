import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class Client {

    public static void getService() throws Exception
    {
        // name =  rmi:// + ServerIP +  /EngineName;
        String remoteEngine = "rmi://localhost/Processor";

        // Create local stub, lookup in the registry searching for the remote engine - the interface with the methods we want to use remotely
        IProcess processor = (IProcess) Naming.lookup(remoteEngine);

        // Send requests to the remote services the usual way, as if they are local
        try {
            // Getting data from TXT/CSV file
            ArrayList<IStudent> result = processor.fromTxtFile(new File(".../Students.txt"));

            // Getting data from Database
            //ArrayList<IStudent> result = processor.fromDatabase();

            for (IStudent s : result) {
                System.out.println(s.toString());
            }
        }
        catch (RemoteException e){
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args){
        try {
            getService();
            System.out.println("\nDone");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
