import java.util.Scanner;

public class leetcode75 {

	public static void main(String[] args){
		int i;
		Scanner in=new Scanner(System.in);
		int[] A=new int[10];
		 for (i = 0; i < A.length; i++) {
		A[i]=in.nextInt();
		 }
		 sortColors(A);
		 for (i = 0; i < A.length; i++) {
				System.out.print(A[i]);
				 }
	}
	    public static void sortColors(int[] A) {
	        int i, r, w, b;  
	        r = w = b = 0; //·Ö„e½yÓ‹¼t°×Ë{µÄ‚€”µ 
	        for (i = 0; i < A.length; i++) {  
	            if (A[i] == 0) r++;  
	            else  if (A[i] == 1) w++;  
	            else b++;  
	        }  
	        for (i = 0; i < A.length; i++) {  
	            if (i < r) A[i] = 0;  
	            else if (i < r + w) A[i] = 1;  
	            else A[i] = 2;  
	        }  
	    }  
	
}
