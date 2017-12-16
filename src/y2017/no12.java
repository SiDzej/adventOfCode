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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class no12 {
	public class node{
		
	}
	public static void main(String[] args) {
		no12 instance = new no12();
		try {
			File file = new File("src/y2017/no12");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			
			int value = 0;
			int value2 = 0;
			
			Map<Integer, String> lines = new HashMap<Integer, String>();
			String[] temp;
						
			while((line = bufferedReader.readLine()) != null) {
				temp = line.split(" <-> ");
				lines.put(Integer.parseInt(temp[0]), temp[1]);
			}
			Stack<Integer> stack = new Stack<Integer>();
			Set<Integer> connected = new HashSet<Integer>();
			Integer tmp,node;
			while(!lines.isEmpty()) {
				stack.add(lines.keySet().iterator().next());
				while(!stack.isEmpty()) {
					tmp = stack.pop();
					connected.add(tmp);
					for(String s: lines.get(tmp).split(",")) {
						node = Integer.parseInt(s.trim());
						if(!connected.contains(node) && !stack.contains(node))
							stack.push(node);										
					}
					lines.remove(tmp);
				}
				if(value == 0) value = connected.size();
				stack.clear();
				connected.clear();
				value2++;
			}
			
			
			fileReader.close();
			System.out.println(value);
			System.out.println(value2);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
