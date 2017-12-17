package y2017;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class no13 {
	public enum direction {UP , DOWN};
	public static void main(String[] args) {
		try {
			class firewall{
				direction d = direction.DOWN;
				int position = 0;
				int max;
				int loop;
				public firewall(int max) {
					this.max = max - 1;
					this.loop = (max-1)*2;
				}
				
				public void step() {
					if(d == direction.DOWN) {
						if(position == max) {
							d = direction.UP;
						}
					}
					else {
						if(position == 0) {
							d = direction.DOWN;
						}
					}
					if(d == direction.DOWN)
						position++;
					else
						position--;
							
				}
				public boolean caught() {
					return position == 0;
				}
				public void reset() {
					position = 0;
					d = direction.DOWN;
				}
				@Override
				public String toString() {
					return "Firewall " + position + "/" + (max+1);
				}
				
			}
			File file = new File("src/y2017/no13");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			
			int value = 0;
			int value2 = 0;
			
			Map<Integer, firewall> lines = new HashMap<Integer, firewall>();
			String[] temp;
						
			while((line = bufferedReader.readLine()) != null) {
				temp = line.split(": ");
				lines.put(Integer.parseInt(temp[0]), new firewall(Integer.parseInt(temp[1])));
			}
			int tmp = 0,caught = 0;
			int i = 0;
			int loops = 10000000;
			int[] array = new int[loops];
			int[] caughts = new int[loops];
			for(i = 0; i < loops; i++) {
				array[i] = caughts[i] = 0;
			}
			i = 0;
			while(true) {
				for(int loop = 0; loop <100; loop++) {
					if(i - loop < 0) continue;
					if(lines.containsKey(loop)) {
						if(lines.get(loop).caught()) {
							array[i - loop] += loop * (lines.get(loop).max+1);
							caughts[i - loop] += 1;
							//System.out.println("xxxxxxxxxxxxxxxxxxxxxx " + i );
						}
					}
				}
				//if(i-100 >= 0 && array[i-100] == 0) break;

				lines.values().forEach(firewall::step);
				//lines.values().forEach(System.out::println);
				
				i++;
				if (i== 100) break;
			}
			int result = 0;
			while(true) {
				for(Map.Entry<Integer, firewall> entry : lines.entrySet()) {
					if((value2+entry.getKey())%entry.getValue().loop == 0) {
						result++;
						break;
					}
				}
				if(result == 0) break;
				result = 0;
				value2++;
			}
			value = array[0];
			/*for(i = 0; i < loops; i++) {
				if(array[i] == 0 && caughts[i] == 0) {
					//System.out.println(i +  " "+caughts[i]);
					value2 = i;
					break;
				}
			}*/
			
			
			
			fileReader.close();
			System.out.println(value);
			System.out.println(value2);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
