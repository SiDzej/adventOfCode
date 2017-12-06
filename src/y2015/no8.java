package y2015;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class no8 {
	public static void main(String[] args) {
		try {
			File file = new File("src/y2015/no8");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			
			 /*Pattern p = Pattern.compile(".*[aeiou].*[aeiou].*[aeiou].*");
			 Pattern p2 = Pattern.compile(".*(.)\\1+.*");
			 Pattern p3 = Pattern.compile("^((?!ab|cd|pq|xy).)*$");*/
			Pattern p = Pattern.compile(".*(..).*\\1+.*");
			Pattern p2 = Pattern.compile(".*(.).\\1+.*");
			int i = 0,j = 0;
			
			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
				i += line.length();
				line = line.substring(1, line.length()-1);
				//line = line.replaceAll("(\\\\\\\\)", "b").replaceAll("(\\\\\")", "a").replaceAll("\"\"", "").replaceAll("\\\\x[0-9a-f][0-9a-f]", "c");
				line = line.replaceAll("(\\\\\\\\)", "bbbb").replaceAll("(\\\\\")", "aaaa").replaceAll("\"\"", "dddd").replaceAll("\\\\x[0-9a-f][0-9a-f]", "ccccc");
				j += line.length() + 6;
				System.out.println(line);
			}
				
			fileReader.close();
			System.out.println(i-j);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
