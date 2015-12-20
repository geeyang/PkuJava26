public class Solution {
    public int trailingZeroes(int n) {
  
        /* int m=n;
    int i=0;
    int count=0;
    int counttwo=0;
    int countfive=0;
    while(m!=0)
    {
        if(m%10==0)
        {
            count++;
        }else if(m%5==0)
        {
            countfive++;
        }else if(m%2==0)
        {
            counttwo++;
        }
        m--;
    }
    //count+=MIN(counttwo,countfive);
    if(counttwo>countfive)
    {
        count+=countfive;
    }else
    {
        count+=counttwo;
    }*/
        int m=n;
        int count=0;
        while(m!=0){
            m=m/5;
            count+=m;
        }
        return count;
       
    }
}