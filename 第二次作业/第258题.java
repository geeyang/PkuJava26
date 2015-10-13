public class Solution {
    public int addDigits(int num) {
       /* int a1,a2;
        a1=num%10;
        a2=num/10;
        if(a2==0){
            return a1;
        }
        if(a2+a1<10){
            return a1+a2;
        }
        else{
            return 1+a1+a2-10;
        }*/
        
        
        //return 1 + (num-1) % 9;在网上查到这种方法了。自己并没有想出来于是用笨方法又做了一遍
        int n=0,i;
        int[] gewei = new int[20];
        for(i=0;i<20;i++){
            gewei[i]=0;
        }
        int sum=0;
        while(true){
            while(num!=0){
                gewei[n]=num%10;
                num=num/10;
                n++;
            }
            for(i=0;i<n;i++){
                sum = sum+gewei[i];   
            }
            if(sum<10){
                return sum;
            }
            num =sum;
            n=0;
            sum=0;
        }
        
    }
}