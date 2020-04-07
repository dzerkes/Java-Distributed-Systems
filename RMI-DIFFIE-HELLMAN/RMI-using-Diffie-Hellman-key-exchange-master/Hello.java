import java.rmi.Remote; 
import java.rmi.RemoteException;  
import java.util.ArrayList;

// Creating Remote interface for our application 
public interface Hello extends Remote {
   public int genkey(int g,int p,int a) throws RemoteException;
   public int power(int g,int b,int p) throws RemoteException;
   public int primality(byte[] number) throws RemoteException;
   public long fibonacci(byte[] number) throws RemoteException;
   public long genfib(int number) throws RemoteException;
   public String tolower(byte[] chararr) throws RemoteException;
   public int palindrome(byte[] chararr) throws RemoteException;
}
