package hack4;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        
        int l = scan.nextInt();
        int[] A = new int[l];
        int index=0;
        while (l-- > 0) {
            A[index] = scan.nextInt();
            index++;
           
        }
        scan.close();
        int negativesumsubs=0;
        // int n=0;
        for(int i=0;i<A.length;i++){
            for(int j=i+1;j<=A.length;j++){
                int[] sub = Arrays.copyOfRange(A, i, j);
                int subsum=0;
                for(int x : sub){
                    subsum+=x;
                   // System.out.print(x+" ");
                }
                //System.out.print(subsum);
                //System.out.println(" ");
        //        n++;
                if(subsum<0) negativesumsubs++;
            }
        }
        System.out.println(negativesumsubs);        
        //System.out.println(n++);
    }
}