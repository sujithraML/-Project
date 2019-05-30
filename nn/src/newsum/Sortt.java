package newsum;

public class Sortt {

	public static void main(String[] args) {
		int [][] array1= {
						{82,38,45,77,55,0,0},
						{95,99,92,90,85,0,0},
						{85,100,91,92,93,0,0},
						{75,55,92,74,66,0,0},
						{85,75,58,62,75,0,0}
						};
		int i,j;
		for(j=0;j<5;j++) {
			for(i=0;i<5;i++) {
				array1[j][5]+=array1[j][i];
			}
			array1[j][6]=array1[j][5]/5;
		}
		System.out.println("sub1\tsub2\tsub3\tsub4\tsub5\ttotal\tavg");
		for(i=0;i<5;i++) {
			for(j=0;j<7;j++) {
				System.out.print(" "+array1[i][j]+"\t");
			}
			System.out.println();
		}
	}
	
}
