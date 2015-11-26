public class Solution {
    public boolean containsDuplicate(int[] nums) {
        int i=0,j=0,l=nums.length;
        boolean res=false;
        Arrays.sort(nums);
        for(i=1;i<l;i++)
        {
            if(nums[i]==nums[i-1])
            {
                return true;
            }
        }
        /*while(i<l-1)
        {
            for(j=i+1;j<l;j++)
            {
                 if(nums[j]==nums[i])
                {
                    return true;
                }
            }
            i++;
        }*/
        
        return res;
    }
}