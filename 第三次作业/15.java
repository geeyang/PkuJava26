public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> numbers = new ArrayList<List<Integer>>();
        
        int t;int target;
        int length = nums.length;
        for(int i=0;i<length;i++){
            for(int j=0;j<length-i-1;j++){
                if(nums[j]>nums[j+1]){
                    t= nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=t;
                }
            }
        }
        int i,j,k;
        for(i=0;i<length-2;i++){
            if(nums[i]>0){
                break;
            }
            if(i==0||nums[i]!=nums[i-1]){
                target = 0-nums[i];
                
                
                for(j=i+1;j<length-1;j++){
                    for(k=i+2;k<length;k++){
                        if(nums[j]+nums[k]==target){
                            List<Integer> num = new ArrayList<Integer>();
                            num.add(nums[i]);
                            num.add(nums[j]);
                            num.add(nums[k]);
                            numbers.add(num);
                        }
                    }
                }
            }
        }
        return numbers;
    }
}