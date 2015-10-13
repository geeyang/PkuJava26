public class Solution {
    public int[] twoSum(int[] number, int target) {
		int i,j=0;
		
		int n=number.length;
		int[] jieguo = new int[2];
		if(number.length==0){
		    return jieguo;
		}
		for(i=0;i<2;i++){
			jieguo[i] = 0;
		}
		
		for(i=0;i<n;i++){
				for(j=i+1;j<n;j++){
					if(number[i]+number[j]==target){
							jieguo[0]=i+1;
		                    jieguo[1]=j+1;
		
	                    	return jieguo;
					}
				}
			
		}
	
		return jieguo;
    }
}