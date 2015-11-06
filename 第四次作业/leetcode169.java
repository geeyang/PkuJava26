public class Solution {
    public int majorityElement(int[] nums) {
        int elem=0;
        int count=0;
        for(int i = 0; i < nums.length; i++)  //每找出两个不同的element，就成对删除即count--，最终剩下的一定就是所求的
        {
             if(count == 0)                 
             {
                 elem = nums[i];
                 count = 1;
             }
             else 
             {
                 if(elem == nums[i])
                     count++;
                 else
                     count--;
             }
         }
         return elem;
        /*int result=nums[0];   //对每个值出现次数计数
        int l=nums.length;
        //int[] count=new int[(l/2)+1];
        int count;
        int i,j;
        if(l==1||l==2)
        {
            return result;
        }
        for(i=0;i<((l/2)+1);i++)
        {
            count=1;
            j=i+1;
            
            while(j<l)//每个while里都必须有个++或者break使之跳出循环，否则死循环，超时
            {
                if(nums[j]==nums[i])
                {
                    count++;
                }
                j++;
            }
            
            if(count>l/2)
            {
                result=nums[i];
                return result;
            }
            
        }
        return result;*/
        /*int i,j,temp;   //排序后取中间值
        int l=nums.length;
        if(l==1||l==2)
        {
            return nums[0];
        }
        for(i=0;i<l-1;i++)
        {
            for(j=i+1;j<l;j++)
            {
                if(nums[i]>nums[j])
                {
                    temp=nums[i];
                    nums[i]=nums[j];
                    nums[j]=temp;
                }
            }
        }
        return nums[(l/2)+1];*/
    }
}