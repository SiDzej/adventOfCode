package y2015;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class no14 {
	public static void main(String[] args) {
		try {
			File file = new File("src/y2015/no14");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			
			List<Integer[]> rein = new ArrayList<Integer[]>();
			int i=0,top=0;
			int time = 2503,tmp = 2503;
			
			while ((line = bufferedReader.readLine()) != null) {
				line = line.replaceAll(" can fly", "").replaceAll(" km/s for", "")
						.replaceAll(" seconds, but then must rest for", "").replaceAll(" seconds\\.", "");
				Integer[] x = new Integer[6];
				String[]y = line.split(" ");
				//System.out.println(line);
				for(int i1 = 0; i1 <3; i1++) {
					//System.out.println(line);
					x[i1] = Integer.parseInt(y[i1+1]);
				}
				x[3] = x[4] = 0;
				rein.add(x);
			}
			for(int j = 0; j<time;j++) {
				for(Integer[] s: rein) {
					int interval = j%(s[1]+s[2]);
					if(interval < s[1])
						s[3] += s[0];
					
				}
				Collections.sort(rein, 
	                    (o1, o2) -> o1[3].compareTo(o2[3]));
				for(Integer[] s: rein) {
					if(rein.get(rein.size()-1)[3].equals(s[3])) {
						++s[4];
					}
					
						
					
				}
			}
			
			Collections.sort(rein, 
                    (o1, o2) -> o1[4].compareTo(o2[4]));
			
			for(Integer[] s: rein) {
				System.out.println(s[3]);
				
					
				
			}
			
			fileReader.close();
			System.out.println(rein.get(rein.size()-1)[4]);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
