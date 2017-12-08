package y2017;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class no8 {
	public static void main(String[] args) {
		try {
			File file = new File("src/y2017/no8");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;

			int value = 0;
			int value2 = 0;

			Map<String, Integer> map = new HashMap<String, Integer>();
			String[] split;
			int cond1, cond2;
			boolean condok = false;
			
			List<Integer> highest = new ArrayList<Integer>();

			while ((line = bufferedReader.readLine()) != null) {
				split = line.split(" ");
				if (!map.containsKey(split[0]))
					map.put(split[0], 0);
				if (!map.containsKey(split[4]))
					map.put(split[4], 0);
				cond1 = map.get(split[4]);
				cond2 = Integer.parseInt(split[6]);
				condok = false;

				switch (split[5]) {
				case "==":
					if (cond1 == cond2)
						condok = true;
					break;
				case ">=":
					if (cond1 >= cond2)
						condok = true;
					break;
				case "<=":
					if (cond1 <= cond2)
						condok = true;
					break;
				case ">":
					if (cond1 > cond2)
						condok = true;
					break;
				case "<":
					if (cond1 < cond2)
						condok = true;
					break;
				case "!=":
					if (cond1 != cond2)
						condok = true;
					break;
				}

				if (condok) {
					if (split[1].equalsIgnoreCase("inc")) {
						map.put(split[0], map.get(split[0]) + Integer.parseInt(split[2]));
					} else
						map.put(split[0], map.get(split[0]) - Integer.parseInt(split[2]));
				}
				
				highest.add(Collections.max(map.values()));
			}
			value = Collections.max(map.values());

			value2 = Collections.max(highest);
			
			fileReader.close();
			System.out.println(value);
			System.out.println(value2);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
