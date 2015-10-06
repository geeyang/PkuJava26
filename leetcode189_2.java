
public class leetcode189_2 {
	public static void main(String[] args){
		int k=2;
		int[] nums={1,2,3};
		rotate(nums,k);
	}
	public static void rotate(int[] nums, int k) {
		int n=nums.length;
		int i;
		int temp;
		k=k%n;
		for(i=0;i<n/2;i++)
		{
			temp=nums[i];
			nums[i]=nums[n-1-i];
			nums[n-1-i]=temp;	
		}
		for(i=0;i<k/2;i++){
			temp=nums[i];
			nums[i]=nums[k-1-i];
			nums[k-1-i]=temp;	
			//System.out.println(nums[i]);
		}
		for(i=k;i<k+(n-k)/2;i++){
			temp=nums[i];
			nums[i]=nums[n+k-1-i];
			nums[n+k-1-i]=temp;	
			//System.out.println(nums[i]);
		}
		for(i=0;i<n;i++)
		{
		System.out.print(nums[i]);
		}
	}
}
