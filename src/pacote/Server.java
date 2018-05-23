package pacote;



import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;


	public class Server {

		public Server() throws RemoteException {
	        try {
	           LocateRegistry.createRegistry(2999);
	           Naming.rebind("rmi://localhost:2999/demontie", new Control());
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    public static void main(String[] args) throws RemoteException {
	       new Server();
	    }
		
	}