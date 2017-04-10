package mysocket;

import java.io.*;  
import java.net.*;  

public class MyClient {  
	public static void main(String[] args) { 
		try{      
			Socket s=new Socket("127.0.0.1",6669); 
			String str;
                        String temp;
                        String str1;
			System.out.println("Connection established");
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in)); 
			DataOutputStream dout=new DataOutputStream(s.getOutputStream());
			DataInputStream din=new DataInputStream(s.getInputStream()); 
			System.out.println("********String Operations********");
			System.out.println("1]Length of string \n2]lowercase to uppercase\n3]factorial of a number \n4]exit");
			System.out.println("Enter Choice");
			int ch=Integer.parseInt(br.readLine());
			dout.writeUTF(String.valueOf(ch));
			
			switch(ch)
			{
				case 1:	
					System.out.println("Enter String to measure length");
                                        str1=br.readLine();
					dout.writeUTF(str1);
                                        int res=Integer.parseInt(din.readUTF());
					System.out.println("length return from server is ="+res);
                                       System.out.println(din.readUTF());
					break;

				case 2:
					System.out.println("Enter lowercase String");
					str1=br.readLine();
                                        dout.writeUTF(str1);
                                        temp=din.readUTF();
					System.out.println("uppercase is ="+temp);
					System.out.println(din.readUTF());
                                        break;
				case 3:
					System.out.println("Enter Number to find factorial");
					 str1=br.readLine();
					dout.writeUTF(str1);
                                        res=Integer.parseInt(din.readUTF());
                                        
                                        System.out.println("factorial is ="+res);
                                        System.out.println(din.readUTF());
                                        break;
				
				case 4:	
					System.exit(0);
					break;
			}
			dout.flush();  
			dout.close();  
			s.close();  
		}
		catch(Exception e){
			System.out.println(e);
		}  
	}  
}  
