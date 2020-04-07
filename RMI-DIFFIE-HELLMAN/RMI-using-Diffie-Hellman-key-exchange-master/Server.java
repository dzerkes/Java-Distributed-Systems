import java.rmi.*;

import java.net.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;



public class Server { 
   public static void main(String args[]) { 

      
      try
      {
          Registry reg = LocateRegistry.createRegistry(5000);
          reg.bind("hello", new ImplExample());
      }
      catch(Exception ex)
      {
          System.out.println ("server failed with error: " + ex);
      }
   } 
}