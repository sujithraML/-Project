package phne;

public class phn extends applicatn{
	long modelno;
	String manufacturer,color,modelname,height,width,screensize,weight,processorspeed;
	String ram,rom,chargingcap,sresolution,cclarityf,cclarityb,thickness;
	boolean iocomplete=true,reqtooff=false;
	
	public boolean switchon() {
		if(iocomplete==true)
			return true;
		else {
			System.out.println("sys failure");
			return false;
		}
		
	}
	
	public boolean switchoff() {
		if(reqtooff==true)
			return true;
		return false;
	}
	public  pg home() {
		pg hp=new pg();
		
		return hp;
	}
}

