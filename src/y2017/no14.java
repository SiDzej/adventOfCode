package y2017;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class no14 {
	static int [][] grid = new int[128][128];
	public static void main(String[] args) {
		String input = "xlqgujun";
		int value = 0, value2 = 0;
		
		String line = "";
		for(int i=0; i< 128; i++) {
			String tmp = KnotHash(input + "-" + i);
			for(char c: tmp.toCharArray()) {
				value += Integer.bitCount(Integer.parseInt(""+c,16));
				line += format(Integer.toBinaryString(Integer.parseInt(""+c,16)));
				//System.out.print(Integer.toBinaryString(Integer.parseInt(""+c,16)) + " ");
			}
			//System.out.println(line);
			for(int j=0; j< 128;j++) {
				char[] string = line.toCharArray();
				grid[i][j] = (string[j] == '1')? 1 : 0;
				//System.out.print(grid[i][j]);
			}
			
			//System.out.println();
			line = "";
		}
		
		for(int i = 0; i < 128; i++) {
			for(int j=0; j< 128; j++) {
				if(grid[i][j] == 1) {
					value2++;
					flood(i,j);
				}
			}
		}
		
		System.out.println(value);
		System.out.println(value2);
	}
	
	public static void flood(int i, int j) {
		grid[i][j] = 0;
		if(i >0 && grid[i-1][j] == 1) flood(i-1,j);
		if(i < 127 && grid[i+1][j] == 1) flood(i+1,j);
		if(j > 0 && grid[i][j-1] == 1) flood(i,j-1);
		if(j < 127 && grid[i][j+1] == 1) flood(i,j+1);
	}
	public static String format(String a) {
		String tmp="";
		for(int i=0;i<4-a.length();i++)
			tmp += "0";
		return tmp + a;
	}
	
	public static String KnotHash(String input) {
		List<Integer> list = new ArrayList<Integer>();
		int len = 256;
		int[] circle = new int[len];
		for(int i = 0; i < len; i++) {
			circle[i] = i;
		}
		for(Byte b: input.getBytes())
			list.add((int)b);
		list.add(17);list.add(31);list.add(73);list.add(47);list.add(23);
		
		int pos = 0;
		int skip = 0;
		List<Integer> temp = new ArrayList<Integer>();
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
		String result = "";
		for(int i = 0; i< 16; i++) {
			if(Integer.toHexString(circle[i]).length() == 2)
				result += Integer.toHexString(circle[i]);
			else 
				result += "0" + Integer.toHexString(circle[i]);
		}
		return result;
	}
}
