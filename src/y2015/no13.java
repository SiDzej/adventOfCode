package y2015;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class no13 {

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
			len += paths[cities.indexOf(city)][cities.indexOf(x)] + paths[cities.indexOf(x)][cities.indexOf(city)];
			
			tmp = recursive(local,x, len, shortest);	
			shortest = (tmp > shortest) ? tmp : shortest;
			
			local.add(x);
		}
		
		
		if(a.isEmpty()) {
			len = length + paths[cities.indexOf(city)][0] + paths[0][cities.indexOf(city)];
			shortest = (len > shortest) ? len : shortest;
			//System.out.println(shortest);
			//shortest = length;
		}		
		
		return shortest;
	}
	
	public static void main(String[] args) {
		try {
			File file = new File("src/y2015/no13");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			
			String[] out;
			int x = 0;
			
			cities.add("me");
			
			while ((line = bufferedReader.readLine()) != null) {
				line = line.replaceAll("\\.", "").replaceAll("would ", "")
						.replaceAll("happiness units by sitting next to ", "").replaceAll("gain ", "").replaceAll("lose ", "-");
				//System.out.println(line);
				out = line.split(" ");
				x = Integer.parseInt(out[1].trim());
				out[0] = out[0].trim();
				out[2] = out[2].trim();
				if(!cities.contains(out[0]))
					cities.add(out[0]);
				if(!cities.contains(out[2]))
					cities.add(out[2]);
				paths[cities.indexOf(out[0])][cities.indexOf(out[2])] = x;
			}
			for(String city: cities)
				copy.add(city);
			
			int shortest = 0,tmp;
			for (String city : cities) {
				copy.remove(city);
				tmp = recursive(copy, city, 0, shortest);		
				shortest = (tmp > shortest)? tmp : shortest;
				copy.add(city);
				break;
			}
				
			fileReader.close();
			System.out.println(shortest);
			for(int i = 0;i<8;i++) {
				for(int j = 0; j < 8; j++)
					System.out.print(paths[i][j] + " ");
				System.out.println("");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
