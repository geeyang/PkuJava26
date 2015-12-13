public class Solution {
    public boolean isAnagram(String s, String t) {
    boolean r=true;
    char[] ss=s.toCharArray();
     char[] tt=t.toCharArray(); 
     if(ss.length!=tt.length)
     {
         return false;
     }
     int[] sss=new int[ss.length];
     int[] ttt=new int[tt.length];
     for(int i=0;i<ss.length;i++)
     {
    	 sss[i]=(int)ss[i];
    	 ttt[i]=(int)tt[i];
    	// System.out.println(sss[i]);
     }
     Arrays.sort(sss);
     Arrays.sort(ttt);
     
     for(int i=0;i<ss.length;i++)
     {
    	 if(sss[i]!=ttt[i])
    	 {
    		 return false;
    	 }
     }
     return r;
        
    }
}