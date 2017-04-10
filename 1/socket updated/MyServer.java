package mysocket;

import java.io.*;  
import java.net.*;  
public class MyServer {  
	public static void main(String[] args) throws IOException{  
            	    ServerSocket ss=new ServerSocket(6669); 
		    System.out.println("Server Running\n");
	    try{  
			
                    int clientno=0;
                    while(true)
                    {
                       
                        new serverThread(ss.accept(),clientno++).run();//establishes connection   
                    
                    } 
                     
	       }
	    catch(Exception e){
                System.out.println(e);
                  
	    }  
            finally{
                		ss.close();

            }
        }
}  
class serverThread extends Thread
{
             String str1;
             Socket s;
    public serverThread(Socket socket,int clientno) {
            this.s=socket;
            System.out.println("Server Connected to client #"+clientno);
    }
    public void run()
    {
       
     try
     {
    DataInputStream din=new DataInputStream(s.getInputStream());  
    DataOutputStream dout=new DataOutputStream(s.getOutputStream());
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in)); 
			
    String  str=(String)din.readUTF();  
    System.out.println("choice received= "+str);
		
			switch(Integer.parseInt(str))
			{
				case 1:		
							str1=din.readUTF();
							System.out.println("String received= "+str1);
                                                        System.out.println("length of String is "+str1.length());
                                                        
							 dout.writeUTF(String.valueOf(str1.length()));
                                                        System.out.println(" whether length of string is correct/incorrect?");
                                                        String res2=br.readLine();
                                                        dout.writeUTF("is length "+res2+"?");
                                                        System.out.println("\n");
							break;
				case 2:		
							str1=din.readUTF();
							System.out.println("String received= "+str1);
                                                        System.out.println("uppercase string is= "+str1.toUpperCase());
                                                        
							
                                                        dout.writeUTF(str1.toUpperCase());
                                                        System.out.println("whether uppercase of string is  correct/incorrect?");
                                                         res2=br.readLine();
                                                        dout.writeUTF("is uppercase "+res2+"?");
                                                        System.out.println("\n");
							break;
				case 3:		
							str1=din.readUTF();
							System.out.println("Number received= "+str1);
                                                        int f=new calc().calcFact(Integer.parseInt(str1));
                                                        System.out.println("Factorial is= "+f);
							
							
                                                        dout.writeUTF(String.valueOf(f));
							 System.out.println("whether factorial of number correct/incorrect?");
                                                         res2=br.readLine();
                                                        dout.writeUTF("is factorial "+res2+"?");
                                                        System.out.println("\n");
                                                        break;
			}
     }
     catch(Exception e)
     {
         System.out.println(e);
     }
    }

}
class calc
{
	
	int calcFact(int n)
	{
		int i,fact=1;
		for(i=1;i<=n;i++)
			fact*=i;
		return fact;
	}
	
}

