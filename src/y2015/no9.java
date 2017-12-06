package y2015;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class no9 {
	
	public static List<String> cities = new ArrayList<String>(),copy = new ArrayList<String>();
	public static int[][] paths = new int[10][10];
	
	public static int recursive(List<String> a, String city, int length, int shortest) {
		int tmp = 0,len;
		List<String> local = new ArrayList<String>();
		for(String x: a)
			local.add(x);
		
		for (String x : a) {	
			len = length;
			local.remove(x);
			len += paths[cities.indexOf(city)][cities.indexOf(x)];
			
			tmp = recursive(local,x, len, shortest);	
			shortest = (tmp > shortest) ? tmp : shortest;
			
			local.add(x);
		}
		
		
		if(a.isEmpty()) {
			System.out.println(shortest);
			shortest = length;
		}		
		
		return shortest;
	}
	
	public static void main(String[] args) {
		try {
			File file = new File("src/y2015/no9");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			
			String[] out;
			int x = 0;
			
			while ((line = bufferedReader.readLine()) != null) {
				out = line.split("=");
				x = Integer.parseInt(out[1].trim());
				out = out[0].split("to");
				out[0] = out[0].trim();
				out[1] = out[1].trim();
				if(!cities.contains(out[0]))
					cities.add(out[0]);
				if(!cities.contains(out[1]))
					cities.add(out[1]);
				paths[cities.indexOf(out[0])][cities.indexOf(out[1])] = x;
				paths[cities.indexOf(out[1])][cities.indexOf(out[0])] = x;
			}
			for(String city: cities)
				copy.add(city);
			
			int shortest = 0,tmp;
			for (String city : cities) {
				copy.remove(city);
				tmp = recursive(copy, city, 0, shortest);		
				shortest = (tmp > shortest)? tmp : shortest;
				copy.add(city);
			}
				
			fileReader.close();
			System.out.println(shortest);
			/*for(int i = 0;i<8;i++) {
				for(int j = 0; j < 8; j++)
					System.out.print(paths[i][j] + " ");
				System.out.println("");
			}*/
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
