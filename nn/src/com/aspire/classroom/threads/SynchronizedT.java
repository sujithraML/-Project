package com.aspire.classroom.threads;

public class SynchronizedT {

	public static void main(String[] args) {
		Sender snd = new Sender(); 
        ThreadSend S1 = new ThreadSend( " Hi " , snd ); 
        ThreadSend S2 = new ThreadSend( " Bye " , snd ); 
  
        S1.start();
        S1.interrupt();
        S2.start();
  
        try
        { 
        	System.out.println("join");
            S1.join(); 
            System.out.println(S1.getState());
            S2.interrupt();
            System.out.println(S2.getState());
            S2.join();
        } 
        catch(Exception e) 
        { 
            System.out.println("Interrupted"); 
        } 
	}

}
