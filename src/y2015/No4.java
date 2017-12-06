package y2015;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.util.Base64;

public class No4 {
	public static void main(String[] args) {
		String a = "iwrupvqb",x="";
		byte[] thedigest;
		int i = 0,j=0;
		boolean end = true;
		try {
			while(end) {
				x = a + i;
				
				byte[] bytesOfMessage = x.getBytes("UTF-8");
				
		
				MessageDigest md;
				md = MessageDigest.getInstance("MD5");
				
				 thedigest = md.digest(bytesOfMessage);
				 StringBuffer sb = new StringBuffer();
				 for (int i1 = 0; i1 < thedigest.length; i1++) {
				     if ((0xff & thedigest[i1]) < 0x10) {
				         sb.append('0');
				     }
				     sb.append(Integer.toHexString(0xff & thedigest[i1]));
				 }
				 
				 
				 for(int aa= 0;aa<6;aa++)
					 if((sb.toString().toCharArray())[aa] == '0') j++;
				// System.out.println(j);
				 if(j == 6) break;
				 else j = 0;
				 
				 i++;
				 
			}
			
			System.out.println(i);
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
