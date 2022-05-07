package hack1;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {
	
	InputStream in;
	PrintStream out;
	
	public static void main(String[] args) {
		new Solution();
	}
	
	Solution(){
		this.in = System.in;
		this.out = System.out;
		new Solution(in,out);
	}
	
	Solution(InputStream in,PrintStream out){
		Scanner scan = new Scanner(in);
		String s = scan.nextLine();
		scan.close();

		s = s.trim();
		if (s.equals(""))
			out.println(0);
		else {
			List<String> ss = Solution.split(s);
			out.println(ss.size());
			for (String token : ss) {
				out.println(token);
			}
		}
	}
	

	public static List<String> split(String str) {
		return Stream.of(str.split("[\\!\\,\\.\\s\\?\\_\\'\\@]+")).map(elem -> new String(elem))
				.collect(Collectors.toList());
	}
	
	
}
