package d2;
import java.util.Scanner;
public class exc2 {

	public static void main(String[] args) {
		
		String empid,empname,email;
		long contact;
		int dobyr,dobm,dobd,todayyr=2018,todaym=10;
		Scanner s =new Scanner(System.in);
		empid=s.next();
		empname=s.next();
		contact=s.nextLong();
		email=s.next();
		dobyr=s.nextInt();
		dobm=s.nextInt();
		dobd=s.nextInt();
		
		System.out.println(empid+"\n"+empname+"\n"+contact+"\n"+email+"\n"+dobd);
		
		dobyr=todayyr-dobyr;
		dobm=todaym-dobm;
		if(dobm<0) {
				dobyr-=1;
			
		}
		System.out.println(dobyr);
		s.close();
	}

}
