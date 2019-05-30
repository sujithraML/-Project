package learnmore;

import java.util.Scanner;

public class TestLearnmore {

	public static void main(String[] args) {
		
		LearnMoreStd stdobjarr[]=new LearnMoreStd[30];
		
		Scanner sc=new Scanner(System.in);

		int i=0;
		for(i=0;i<30;i++) {
			System.out.println("do you want to enter the student details or retrive the student details \n Make your choice as 'Enter' or 'Retrieve'");
			
			String choice=sc.next();
			
			if(choice.equals("Retrieve")) {
				
				System.out.println("Enter the Id and the name");
				
				LearnMoreStd stdobj=new LearnMoreStd();
				
				stdobj.setStudentId(sc.nextLong());
				
				stdobj.setStudentName(sc.next());
				
				for(int j=0;j<30;i++) {
					if(stdobj.getStudentId()==stdobjarr[j].getStudentId()){
								System.out.println("Dob : "+stdobjarr[j].getStudentDob()+"\nBloodGroup : "+stdobjarr[j].getStudentBloodGroup()+"\nHeight :"+stdobjarr[j].studentHeight+"\nSubject 1 : "+stdobjarr[j].studentMark1+"\nSubject 2 : "+stdobjarr[j].studentMark2+"\nSubject 3 : "+stdobjarr[j].studentMark3+"\nSubject 4 : "+stdobjarr[j].studentMark4+"\nSubject 5 : "+stdobjarr[j].studentMark5+"\nSubject 6 : "+stdobjarr[j].studentMark6);
								break;
					}
				}
				
			}
			else
				if(choice.equals("Enter")) {
					
					System.out.println("Enter student id \n student name \n dateofbirth \n bloodgroup\n height \n mark1 \n mark2 \n mark3 \n mark4 \n mark5\n mark6");
					
					stdobjarr[i]=new LearnMoreStd();
					
					stdobjarr[i].setStudentId(sc.nextLong());
					
					stdobjarr[i].setStudentName(sc.next());
					
					stdobjarr[i].setStudentDob(sc.next());
					
					stdobjarr[i].setStudentBloodGroup(sc.next());
					
					stdobjarr[i].setStudentHeight(sc.nextInt());
					
					stdobjarr[i].setStudentMark1(sc.nextInt());
					
					stdobjarr[i].setStudentMark2(sc.nextInt());
					
					stdobjarr[i].setStudentMark3(sc.nextInt());
					
					stdobjarr[i].setStudentMark4(sc.nextInt());
					
					stdobjarr[i].setStudentMark5(sc.nextInt());
					
					stdobjarr[i].setStudentMark6(sc.nextInt());
					
					i++;
					
				}
				else 
					System.out.println("Enter input in one of the above mentioned type");
		}
		sc.close();
	}

}
