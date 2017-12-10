package y2017;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class no10 {
	public static void main(String[] args) {
		try {
			File file = new File("src/y2017/no10");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			
			int value = 0;
			String value2 = "";
			
			List<Integer> list = new ArrayList<Integer>();
			int len = 256;
			int[] circle = new int[len];
			
			for(int i = 0; i < len; i++) {
				circle[i] = i;
			}
			
			String line2;
			line = line2 = bufferedReader.readLine();
			for(String s: line.split(",")) {
				list.add(Integer.parseInt(s.trim()));
			}
				
			int pos = 0, skip = 0;
			List<Integer> temp = new ArrayList<Integer>();
			for(int number: list) {
				for(int i = 0; i< number;i++) {
					temp.add(circle[(pos+i)%len]);
				}
				Collections.reverse(temp);
				for(int i = 0; i< number; i++) {
					circle[(pos+i)%len] = temp.get(i);
				}
				temp.clear();
				pos = (pos+number+skip)%len;
				skip++;
			}
			
			value = circle[0] * circle[1];
			///////////
			list.clear();
			for(int i = 0; i < len; i++) {
				circle[i] = i;
			}
			for(Byte b: line2.getBytes())
				list.add((int)b);
			list.add(17);list.add(31);list.add(73);list.add(47);list.add(23);
			
			pos = 0;
			skip = 0;
			temp.clear();
			for(int round = 0; round < 64; round++) {
				for(int number: list) {
					for(int i = 0; i< number;i++) {
						temp.add(circle[(pos+i)%len]);
					}
					Collections.reverse(temp);
					for(int i = 0; i< number; i++) {
						circle[(pos+i)%len] = temp.get(i);
					}
					temp.clear();
					pos = (pos+number+skip)%len;
					skip++;
				}
			}
			pos = 0;
			int xorred;
			for(int i = 0; i< 16; i++) {
				xorred = circle[pos];
				for(int j = 1; j< 16; j++) {
					xorred ^= circle[pos + j];
				}
				circle[i] = xorred;
				pos+=16;
			}
			
			for(int i = 0; i< 16; i++) {
				value2 += Integer.toHexString(circle[i]);
			}
						
			fileReader.close();
			System.out.println(value);
			System.out.println(value2);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
