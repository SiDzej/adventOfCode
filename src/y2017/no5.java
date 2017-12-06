package y2017;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class no5 {
	public static void main(String[] args) {
		try {
			File file = new File("src/y2017/no5");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			
			int value = 0;
			int value2 = 0;
			
			List<Integer> list = new ArrayList<Integer>();
			
			while ((line = bufferedReader.readLine()) != null) {
				list.add(Integer.parseInt(line.trim()));
			}
			int actual=0,next=0;
			Integer[] array = list.toArray(new Integer[list.size()]);
			while (actual >= 0 && actual < list.size()) {
				next = array[actual];
				if(array[actual] > 2)
					array[actual]--;
				else
					array[actual]++;
				//System.out.println(actual);
				actual += next;
				value++;
			}
			
			
			fileReader.close();
			System.out.println(value);
			System.out.println(value2);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
