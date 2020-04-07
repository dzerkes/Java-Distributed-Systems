import java.io.PrintWriter;

import java.net.MalformedURLException;
import java.rmi.*;  
import java.rmi.server.*;
import java.util.*;
import javafx.util.Pair;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.nio.*;

public class ImplExample extends UnicastRemoteObject implements Hello
{

	protected ImplExample() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public int key = 0;
	public long[] arr = new long[100000];

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

	public int genkey(int g,int p,int a)
	{
		Random rand = new Random();
		int b = rand.nextInt(10000)+100;
		int val = power(g,b,p);
		key = power(val,a,p);
		System.out.println(key);
		return val;
	}

	public int primality(byte[] number)
	{
		byte[] bytes = ByteBuffer.allocate(4).putInt(key).array();
		int i=0;
		int value=0;
		for(byte b: number)
		{
			int shift = (4 - 1 - i) * 8;
        	value += ((b^bytes[i%4]) & 0x000000FF) << shift;
			i++;
		}
		System.out.println(i);
		for(i=2;i<=Math.sqrt(value);i++)
		{
			if(value%i==0)
			{
				return 0;
			}
		}
		return 1;
	}

	public long fibonacci(byte[] number)
	{
		byte[] bytes = ByteBuffer.allocate(4).putInt(key).array();
		int i=0;
		int value=0;
		for(byte b: number)
		{
			int shift = (4 - 1 - i) * 8;
        	value += ((b^bytes[i%4]) & 0x000000FF) << shift;
			i++;
		}
		System.out.println(value);
		return genfib(value);
	}

	public long genfib(int number)
	{
		if(number<=0)
		{
			return (long) 0;
		}
		if(number==1)
		{
			return (long) 1;
		}
		if(number<100000 && arr[number]!= (long) 0)
		{
			return arr[number];
		}
		if(number<100000)
		{
			arr[number] = genfib(number-1)+genfib(number-2);
			return arr[number];
		}
		return genfib(number-1)+genfib(number-2);
	}

	public String tolower(byte[] chararr)
	{
		byte[] bytes = ByteBuffer.allocate(4).putInt(key).array();
		ByteBuffer bytes1 = ByteBuffer.allocate(chararr.length);
		for(int i=0;i<chararr.length;i++)
		{
			int t = chararr[i]^bytes[i%4];
			bytes1.put((byte) t);
		}
		byte[] bytes2 = bytes1.array();
		String n = new String(bytes2);
		StringBuilder b = new StringBuilder();
		for(int i = 0; i < n.length(); i++) 
		{
		    char c = n.charAt(i);

		    if(Character.isLowerCase(c) == true)
		    {
		        b.append(String.valueOf(c).toUpperCase());
		    }
		    else
		    {
		        b.append(String.valueOf(c).toLowerCase());
    		}
		}
		return b.toString();
	}

	public int palindrome(byte[] chararr)
	{
		byte[] bytes = ByteBuffer.allocate(4).putInt(key).array();
		ByteBuffer bytes1 = ByteBuffer.allocate(chararr.length);
		for(int i=0;i<chararr.length;i++)
		{
			int t = chararr[i]^bytes[i%4];
			bytes1.put((byte) t);
		}
		byte[] bytes2 = bytes1.array();
		String n = new String(bytes2);
		int i=0;
		int j=n.length()-1;
		while(i<j)
		{
			if(n.charAt(i)!=n.charAt(j))
			{
				return 0;
			}
			i++;
			j--;
		}
		return 1;
	}
} 