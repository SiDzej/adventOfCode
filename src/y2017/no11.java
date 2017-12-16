package y2017;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class no11 {
	public class map {
		int x = 0, y = 0;
		int maxdistance = 0;
		public map() {}
		public void n() {
			x--;y--;maxdistance();
		}
		public void s() {
			x++;y++;maxdistance();
		}
		public void nw() {
			x--;maxdistance();
		}
		public void sw() {
			y++;maxdistance();
		}
		public void ne() {
			y--;maxdistance();
		}
		public void se() {
			x++;maxdistance();
		}
		public int distance() {
			if(x<0 && y <0 || x>0 && y>0) {
				return Math.abs(x) > Math.abs(y) ? Math.abs(x) : Math.abs(y); //max
			}
			else {
				return Math.abs(x) + Math.abs(y); // not diagonally
			}
		}
		private void maxdistance() {
			int tmp = distance();
			maxdistance = (maxdistance > tmp) ? maxdistance : tmp;
		}
	}
	public static void main(String[] args) {
		no11 instance = new no11();
		try {
			File file = new File("src/y2017/no11");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			
			int value = 0;
			int value2 = 0;
			
			map grid = instance.new map();
						
			line = bufferedReader.readLine();
			
			for(String s: line.split(",")) {
				switch (s.toLowerCase().trim()) {
				case "n":  grid.n(); break;
				case "nw": grid.nw(); break;
				case "ne": grid.ne(); break;
				case "s":  grid.s(); break;
				case "sw": grid.sw(); break;
				case "se": grid.se(); break;
					
					default: System.exit(999);
				}
			}
			value = grid.distance();
			value2 = grid.maxdistance;
			
			
			fileReader.close();
			System.out.println(value);
			System.out.println(value2);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
