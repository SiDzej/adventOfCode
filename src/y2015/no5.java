package y2015;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class no5 {
	public static void main(String[] args) {
		try {
			File file = new File("src/y2015/no5");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			
			 /*Pattern p = Pattern.compile(".*[aeiou].*[aeiou].*[aeiou].*");
			 Pattern p2 = Pattern.compile(".*(.)\\1+.*");
			 Pattern p3 = Pattern.compile("^((?!ab|cd|pq|xy).)*$");*/
			Pattern p = Pattern.compile(".*(..).*\\1+.*");
			Pattern p2 = Pattern.compile(".*(.).\\1+.*");
			int i = 0;
			
			while ((line = bufferedReader.readLine()) != null) {
				//if(p.matcher(line).matches() && p2.matcher(line).matches()&& p3.matcher(line).matches()) i++;
				if(p.matcher(line).matches() && p2.matcher(line).matches()) i++;
			}
				
			fileReader.close();
			System.out.println(i);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
