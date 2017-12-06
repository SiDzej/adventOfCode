package y2017;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class no2 {
	public static void main(String[] args) {
		try {
			File file = new File("src/y2017/no2");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			
			int value = 0;
			int value2 = 0;
			
			List<Integer> list = new ArrayList<Integer>();
			
			while ((line = bufferedReader.readLine()) != null) {
				for(String s: line.split("	")) {
					list.add(Integer.parseInt(s));
				}
				value += Collections.max(list) - Collections.min(list);
				boolean br = false;
				for(int i=0;i<list.size();i++) {
					for(int j=0; j<list.size();j++) {
						if(i==j)continue;
						if(list.get(i)%list.get(j) == 0) {
							value2 += list.get(i)/list.get(j);
							br=true;
							break;
						}
						if(list.get(j)%list.get(i) == 0) {
							value2 += list.get(j)/list.get(i);
							br=true;
							break;
						}
					}
					if(br) break;
				}
					
				
				
				list.clear();
			}
			
			
			
			fileReader.close();
			System.out.println(value);
			System.out.println(value2);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
