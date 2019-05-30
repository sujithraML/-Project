package com.aspire.classroom.threads;

public class ThreadSend extends Thread{
	 private String msg; 
	    Sender  sender; 
	  
	    ThreadSend(String m,  Sender obj) 
	    { 
	        msg = m; 
	        sender = obj; 
	    } 
	  
	    public void run() 
	    { 
	        synchronized(sender) 
	        { 
	            sender.send(msg); 
	        } 
	    } 
}
