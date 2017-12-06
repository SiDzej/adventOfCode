package y2015;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class no2 {

	public static void main(String[] args) {
		try {
			File file = new File("src/y2015/no2");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			
			int paper = 0, a,b,c,smallest,x,y,ribbon = 0,l,w,h;
			String[] lwh;
			
			while ((line = bufferedReader.readLine()) != null) {
				lwh = line.split("x");
				l = Integer.parseInt(lwh[0]);
				w = Integer.parseInt(lwh[1]);
				h = Integer.parseInt(lwh[2]);
				a = l*w;
				b = w*h;
				c = l*h;
				x = Math.min(l, Math.min(w, h));
				y = Math.max(Math.min(l,w), Math.min(Math.max(l,w),h));
				
				
				smallest = a; 
				if(smallest > b) smallest = b;
				if(smallest > c) smallest = c;
				paper += smallest + 2*a + 2*b + 2*c;
				ribbon += l*w*h + 2*x + 2*y;
			}
			fileReader.close();
			System.out.println(paper);
			System.out.println(ribbon);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
