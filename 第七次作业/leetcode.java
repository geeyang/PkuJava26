public class leetcode26 {
	public static void main(String[] args)
	{
		int[] nums={1,1,1,2,3,3,4,4};
		System.out.print(removeDuplicates(nums));
	}
	
	public static int removeDuplicates(int[] nums) {
	    int l=nums.length;
	    int i=1,j=0;      //快慢指针：i发现不同元素，j顺次记录
	   
	    while(i<l)
	    {
	    	
	    	if(nums[i]!=nums[i-1])
	    	{
	    		j++;
	    		nums[j]=nums[i];
	    	}
	    	i++;
	    }
	   /* for(i=0;i<l;i++)
	    {
	    	System.out.println(nums[i]);
	    }*/	    
		return j+1;   
	}
	
}