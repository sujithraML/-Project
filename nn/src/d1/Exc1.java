package d1;

import java.util.Scanner;

public class Exc1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int i;
		
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the value for i");
		i=s.nextInt();
		
		switch (i){
		case 1:	System.out.println("This is a simple java program");
				break;
		case 2: System.out.println("This is a simple java program");
		
				int num=100;
				
				System.out.println("The value of num is: "+ num);
				
				num = num* 2;
				
				System.out.println("The value of num * 2 is: "+ num);
				break;
		case 3: int  x=10,y=20;
		
					if(x<y) 
						System.out.println("x is lesser than y");
					
					x = x * 2;
					if(x==y) 
						System.out.println("x is now equal to y");
					x = x * 2;
					if(x>y)
						System.out.println("x is now greater than y");
					if(x==y)
						System.out.println("x is now equalto y");
		case 4:	int a=0;
				
				for(a=0;a<10;a++)
					System.out.println("This is "+ a);
		case 5: int b=0,c=0;
		
				b=20;
				
				for(c=0;c<10;c++) {
					System.out.println("This is x "+c);
					System.out.println("This is y "+b);
					b-=2;
				}
				break;
			
		case 6: int lightspeed;
				long days,seconds,distance;
				
				lightspeed=186000;
				
				days=1000;
				
				seconds= days * 24 * 60 * 60;
				
				distance= seconds * lightspeed;
				
				System.out.println("In"+ days);
				System.out.println(" days light will travel about ");
				System.out.println(distance + "miles.");
			
		case 7: double pi,r,ar;
				r = 10.8;
				pi = 3.1416;
				ar = pi * r * r;
				System.out.println("Area of circle is "+ar);
		default: System.out.println("No such case");
				break;
		
		}
		
		
		s.close();
		
		
	}

}
