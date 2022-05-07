package hack_anagramm;
import java.util.Scanner;

public class AnagramArray {

    static boolean isAnagram(String a, String b) {
        // Complete the function
        a = a.toLowerCase();
        b= b.toLowerCase();
        
        char[] ca = a.toCharArray();
        char[] cb = b.toCharArray();
        
        java.util.Arrays.sort(ca);
        java.util.Arrays.sort(cb);
        
        return java.util.Arrays.equals(ca, cb);
    }
    
    

  public static void main(String[] args) {
    
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}