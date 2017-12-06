package y2015;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class no12 {
	
	public static List<String> getAllMatches(String text, String regex) {
        List<String> matches = new ArrayList<String>();
        Matcher m = Pattern.compile("(?=(" + regex + "))").matcher(text);
        int start = 0;
        while(m.find(start)) {
            matches.add(m.group(1));
            start = m.start()+m.group(1).length();
        }
        return matches;
    }
	
	public static void main(String[] args) {
		try {
			File file = new File("src/y2015/no12");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			
			 /*Pattern p = Pattern.compile(".*[aeiou].*[aeiou].*[aeiou].*");
			 Pattern p2 = Pattern.compile(".*(.)\\1+.*");
			 Pattern p3 = Pattern.compile("^((?!ab|cd|pq|xy).)*$");*/
			Pattern p = Pattern.compile("\\[.*?red.*?\\]");
			Pattern p2 = Pattern.compile(".*(.).\\1+.*");
			int i = 0;
			List<String> a;
			
			while ((line = bufferedReader.readLine()) != null) {
				//System.out.println();
				//getAllMatches(line,"[-0-9]+");
				//System.out.println(line);
				//a = getAllMatches(line, "\\{[^\\{]*?red.*?\\}");
				System.out.println(line);
				while(true) {
					a = getAllMatches(line, "\\{[^\\{\\[]*?\\}");
					for(String x: a) {
						int j = 0;
						
						for(String y: getAllMatches(x.replaceAll(".*red.*", "0"),"[-0-9]+")) {
							j += Integer.parseInt(y);
						}
						
						line = line.replaceAll(Pattern.quote(x), j+"");
					}
					
					System.out.println(line);
					
					a = getAllMatches(line, "\\[[^\\[\\{]*?\\]");
					for(String x: a) {
						int j = 0;
						
						
						//x = x.replaceAll(".*red.*", "");
						for(String y: getAllMatches(x,"[-0-9]+")) {
							j += Integer.parseInt(y);
						}
						line = line.replaceAll(Pattern.quote(x), j+"");
					}
					
					System.out.println(line);
					if(line.length() <7) {
						for(String y: getAllMatches(line,"[-0-9]+")) {
							i += Integer.parseInt(y);
						}
						break;
					}
						
				}
				
			}

			
			
			fileReader.close();
			System.out.println(i);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
