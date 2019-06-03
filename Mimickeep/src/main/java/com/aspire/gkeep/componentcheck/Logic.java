package com.aspire.gkeep.componentcheck;

public class Logic {
	public boolean isPrime(int number) {
		 int i,m=0;      
		  m=number/2;      
		  if(number==0||number==1){  
			  return false;   
		  }else{  
		   for(i=2;i<=m;i++){      
		    if(number%i==0){      
		    	return false;    
		    }
		   }
		return true;
	}
	}
}
