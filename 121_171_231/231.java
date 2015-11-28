public class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n<0){
            return false;
        }
        if(n==0){
            return false;
        }
        double x=(double)n;
        while(x!=1){
            x=x/2;
            if(x<1){
                return false;
            }
        }
        if(x==1){
            return true;
        }
        return true;
    }
}