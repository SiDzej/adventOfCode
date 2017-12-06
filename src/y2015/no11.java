package y2015;

import java.util.regex.Pattern;

public class no11 {
	
	public static String nextpass(String old) {
		String newpass = null;
		char[] letters = new StringBuilder(old).reverse().toString().toCharArray();
		for(int i = 0; i < letters.length; i++) {
			if(letters[i] == 'z')
				letters[i] = 'a';
			else {
				letters[i]++;
				break;
			}				
		}
		newpass = new String(letters);	
		return new StringBuilder(newpass).reverse().toString();
	}
	
	public static void main(String[] args){
		Pattern p = Pattern.compile(".*[iol].*"); // i o l
		Pattern p2 = Pattern.compile(".*(.)\\1+.*(.)\\2+.*");
		
		String pass = "vzbxxyzz"; 
		
		while(true) {
			pass = nextpass(pass);
			if(p.matcher(pass).matches())
				continue;
			if(!p2.matcher(pass).matches())
				continue;
			boolean ok = false;
			char[] a = pass.toCharArray();
			for(int i = 0; i < pass.length()-2;i++) {
				if(a[i]+2 == a[i+1]+1 && a[i+2] == a[i]+2) {
					ok = true;
					break;
				}					
			}
			
			if(!ok)
				continue;
			break;
		}
		
		
		
		//pass = nextpass (pass);
		//System.out.println();
		System.out.println(pass);
	}
}
