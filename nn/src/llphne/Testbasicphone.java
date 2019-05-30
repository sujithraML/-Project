package llphne;

import java.util.Scanner;

public class Testbasicphone{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Basicphone b=new Basicphone();
		
		Scanner s=new Scanner(System.in);
		System.out.println("Enter 10 digit phone number");
		long n=s.nextLong();
		b.makecall(n);
		b.recievecall();
		b.redial(n);
		s.close();
		
	}

}
