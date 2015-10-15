
public class leetcode125_2 {
	public static void main(String[] args)
	{
		String s=("aba");	
		 int left = 0;
	      int right = s.length()-1;
	         
	        while (left<right) {
	            char l = s.charAt(left);
	            char r = s.charAt(right);
	             
	            if ( !isValidChar(l) ) {
	                left++;
	                continue;
	            }
	            if ( !isValidChar(r) ) {
	                right--;
	                continue;
	            }
	             
	            if (toLowerCase(l)!=toLowerCase(r))
	            	{System.out.print("not ");
	            	break;
	            	}
	            left++;
	            right--;
	        }
	         
	        System.out.print("a palindrome");
	    }
	     
	    private static boolean isValidChar(char ch) {
	        return (ch<='z' && ch>='a') || (ch<='Z' && ch>='A') || (ch>='0' && ch<='9');
	    }
	     
	    private static char toLowerCase(char ch) {
	        if (ch>='a' && ch<='z')
	            return ch;
	        else
	            return (char) ( ch + ('z'-'Z') );
	    }
	/*    String[] a = s.split(" ");
		String aa="";
		for(int i=0;i<a.length;i++){
			aa+=a[i];
		}
		int l=aa.length();
		//System.out.print(l);
		int i;
		char[] ss=aa.toCharArray();
		char[] result=new char[l];
		result[0]='*';
		int j=0;
		for(i=0;i<l;i++)
		{
			if(((int)(ss[i])>=97&&(int)(ss[i])<=122)||((int)(ss[i])>=65&&(int)(ss[i])<=90)||((int)(ss[i])>=32&&(int)(ss[i])<=41))
			{
				result[j]=ss[i];
				j++;
			}
		}
		//System.out.print(result.length);
		if(result[0]=='*'){
			System.out.println("not palindrome");
		}
		for(i=0;i<j/2;i++)
		{
			//System.out.print(result[i]);
			if(result[i]!=result[j-1-i]&&(result[i]-result[j-1-i])!=32&&(result[i]-result[j-1-i])!=-32)
			{
				System.out.print("not palindrome");
				
			}
		}*/
		
		
		
	
}
