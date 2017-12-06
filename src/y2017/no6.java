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

public class no6 {
	public static void main(String[] args) {
		try {
			File file = new File("src/y2017/no6");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			
			int value = 0;
			int value2 = 0;
			
			List<Integer> list = new ArrayList<Integer>();
			Map<Integer,Integer> hashlist = new HashMap<Integer,Integer>();
			
			line = bufferedReader.readLine();
			for(String s: line.split("	")) {
				list.add(Integer.parseInt(s.trim()));
			}
					
			
			int x = 0;
			int index = 0;
			do {
				hashlist.put(list.hashCode(),0);
				x = Collections.max(list);
				index = list.indexOf(x);
				list.set(index, 0);
				index = (index + 1) % list.size();
				for(int i = x; i > 0; i--, index = (index+1) % list.size()) {
					list.set(index, list.get(index) + 1);
				}
				//list.stream().forEach(System.out::print);
				//System.out.print(" " + list.hashCode());
				hashlist.forEach((k,v) -> hashlist.put(k, ++v));
				//hashlist.forEach((k,v) -> System.out.println(v));
				//System.out.println();
				value++;
			} while (!hashlist.containsKey(list.hashCode()));
			value2 = hashlist.get(list.hashCode());
			
			fileReader.close();
			System.out.println(value);
			System.out.println(value2);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
