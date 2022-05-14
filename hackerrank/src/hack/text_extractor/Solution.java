package hack.text_extractor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

	public static void main(String[] args) {

		getInputLines().forEach(line -> {
			System.out.print(innerText(line));
		});

	}

	static String innerText(String text) {
//		Pattern tag = Pattern.compile("<(\\s*\\/?\\w+\\s*)+>");
		Pattern tag = Pattern.compile("<[^>]+>");
		Matcher matcher = tag.matcher(text);
		String lastopentag = null;
		int mark = -1;

		StringBuilder out = new StringBuilder();
		while (matcher.find()) {

			String ctag = matcher.group();
			if (lastopentag != null && mark != -1 && matcher.group().contains("/")) {
				String innerText = text.substring(mark, matcher.start());
				if (cleanTag(ctag).equals(cleanTag(lastopentag)) && innerText.length()>0) {
					out.append(innerText).append("\n");
				}
				lastopentag = null;
				mark = -1;

			} else {
				lastopentag = matcher.group();
				mark = matcher.end();

			}
		}
		if (out.isEmpty() || "".equals(out.toString().trim()))
			return "None\n";
		else
			return out.toString();

	}

	private static String cleanTag(String tag) {
		// tag = tag.toLowerCase();
		return tag.chars().filter(x -> !(x == 60 || x == 62 || x == 32 || x == (int) '/' || x == (int) '\t'))
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
	}

	private static List<String> getInputLines() {
		Scanner in;
		List<String> lines = new ArrayList<>();
		in = new Scanner(System.in);
		int n = in.nextInt();
		in.nextLine();
		while (n-- > 0) {
			lines.add(in.nextLine());
		}
		in.close();

		return lines;
	}

}
