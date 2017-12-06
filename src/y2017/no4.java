package y2017;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class no4 {
	public static void main(String[] args) {
		try {
			File file = new File("src/y2017/no4");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			
			Pattern p = Pattern.compile(".*(\\s\\w{1,}\\s).*\\1.*");
			int value = 0;
			int value2 = 0;
			
			String line2;
			
			
			while ((line = bufferedReader.readLine()) != null) {
				line2 = line.replace(" ", "  ");
				line2 = " " + line2 + " ";
				if(!p.matcher(line2).matches()) {
					//System.out.println(line2);
					value++;
				}
				String[] words = line.split(" ");
				for(int i = 0; i < words.length; i++) {
					char[]a = words[i].toCharArray();
					Arrays.sort(a);
					words[i] = new String(a);
				}
				int matcher = 0;
				for(int i = 0; i < words.length - 1; i++) {
					for(int j = i+1; j < words.length; j++) {
						if(words[i].equalsIgnoreCase(words[j]))
							matcher++;
					}
				}
				if (matcher == 0)
					value2++;
					
				
			}
				
			fileReader.close();
			System.out.println(value);
			System.out.println(value2);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
