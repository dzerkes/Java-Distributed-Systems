import java.rmi.Naming;
import java.net.*;
import java.rmi.registry.LocateRegistry; 
import java.rmi.registry.Registry;
import java.io.*; 
import java.util.ArrayList;
import java.util.Random;
import java.util.*;
import java.nio.*;

public class Client {  
   

   public int power(int g,int b,int p)
   {
      long res=1;
      long x=Long.valueOf(g);
      while(b>0)
      {
         if(b%2==1)
         {
            res=(res%p*x%p)%p;
         }
         b/=2;
         x=(x%p*x%p)%p;
      }
      res=res%p;
      return (int) res;
   }

   public static void main(String[] args) {  
      try {  
    	  String url="rmi://localhost:5000/hello";
    	  Hello stub=(Hello)Naming.lookup(url); 
    	    
       
       
         Random rand = new Random();
         int g = rand.nextInt(10000)+100;
         int a = rand.nextInt(10000)+100;
         int p = 1000000007;
         int val = stub.genkey(g,p,a);
         int key = new Client().power(val,a,p);
         System.out.println(key);
         byte[] bytes = ByteBuffer.allocate(4).putInt(key).array();
         // Calling the remote method using the obtained object
         while(true)
         {
            System.out.print(">>");
            java.io.BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String textin = in.readLine();
            String[] splitted = textin.split(" ");
            if(splitted[0].equals("primality"))
            {
               int number = Integer.parseInt(splitted[1]);
               byte[] bytes1 = ByteBuffer.allocate(4).putInt(number).array();
               ByteBuffer bytes2 = ByteBuffer.allocate(4);
               int i=0;
               for(i=0;i<bytes1.length;i++)
               {
                  bytes2.put((byte) (bytes[i%4]^bytes1[i]));
               }
               if(stub.primality(bytes2.array())==1)
               {
                  System.out.println("Yes! a prime number");
               }
               else
               {
                  System.out.println("Not a prime number");
               }
            }

            if(splitted[0].equals("fibonacci"))
            {
               int number = Integer.parseInt(splitted[1]);
               byte[] bytes1 = ByteBuffer.allocate(4).putInt(number).array();
               ByteBuffer bytes2 = ByteBuffer.allocate(4);
               int i=0;
               for(i=0;i<bytes1.length;i++)
               {
                  bytes2.put((byte) (bytes[i%4]^bytes1[i]));
               }
               long ans= stub.fibonacci(bytes2.array());
               System.out.println(ans);
            }

            if(splitted[0].equals("tolower"))
            {
               char[] x = splitted[1].toCharArray();
               ByteBuffer bytes1 = ByteBuffer.allocate(x.length);
               for(int i=0;i<x.length;i++)
               {
                  byte t = (byte) x[i];
                  int y = (t)^bytes[i%4];
                  bytes1.put((byte) y);
               }
               System.out.println(stub.tolower(bytes1.array()));
            }

            if(splitted[0].equals("palindrome"))
            {
               char[] x = splitted[1].toCharArray();
               ByteBuffer bytes1 = ByteBuffer.allocate(x.length);
               for(int i=0;i<x.length;i++)
               {
                  byte t = (byte) x[i];
                  int y = (t)^bytes[i%4];
                  bytes1.put((byte) y);
               }
               if(stub.palindrome(bytes1.array())==1)
               {
                  System.out.println("Palindrome!");
               }
               else
               {
                  System.out.println("Not a palindrome");
               }
            }

            if(splitted[0].equals("exit"))
            {
               break;
            }
         }
 
      } catch (Exception e) {
         System.err.println("Client exception: " + e.toString()); 
         e.printStackTrace(); 
      } 
   } 
}