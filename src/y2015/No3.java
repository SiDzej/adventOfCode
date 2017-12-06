package y2015;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class No3 {
	public static void main(String[] args) {
		try {
			File file = new File("src/y2015/no3");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			
			int paper = 0, a=0,b,smallest,x=0,y=0,x2,y2,ribbon = 0,l,w,h;
			boolean even= false;
			int[][] grid = new int[1000][1000];
			line = bufferedReader.readLine();
			for (x=0;x<1000;x++)
				for(y=0;y<1000;y++)
					grid[x][y] = 0;
			x=x2=499;
			y=y2=499;
			grid[x][y]++;
			grid[x][y]++;
			for (char c : line.toCharArray()) {
				if(even) {
					if(c == 'v') y--;
					if(c == '^') y++;
					if(c == '<') x--;
					if(c == '>') x++;
					grid[x][y]++;
				}
				else {
					if(c == 'v') y2--;
					if(c == '^') y2++;
					if(c == '<') x2--;
					if(c == '>') x2++;
					grid[x2][y2]++;
				}
				even=!even;
				
			}
			for (x=0;x<1000;x++)
				for(y=0;y<1000;y++) {
					if(grid[x][y] > 0) a++;
				}
			fileReader.close();
			System.out.println(a);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
