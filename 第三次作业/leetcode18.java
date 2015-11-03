public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int i,j,m,n;
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        for(i=0;i<nums.length-1;i++)
        {
            for(j=i+1;j<nums.length;j++)
            {
                if(nums[i]>nums[j])
                {
                    m=nums[i];
                    nums[i]=nums[j];
                    nums[j]=m;
                }
            }
        }
        for(i=0;i<nums.length-3;i++)
        {
            
            for(j=i+1;j<nums.length-2;j++)
            {
                
                m=j+1;
                n=nums.length-1;
                while(m<n)
                {
                    if(nums[m]+nums[n]==target-nums[i]-nums[j])
                    {
                        List<Integer> row=new ArrayList<Integer>();
                        row.add(nums[i]);
                        row.add(nums[j]);
                        row.add(nums[m]);
                        row.add(nums[n]);
                        result.add(row);
                        while(nums[n]==nums[n-1]&&n<nums.length&&n>m)//几个判重复的while都需要再加一次范围否则就越界
                        {
                            n--;
                        }
                        while(nums[m]==nums[m+1]&&m+1<nums.length-1)
                        {
                            m++;
                        }
                        m++;
                    }else if(nums[m]+nums[n]>target-nums[i]-nums[j])
                    {
                        n--;
                        
                    }else if(nums[m]+nums[n]<target-nums[i]-nums[j])
                    {
                        m++;
                        
                    }
                    
                }
                while(nums[j]==nums[j+1]&&j<nums.length-2)//若放在此循环体前面发现0000输出不了，需要先输出再忽视重复的
                {
                    j++;
                }
                
            }
            while(nums[i]==nums[i+1]&&i<nums.length-3)
            {
                    i++;
            }
        }
        return result;
    }
}