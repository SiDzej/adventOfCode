package y2015;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;

public class no7 {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String,Integer>();
		String inputs[],output,parsed[];
		try {
			File file = new File("src/y2015/no7");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			
			 /*Pattern p = Pattern.compile(".*[aeiou].*[aeiou].*[aeiou].*");
			 Pattern p2 = Pattern.compile(".*(.)\\1+.*");
			 Pattern p3 = Pattern.compile("^((?!ab|cd|pq|xy).)*$");*/
			Pattern p = Pattern.compile(".*(..).*\\1+.*");
			Pattern p2 = Pattern.compile(".*(.).\\1+.*");
			int i = 0;
			
			List<String>lines = new ArrayList<String>();
			List<String>lines2 = new ArrayList<String>();
			
			while ((line = bufferedReader.readLine()) != null) {
				lines.add(line);
				parsed = line.split("->");
				output = parsed[1].trim();
				if(!output.equalsIgnoreCase("b")) 
					lines2.add(line);
			}
			while (!lines.isEmpty()) {
				//System.out.println(lines.toString());
				line = lines.get(0);
				lines.remove(0);
				
				parsed = line.split("->");
				inputs = parsed[0].split(" ");
				output = parsed[1].trim();
				//if(output.equalsIgnoreCase("a"))
				
				if(inputs.length == 1) {
					//System.out.println(parsed[1]);
					try {
						int a = Integer.parseInt(inputs[0]);
						map.put(output, a);
						
					}
					catch (NumberFormatException e)
					{
						
						if(map.get(inputs[0]) != null)
							map.put(output, map.get(inputs[0]));
						else {
							lines.add(line);
							continue;
						}
					}					
				}
				else if(inputs.length == 2) {
					try {
						if(map.get(inputs[1]) == null) {
							lines.add(line);
							continue;
						}
						
						map.put(output, (~map.get(inputs[1]) & 0x0000ffff));
					}
					catch (NullPointerException e){
						lines.add(line);
						continue;
					}
				}
				else if(inputs.length == 3) {
					int s2 = 0,s1=0;
					try {
						s2 = map.get(inputs[0]).hashCode();
						s1 = map.get(inputs[0]);
					}
					catch (NullPointerException e){
						try {
							s1 = Integer.parseInt(inputs[0]);
							
						}
						catch (NumberFormatException f)
						{
							lines.add(line);
							continue;
						}
					}
					
					if(inputs[1].equalsIgnoreCase("RSHIFT") || inputs[1].equalsIgnoreCase("LSHIFT")) {
						s2 = Short.parseShort(inputs[2]);
						//System.out.println(s1 + " " + inputs[1]);
						
						if(inputs[1].equalsIgnoreCase("RSHIFT"))
							s1 = (s1 >>> s2);
						else
							s1 = (s1 << s2);
						//System.out.println(s1 & 0x0000ffff);
					}						
					else {
						try {
							s2 = map.get(inputs[2]).shortValue();
						}
						catch (NullPointerException e){
							try {
								s2 = Integer.parseInt(inputs[2]);								
							}
							catch (NumberFormatException f)
							{
								lines.add(line);
								continue;
							}
						}
						if(inputs[1].equalsIgnoreCase("AND"))
							s1 = (s1 & s2);
						else
							s1 = (s1 | s2);
					}
					map.put(output, s1 & 0x0000ffff);
				}
			}
			System.out.println(map.get("a"));
			int x = map.get("a");
			map.clear();
			lines = lines2;
			lines.add(x + " -> b");
				
			while (!lines.isEmpty()) {
				//System.out.println(lines.toString());
				line = lines.get(0);
				lines.remove(0);
				
				parsed = line.split("->");
				inputs = parsed[0].split(" ");
				output = parsed[1].trim();
				//if(output.equalsIgnoreCase("a"))
				
				if(inputs.length == 1) {
					//System.out.println(parsed[1]);
					try {
						int a = Integer.parseInt(inputs[0]);
						map.put(output, a);
						
					}
					catch (NumberFormatException e)
					{
						
						if(map.get(inputs[0]) != null)
							map.put(output, map.get(inputs[0]));
						else {
							lines.add(line);
							continue;
						}
					}					
				}
				else if(inputs.length == 2) {
					try {
						if(map.get(inputs[1]) == null) {
							lines.add(line);
							continue;
						}
						
						map.put(output, (~map.get(inputs[1]) & 0x0000ffff));
					}
					catch (NullPointerException e){
						lines.add(line);
						continue;
					}
				}
				else if(inputs.length == 3) {
					int s2 = 0,s1=0;
					try {
						s2 = map.get(inputs[0]).hashCode();
						s1 = map.get(inputs[0]);
					}
					catch (NullPointerException e){
						try {
							s1 = Integer.parseInt(inputs[0]);
							
						}
						catch (NumberFormatException f)
						{
							lines.add(line);
							continue;
						}
					}
					
					if(inputs[1].equalsIgnoreCase("RSHIFT") || inputs[1].equalsIgnoreCase("LSHIFT")) {
						s2 = Short.parseShort(inputs[2]);
						//System.out.println(s1 + " " + inputs[1]);
						
						if(inputs[1].equalsIgnoreCase("RSHIFT"))
							s1 = (s1 >>> s2);
						else
							s1 = (s1 << s2);
						//System.out.println(s1 & 0x0000ffff);
					}						
					else {
						try {
							s2 = map.get(inputs[2]).shortValue();
						}
						catch (NullPointerException e){
							try {
								s2 = Integer.parseInt(inputs[2]);								
							}
							catch (NumberFormatException f)
							{
								lines.add(line);
								continue;
							}
						}
						if(inputs[1].equalsIgnoreCase("AND"))
							s1 = (s1 & s2);
						else
							s1 = (s1 | s2);
					}
					map.put(output, s1 & 0x0000ffff);
				}
			}
				
			fileReader.close();
			System.out.println(map.get("a"));
		} catch (IOException e) {
			System.err.println("fasdfa");
			e.printStackTrace();
			
		} catch (NullPointerException e) {
			System.out.println(map.toString());
			e.printStackTrace();
		}

	}
}
