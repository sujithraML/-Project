package learnmorechanged;

import java.util.Scanner;

public class TestLearnMore {

	public static void main(String[] args) {
		Student stdobjarr[]=new Student[30];
		
		Employee empobjarr[]=new Employee[30];
		
		Scanner sc=new Scanner(System.in);
		
		for(int k=0;k<60;k++) {
	
		System.out.println("Enter 'Employee login' or 'Student login' or 'break'");
		
		String eors=sc.nextLine();
		
		if(eors.equals("Employee login")) {
			System.out.println(eors);
			int i=0;
			for(i=0;i<30;i++) {
				System.out.println("do you want to enter the student details or retrive the student details \n Make your choice as 'Enter' or 'Retrieve' or 'break'");
				
				String choice=sc.next();
				
				if(choice.equals("Retrieve")) {
					
					System.out.println("Enter the Id and the name");
					
					Student empobj=new Student();
					
					empobj.setStudentId(sc.nextLong());
					
					empobj.setStudentName(sc.next());
					
					for(int j=0;j<30;i++) {
						if(empobj.getStudentId()==empobjarr[j].getStudentId()){
									System.out.println("Dob : "+empobjarr[j].getStudentDob()+"\nBloodGroup : "+empobjarr[j].getStudentBloodGroup()+"\nHeight :"+empobjarr[j].studentHeight+"\nSubject 1 : "+empobjarr[j].studentMark1+"\nSubject 2 : "+empobjarr[j].studentMark2+"\nSubject 3 : "+empobjarr[j].studentMark3+"\nSubject 4 : "+empobjarr[j].studentMark4+"\nSubject 5 : "+empobjarr[j].studentMark5+"\nSubject 6 : "+empobjarr[j].studentMark6);
									break;
						}
					}
					
				}
				else
					if(choice.equals("Enter")) {
						
						System.out.println("Enter student id \n student name \n dateofbirth \n bloodgroup\n height \n mark1 \n mark2 \n mark3 \n mark4 \n mark5\n mark6");
						
						empobjarr[i]=new Employee();
						
						empobjarr[i].setStudentId(sc.nextLong());
						
						empobjarr[i].setStudentName(sc.next());
						
						empobjarr[i].setStudentDob(sc.next());
						
						empobjarr[i].setStudentBloodGroup(sc.next());
						
						empobjarr[i].setStudentHeight(sc.nextInt());
						
						empobjarr[i].setStudentMark1(sc.nextInt());
						
						empobjarr[i].setStudentMark2(sc.nextInt());
						
						empobjarr[i].setStudentMark3(sc.nextInt());
						
						empobjarr[i].setStudentMark4(sc.nextInt());
						
						empobjarr[i].setStudentMark5(sc.nextInt());
						
						empobjarr[i].setStudentMark6(sc.nextInt());
						
						i++;
						
					}
					else 
						System.out.println("Enter input in one of the above mentioned type");
				}
		}
		else
			if(eors.equals("Student login")) {
				System.out.println(eors);
				int i=0;
				for(i=0;i<30;i++) {
					System.out.println("do you want to enter the student details or retrive the student details \n Make your choice as 'Enter' or 'Retrieve' or 'break'");
					
					String choice=sc.next();
					
					if(choice.equals("Retrieve")) {
						
						System.out.println("Enter the Id and the name");
						
						Student stdobj=new Student();
						
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
							
							stdobjarr[i]=new Student();
							
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

			}
			else
				if(eors.equals("break")) {
					break;
				}
				else
				System.out.println("Enter input in one of the above mentioned type");
		}
		sc.close();
	}

}
