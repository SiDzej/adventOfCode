package y2017;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class no1 {
	public static void main(String[] args) {
		try {
			File file = new File("src/y2017/no1");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			
			char[] array;
			int value = 0;
			int value2 = 0;
			
			
			array = bufferedReader.readLine().toCharArray();
			for( int i = 0; i < array.length-1; i++) {
				if(array[i] == array[i+1])
					value+=Integer.parseInt(array[i]+"");
			}
			if(array[0]==array[array.length-1])
				value+= Integer.parseInt(array[0]+"");
			
			for( int i = 0; i < array.length; i++) {
				if(array[i] == array[(i+array.length/2)%array.length])
					value2+=Integer.parseInt(array[i]+"");
			}
			
			
			
			fileReader.close();
			System.out.println(value);
			System.out.println(value2);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
