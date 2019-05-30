package demostatandcon;

public class MPhone
{
//fields
public static String type;//shared and can be edit
public final String model;//read only - immutable. Not Shared
public static final String planType="PostPaid";//constant - Shared but not editable
public MPhone()
	{
		model="Basic Model";
	}
public MPhone(String m1)
	{
		model=m1;
	}
public void setType(String t1)
	{
		type=t1;
	}
	//trying to modify below thing is illegal
/*
public void setModel(String m1)
	{
		model=m1;
	}
public void setPlanType(String plan)
	{
		planType=plan;
	}*/
public void print()
	{
		System.out.println("Model="+model+" Type="+type+" Plan="+planType);
	}
}
