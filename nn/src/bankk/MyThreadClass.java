package bankk;

public class MyThreadClass extends Thread {
	   private int amount;
	public void run() // overriding
	{
	m2();
	}
	public void m2()
	{
	  long id=Thread.currentThread().getId();
	  System.out.println("Inside m3 ThreadID "+id+" Amount "+amount);
	  try{
	   for(int i=0;i<5;i++)
	   {
	amount+=i;
	    System.out.println(id+ "  " + amount);
	    Thread.sleep(2000);
	       }
	  }catch(Exception e)
	  {
	  System.out.println(e.getMessage());
	  }
	}
	}