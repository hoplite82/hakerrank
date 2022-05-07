package hack_substring;
public class SubStringsArray {

	public static void main(String[] args) {
		String s = "hellofuckingjavaagain";
		int k =4;
		String[] subs = new String[s.length()-(k-1)]; 
		
		String lexmax="XXXX";
		String lexmin="aaaa";
		
		for (int i = 0; i < s.length()-(k-1); i++) {
			String sub = s.substring(i,i+k);
			if(sub.compareTo(lexmax)<0) lexmax=sub;
			if(sub.compareTo(lexmin)<0) lexmin=sub;
			subs[i]=s.substring(i,i+k);
		}
		for (String sub : subs) {
			System.out.println(sub);
		}
		
		System.out.println(s.length());
		System.out.println(subs.length);

	}

}
