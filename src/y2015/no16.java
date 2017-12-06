package y2015;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class no16 {
	public static void main(String[] args) {
		try {
			File file = new File("src/y2015/no16");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			
			Pattern p = Pattern.compile(".*(children: 3|samoyeds: 2|akitas: 0|vizslas: 0|cars: 2|perfumes: 1[^0-9]|pomeranians: [0-2]|goldfish: [0-4][^0-9]|(cats: ([8-9][^0-9]|[1-9][0-9]))|(trees: ([3-9][^0-9]|[1-9][0-9]))).*");
			Pattern p2 = Pattern.compile(".*(children|samoyeds|akitas|vizslas|cars|perfumes|pomeranians|goldfish|cats).*");
			Pattern p3 = Pattern.compile(".*((perfumes: (0|[2-9]))|goldfish: [5-9]|(samoyeds: ([0-1]|[3-9]))|(akitas: [1-9])|(goldfish: [5-9][^0-9])|(vizslas: [1-9])|(perfumes: 10)|pomeranians: [3-9]|(trees: [0-2])|(children: ([0-2]|[4-9]))|(cars: ([0-1]|[3-9]))).*");
			
			int i = 0;
			
			while ((line = bufferedReader.readLine()) != null) {
				if(p.matcher(line).matches() && !p3.matcher(line).matches()) {
					i++;
					System.out.println(line);
				}
				if(!p2.matcher(line).matches()){
					i++;
					System.out.println(line);
				}
					
			}
			
			fileReader.close();
			System.out.println(i);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
