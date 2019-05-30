package anagramm;

public class AnagramBharath {

	public static void main(String[] args) {
		String s="pot is in the top floor"+ "Moreover 24 is 42"+"he saw what was a good film"+"hello the word parts is an anagram of strap and traps"+"Please stop for pots";
		String s3=s.toLowerCase();
		String s1=new String();
		String s2=new String();
		int count=0;
	
		
		String [] strr=s3.split(" ");
		int count1=strr.length;

			for(int k=0;k<count1;k++) {
				
				for(int l=k+1;l<count1;l++) {
							
							}
							
					if(count==s1.length()) {
						System.out.println(s1+" "+s2+" are anagrams");
				}
				
			}
	}

}

