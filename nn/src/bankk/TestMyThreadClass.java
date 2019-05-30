package bankk;

public class TestMyThreadClass {

	public static void main(String[] args) {
	Thread t1=Thread.currentThread();
	try
	{
	System.out.println("Th ID: " +t1.getId() );
	MyThreadClass t2=new MyThreadClass();
	MyThreadClass t3=new MyThreadClass();
	t2.start(); // t2.run()
	t3.start();
	t2.join();
	}catch(Exception err){System.out.println(err.getMessage());}
	System.out.println("In Main After New Thread Started---END");
	}
	}