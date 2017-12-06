package y2015;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class no15 {
	
	public static List<Integer[]> ing = new ArrayList<Integer[]>();
	public static int[] x = new int[4];
	
	
	public static int recursive(int depth) {
		int sum=0;
		for(int a: x){
			sum += a;
		}
		
			
		int top = 0,tmp = 0;;
		for(int i = 0; i <= 100 - sum; i++) {
			x[depth] = i;

			if(depth != 0) {
				tmp = recursive(depth - 1);
				top = (top < tmp)? tmp : top;
			}else {
				if(sum+i != 100)
					continue;
				
				int a,b,c,d,calorie;
				a=b=c=d=calorie=0;
				for (int j = 0; j<4; j++) {
					a+=ing.get(j)[0]*x[j];
					b+=ing.get(j)[1]*x[j];
					c+=ing.get(j)[2]*x[j];
					d+=ing.get(j)[3]*x[j];
					
					calorie+=ing.get(j)[4]*x[j];
				}
				//System.out.println(a + " " +b + " " +c + " " +d + " ");
				a=(a>0)?a:0;
				b=(b>0)?b:0;
				c=(c>0)?c:0;
				d=(d>0)?d:0;
				
				//if(a*b*c*d > top)
					//System.out.println(a + " " +b + " " +c + " " +d + " ");
				if(calorie == 500)
					top = (a*b*c*d > top)? a*b*c*d : top;
			}
			
		}
		x[depth] = 0;
		return top;
	}
	
	public static void main(String[] args) {
		try {
			File file = new File("src/y2015/no15");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			
			int i=0;
			String[]y;
			
			
			while ((line = bufferedReader.readLine()) != null) {
				line = line.replaceAll(": capacity", "").replaceAll(", durability", "")
						.replaceAll(", flavor", "").replaceAll(", texture", "").replaceAll(", calories", "");
				y = line.split(" ");
				Integer[] x = new Integer[6];
				for(int i1 = 0; i1 <5; i1++) {
					//System.out.println(line);
					x[i1] = Integer.parseInt(y[i1+1]);
				}
				ing.add(x);
			}
			
			int top = 0;
			
			top = recursive(3);
			
			
			fileReader.close();
			System.out.println(top);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}