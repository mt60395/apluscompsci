// Score: 95

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Texting {
    public Texting() throws IOException {
    	run();
    }

	public void run() throws IOException{
		Scanner file = new Scanner(new File("text.in"));
		int size = file.nextInt();
		file.nextLine();
		StringBuilder s = new StringBuilder();
		HashMap<String, String> dict = new HashMap<>();
		dict.put("\\b(?i)happy\\b", ":)");
		dict.put("\\b(?i)sad\\b", ":(");
		dict.put("\\b(?i)angry\\b", "D:<");
		dict.put("\\b(?i)laughing\\b", "XD");
		dict.put("\\b(?i)discontented\\b", "ugh");
		dict.put("\\b(?i)laugh out loud\\b", "lol");
		dict.put("\\b(?i)talk to you later\\b", "ttyl");
		dict.put("\\b(?i)I don't know\\b", "idk");
		dict.put("\\b(?i)cool\\b", "\\$)");
		for (int i = 0; i < size; i++) {
			String line = file.nextLine();
			for (String pattern: dict.keySet()) {
				Pattern p = Pattern.compile(pattern);
				Matcher matcher = p.matcher(line);
				while (matcher.find()) {
					line = matcher.replaceAll(dict.get(pattern));
				}
			}
			s.append(line.substring(0, 1).toUpperCase());
			if (line.length() > 1) {
				s.append(line.substring(1));
			}
			s.append("\n");
		}
		System.out.println(s);

		file = new Scanner(new File("text.out"));
		StringBuilder temp = new StringBuilder();
		while(file.hasNextLine()){
			temp.append(file.nextLine()).append("\n");
		}
		System.out.println( temp.toString().equals(s.toString())?"\nIt matches!":"\nkeep trying");
	}

	public static void main(String[] args) throws IOException {
        new Texting();
    }
}

