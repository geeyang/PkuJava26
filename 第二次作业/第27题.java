public class Solution {
    public int removeElement(int[] nums, int val) {
         int length = nums.length;
        int i,j;
        for(i=length-1;i>=0;i--){
        	if(nums[i]==val){
        		for(j=i;j<length-1;j++){
        			nums[j]=nums[j+1];
        		}
        		length--;
        	}
        }
        return length;
    }
}