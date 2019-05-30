package phne;

import java.util.Scanner;

public class pg {

	public pg(){
		System.out.println("HOME page");
	}
	public pg(boolean s) {
		if(s==true) {
		System.out.println("username");
		Scanner v=new Scanner(System.in);
		String user=v.next();
		System.out.println(v);
		System.out.println("password");
		Scanner x=new Scanner(System.in);
		String pwd=x.next();
		System.out.println(x);
		System.out.println(pwd+user);
		}
	
	}
	
}
