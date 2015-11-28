public class Solution {
    public int titleToNumber(String s) {
        if(s.length()==0){
            return 0;
        }
        char[] ss = s.toCharArray();
        int n = ss.length;
        int i=0;double num=0;
        while(n>0){
            num = num + (ss[i]-64)*(Math.pow(26,n-1));
            n--;i++;
        }
        int nums = (int)num;
        return nums;
    }
}