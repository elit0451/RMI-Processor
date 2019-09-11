import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server
{
    public static Registry registry;

    public Server() throws RemoteException { }

    public static void main(String[] args)
    {
        try
        {
            System.out.println("RMI server localhost starts");

            registry = LocateRegistry.createRegistry(1099);
            System.out.println("RMI registry created ");

            Processor remoteEngine = new Processor();

            String engineName = "Processor";

            // Register the engine by the name, which later will be given to the clients
            Naming.rebind("//localhost/" + engineName, remoteEngine);
            System.out.println("Engine " + engineName + " bound in registry");
        }
        catch (Exception e)
        {
            System.err.println("Exception:" + e);
        }
    }
}



