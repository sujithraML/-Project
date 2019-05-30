package learnmorechanged;

public class Person {
	private long studentId;
	private String studentName,studentDob,studentBloodGroup;
	int studentHeight,studentMark1,studentMark2,studentMark3,studentMark4,studentMark5,studentMark6;
	
	public long getStudentId() {
		return studentId;
	}
	public void setStudentId(long studentIdValue) {
		if((long)Math.log10(studentIdValue)+1==9) {
			this.studentId = studentIdValue;
		}
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		if(studentName!=null) {
			this.studentName = studentName;
		}
	}
	public String getStudentDob() {
		return studentDob;
	}
	public void setStudentDob(String studentDob) {
		this.studentDob = studentDob;
	}
	public String getStudentBloodGroup() {
		return studentBloodGroup;
	}
	public void setStudentBloodGroup(String studentBloodGroup) {
		this.studentBloodGroup = studentBloodGroup;
	}
	public int getStudentHeight() {
		return studentHeight;
	}
	public void setStudentHeight(int studentHeight) {
		this.studentHeight = studentHeight;
	}
	public int getStudentMark1() {
		return studentMark1;
	}
	public void setStudentMark1(int studentMark1) {
		this.studentMark1 = studentMark1;
	}
	public int getStudentMark2() {
		return studentMark2;
	}
	public void setStudentMark2(int studentMark2) {
		this.studentMark2 = studentMark2;
	}
	public int getStudentMark3() {
		return studentMark3;
	}
	public void setStudentMark3(int studentMark3) {
		this.studentMark3 = studentMark3;
	}
	public int getStudentMark4() {
		return studentMark4;
	}
	public void setStudentMark4(int studentMark4) {
		this.studentMark4 = studentMark4;
	}
	public int getStudentMark5() {
		return studentMark5;
	}
	public void setStudentMark5(int studentmark5) {
		this.studentMark5 = studentmark5;
	}
	public int getStudentMark6() {
		return studentMark6;
	}
	public void setStudentMark6(int studentMark6) {
		this.studentMark6 = studentMark6;
	}
}
