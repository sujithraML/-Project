package anagram;

public class DisplayAnagram {

	public static void main(String[] args) {
		String s="pot is in the top floor Moreover 24 is 42 he saw what was a good film hello the word parts is an anagram of strap and traps Please stop for pots";
		String s3=s.toLowerCase();
		
		String [] strr=s3.split(" ");
		int count1=strr.length;

			for(int k=0;k<count1;k++) {
				for(int l=k+1;l<count1;l++) {
						int count=0;
						String s1=strr[k];
						String s2=strr[l];
							if(s1.length()==s2.length()) {
								if(!s1.equals(s2)) {
									for(int i=0;i<s1.length();i++) {
										for(int j=0;j<s1.length();j++) {
											if(s1.charAt(i)==s2.charAt(j)) {
												count++;
											}
										}
									}
								}
							}
							if(count==s1.length()) {
								System.out.println(s1+" "+s2+" are anagrams");
							}
				}
			}
	}
}
