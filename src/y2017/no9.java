package y2017;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class no9 {
	public static void main(String[] args) {
		try {
			File file = new File("src/y2017/no9");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			
			int value = 0;
			int value2 = 0;
						
			line = bufferedReader.readLine();
			
			line = line.replaceAll("!.", "");
			
			List<String> matches = new ArrayList<String>();
			Matcher m = Pattern.compile("(?=(" + "<[^>]*>" + "))").matcher(line);
			int start = 0;
	        while(m.find(start)) {
	            matches.add(m.group(1));
	            start = m.start() + m.group(1).length();
	        }
	        for(String s: matches) {
	        	s = s.substring(1, s.length()-1);
	        	value2 += s.length();
	        }

			
			line = line.replaceAll("<[^>]*>", "");
			line = line.replaceAll(",", "");
			
			int embedded = 1;
			
			for(char c : line.toCharArray()) {
				if(c == '{') {
					value += embedded;
					embedded++;
				}
				else {
					embedded--;
				}
					
					
			}
			
			System.out.println(line);
			
			
			fileReader.close();
			System.out.println(value);
			System.out.println(value2);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
