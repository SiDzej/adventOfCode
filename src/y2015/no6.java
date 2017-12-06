package y2015;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class no6 {
	public static void main(String[] args) {
		try {
			File file = new File("src/y2015/no6");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			
			int[][] grid = new int[1000][1000];
			String[] words,start,end;
			int i=0,x=0,y=0;
			
			while ((line = bufferedReader.readLine()) != null) {
				words = line.split(" ");
				//System.out.println(words[0]);
				if(words[0].equalsIgnoreCase("toggle")) {
					start = words[1].split(",");
					end = words[3].split(",");
					for(x=Integer.parseInt(start[0]);x<=Integer.parseInt(end[0]);x++)
						for(y=Integer.parseInt(start[1]);y<=Integer.parseInt(end[1]);y++)
							grid[x][y] +=2;
				}
				else {
					
					start = words[2].split(",");
					end = words[4].split(",");
					if(words[1].equalsIgnoreCase("on")) {
						for(x=Integer.parseInt(start[0]);x<=Integer.parseInt(end[0]);x++)
							for(y=Integer.parseInt(start[1]);y<=Integer.parseInt(end[1]);y++)
								grid[x][y] += 1;
					}
					else
						for(x=Integer.parseInt(start[0]);x<=Integer.parseInt(end[0]);x++)
							for(y=Integer.parseInt(start[1]);y<=Integer.parseInt(end[1]);y++)
								grid[x][y] = Math.max(0, (grid[x][y]-1));
				}
			}
				
			
			for(x=0;x<1000;x++)
				for(y=0;y<1000;y++)
					i+=grid[x][y];
			fileReader.close();
			System.out.println(i);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
