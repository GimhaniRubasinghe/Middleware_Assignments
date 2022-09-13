import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.Registry;

public class MathServer extends UnicastRemoteObject implements MathService{

    // Adding a private variable to keep the client count
    private static Integer clientCount = 0;

    public MathServer() throws RemoteException{
        super();
    }

    // Adding a method to increment the client count. Make it thread safe.
    public int updateAndGetClients() {
        synchronized (clientCount){
            System.out.println("New client registered");
            clientCount++;
        }

        System.out.println("Client count: "+ clientCount);
        return clientCount;
    }


    public int add(int a, int b) throws RemoteException {
        System.out.println("Adding " + a + " and " + b + " in the Server");
        return a+b;
    }


    public int subtract(int a, int b) throws RemoteException {
        System.out.println("Substracting " + a + " and " + b + " in the Server");
        return a-b;
    }


    public int multiply(int a, int b) throws RemoteException {
        System.out.println("Multiplying " + a + " and " + b + " in the Server");
        return a*b;
    }

    // this method is not remotely accessible as it's not in the remote interface
    public int test(int a){
        System.out.println("this is a test");
        return 0;
    }


    public int divide(int a, int b) throws RemoteException {
        System.out.println("Dividing " + a + " and " + b + " in the Server");

        if(b != 0) {
            return a/b; //check for division with zero here!
        } else {
            System.out.println("Can not divide by Zero");
            return 0;
        }
    }




    public static void main(String[] args){
        // set the policy file as the system securuty policy
        System.setProperty("java.security.policy", "file:allowall.policy");

        try{
            MathServer svr = new MathServer();
            // Bind the remote object's stub in the registry
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("CalculatorService", svr);

            System.out.println ("Service started....");
        }
        catch(RemoteException re){
            System.err.println(re.getMessage());
        }
        catch(AlreadyBoundException abe){
            System.err.println(abe.getMessage());
        }
    }
}