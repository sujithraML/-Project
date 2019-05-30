package sort;

//import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import java.util.Scanner;

//import java.util.Scanner;
//import java.util.StringTokenizer;
public class TestWord {

	public static void main(String[] args) {
	/*	String s1="        Hope         it            rains   .";
		String s2=s1.trim();
		char[] c=s2.toCharArray();
		int wordcount=0;
		
		for(int i=0;i<s2.length()-1;i++) {
			if(c[i]==32 ) {	
				while(c[i+1]!=32) {
					wordcount++;
					break;
				}
			}
		}
		System.out.println(++wordcount);

		String s1="Tom and jerry are good friends  , ";
		StringTokenizer st1=new StringTokenizer(s1," ,");
		int count=st1.countTokens();
		System.out.println(count);
		while(st1.hasMoreTokens()) {
			System.out.println(st1.nextToken());
		}
		
		
		String s1="a=64;b=32;c=a+b;print c;";
		Scanner sc=new Scanner("a=64;b=32;c=a+b;print c;").useDelimiter("[^0-9]+");
	
		int a=sc.nextInt();
		int b=sc.nextInt();
		System.out.println(a+b);
		
		String s1="a=64;b=32;c=a+b;print c;";
		StringTokenizer st1=new StringTokenizer(s1,";");
		StringTokenizer st2=new StringTokenizer(st1.nextToken(),"=");
		
		StringTokenizer st3=new StringTokenizer(st1.nextToken(),"=");
		
		StringTokenizer st4=new StringTokenizer(st1.nextToken(),"=");
		
		st2.nextToken();
		int a=Integer.parseInt(st2.nextToken());
		
		st3.nextToken();
		int b=Integer.parseInt(st3.nextToken());
		
		st4.nextToken();
		
		char[]c=st4.nextToken().toCharArray();
		char d=c[1];
		
		switch (d) {
		case '+':
			System.out.println(a+b);
			break;
		case '-':
			System.out.println(a-b);
			break;
		case '*':
			System.out.println(a*b);
			break;
		case '/':
			System.out.println(a/b);
			break;
		default:
				break;
		}
			String r="428914";
		char [] c=r.toCharArray();
		int b=0;
		int i, n=r.length();
		for(i=0;i<r.length();i++,n--) {
			int a=(int)c[i]-48;
			b+=a*Math.pow(10,(n-1));
		}
		System.out.println(b);


		String r="428ryery914yrtgsd63236";
		char [] c=r.toCharArray();
		long b=0;
		int i, n=r.length();
		for(i=0;i<r.length();i++,n--) {
			if(c[i]>=48 && c[i]<58) {
				long a=(long)c[i]-48;
				b=b*10+a;
			}
		}
		System.out.println(b);
	
		Calendar cal=Calendar.getInstance();
		Date date=(Date) cal.getTime();
		try {
			System.out.println(date);
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MMM-dd");
			System.out.println(sdf.format(date));
			SimpleDateFormat sdf2=new SimpleDateFormat("EEEE",Locale.ENGLISH);
			System.out.println(sdf2.format(date));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
			*/
		SimpleDateFormat dt1=new SimpleDateFormat("dd-MMM-yyyy");
		Scanner sc=new java.util.Scanner(System.in);
		System.out.println("Enter your DOB:(yyyy-mm-dd)");
		String dob=sc.nextLine();
		sc.close();
		int year=Integer.parseInt(dob.substring(0,4));
		int month=Integer.parseInt(dob.substring(5,7));
		int day=Integer.parseInt(dob.substring(8,10));
		System.out.println(year+"-"+month+"-"+day);
		Calendar date=new GregorianCalendar(year,month,day);
		date.add(Calendar.YEAR,60);
		date.add(Calendar.MONTH,1);
		date.set(Calendar.DAY_OF_MONTH,1);
		date.add(Calendar.DATE,-1);
		System.out.println("Retirement Date "+dt1.format(date.getTime()));
		
		/*
		Calendar date=new GregorianCalendar(year,month,day);
		Date d1=date.getTime();
		SimpleDateFormat f1=new SimpleDateFormat("yyyy-MMM-dd");
		System.out.println("DOB"+f1.format(d1));
		*/
		
	}

}
