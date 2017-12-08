package y2017;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class no7 {
	
	
	public static void main(String[] args) {
		no7 instance = new no7();
		try {
			File file = new File("src/y2017/no7");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			
			String value = "";
			int value2 = 0;
			
			List<node> leaf = new ArrayList<node>();
			Map<String,node> map = new HashMap<String,node>();
			Stack<node> stack = new Stack<node>();
			
			String tmp;
			Integer tmpint;
			String[] split;
			
			while((line = bufferedReader.readLine())!= null) {
				if(line.contains("->")) {
					split = line.split(" -> ");
					
					tmp = split[0].split(" ")[1]; tmp = tmp.substring(1, tmp.length()-1);
					tmpint = Integer.parseInt(tmp);
					tmp = split[0].split(" ")[0];
					node x = instance.new node(tmp, tmpint);
					x.addtoget(split[1].split(", "));
					leaf.add(x);
					map.put(tmp, x);
				}
				else {
					tmp = line.split(" ")[1];
					tmp = tmp.substring(1, tmp.length()-1);
					tmpint = Integer.parseInt(tmp);
					tmp = line.split(" ")[0];
					node x = instance.new node(tmp, tmpint);
					leaf.add(x);
					map.put(tmp, x);
				}
			}
			node a = null;
			for (node x : map.values()) {
				if(x.toget != null) {
					for(String s: x.toget) {
						a = map.get(s);
						leaf.remove(a);
						a.parent = x;
						x.leafs.add(a);
					}
				}
			}
			////
			value = leaf.get(0).name; //root
			/////
			stack.add(leaf.get(0));
			node top, problem=null;
			while(!stack.isEmpty()) {
				top = stack.peek();
				if(top.equals(problem))
					break;
				if (top.leafsweight != 0) {
					top.leafs.clear();
				}
				for(node n : top.leafs)
					stack.push(n);
				if(top.leafs.isEmpty()) {
					top.parent.set.add(top.weight + top.leafsweight);
					if(top.parent.set.size() > 1) {
						problem = top.parent;
					}
					top.parent.leafsweight += top.weight + top.leafsweight;	
					stack.pop();
				}
			}
			Map<Integer,Integer> temp = new HashMap<Integer,Integer>();
			List<Integer> temp2 = new ArrayList<Integer>();
			for(node x: problem.leafs) {
				//System.out.println(x.weight + " " + x.leafsweight + " " + (x.weight+x.leafsweight));
				temp.put(x.weight+x.leafsweight , x.weight);
				temp2.add(x.weight+x.leafsweight);
			}
			Iterator<Integer> it = problem.set.iterator();
			int difference = it.next() - it.next();
			it = problem.set.iterator();
			int i = it.next();
			
			if(Collections.frequency(temp2, i) != 1)
				i = it.next();
			
			
			value2 = temp.get(i) + difference;
			
			
			
			fileReader.close();
			System.out.println(value);
			System.out.println(value2);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public class node {
		public String name;
		public node parent = null;
		public List<node> leafs = new ArrayList<node>();
		public List<String> toget = null;
		public Integer weight = 0;
		public Integer leafsweight = 0;
		public Set<Integer> set = new HashSet<Integer>();
		public node() {};
		public node(String name, Integer weight) {
			this.name = name; this.weight = weight;
		}
		public void addtoget (String[] nodes) {
			toget = Arrays.asList(nodes);
		}
	}
}
