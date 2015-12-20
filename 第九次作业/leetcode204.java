public class Solution {
    public int countPrimes(int n) 
    {
         boolean[] a = new boolean[n];  //起初全置为false，即质数
         for(int i=2; i*i<n; i++) {  
         if(!a[i]) {                   //若a[i]质数，则n以内大于i的倍数全置为true
            for(int j=i; i*j<n; j++) {  
                a[i*j] = true;  
            }  
        }  
     }  
     int c=0;  
     for(int i=2; i<n; i++) {  
         if(a[i] == false) ++c;  
     }  
     return c;  
       /* if(n==2)
        {
            return 1;
        }
        int i;
        int count=1;
        for(i=3;i<=n;i++)
        {
            if(isPrime(i))
            {
                count++;
            }
            i++;
        }
         return count;
    }
        public boolean isPrime(int m){
        int i;
        boolean flag = true;
        for(i=2;i<Math.sqrt(m);i++){
          if((m%i)==0){
            flag = false;
            break;
            }
        }
        return flag;*/
        }
}