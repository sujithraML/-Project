package sort;

public class Sorting {

	public static void main(String[] args) {
		int[] nos= {11,23,4,56,32,43,323,76,8,54,56};
		
		int i,j=0,temp=0;
		for(i=0;i<nos.length;i++) {
			for(j=i+1;j<nos.length;j++) {
				if(nos[i]>nos[j]) {
					temp=nos[i];
					nos[i]=nos[j];
					nos[j]=temp;
				}
			}
		}
		for(i=0;i<nos.length;i++) {
			System.out.println(nos[i]);
		}
	}

}
