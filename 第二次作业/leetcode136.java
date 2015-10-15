import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class leetcode136 {
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		/*List<Integer> array = new ArrayList<Integer>();
		while(in.hasNext()){
		    array.add(in.nextInt());}
		// 打印array
		for(Integer i: array){
		    System.out.println(i);
		}*/
		int i;
		int []a=new int[5];
		for(i=0;i<a.length;i++){
			a[i]=in.nextInt();
		}
		
		System.out.println(singleNumber(a));
		
	}
	public static int singleNumber(int[] nums) {
		
        int i,j;
        int result=0;
        //boolean b=false;
        if(nums.length==1)
        {
            return nums[0];
        }
        for(i=0;i<nums.length;i++)
        {
        	for(j=i+1;j<nums.length;j++)
            {
            	if(nums[i]==nums[j])
                {
                	nums[i]=0;
                	nums[j]=0;
                }
            }
        }
        for(i=0;i<nums.length;i++)
        {
        	if(nums[i]!=0)
        	{
        		result=nums[i];
        	}
        }
        return result;
       /*最简便的方法：：：
        * int i,xor;
        for(xor = 0,i = 0;i < nums.length;++i)
            xor=xor ^ nums[i];
        	return xor;
        */
        /*for(i=0;i<nums.length;i++)
        {
            b=false;
        	for(j=i+1;j<nums.length;j++)
            {
            	if(nums[i]==nums[j])
                {
                	b=true;
                }
            }
            if(b)
            {
            	continue;
            
            }
            result=nums[i];
            break;
        }*/
        
        
        /*int temp;
        for(i=0;i<nums.length;i++)
        {
        	for(j=i+1;j<nums.length;j++){
        		if(nums[i]>nums[j])
        		{
        			temp=nums[i];
        			nums[i]=nums[j];
        			nums[j]=temp;
        		}
        	}
        }
        
        	//System.out.print(nums.length);
     
        for(i=1;i<nums.length-1;i++)
        {
        	if(nums[i]!=nums[i+1]&&nums[i]!=nums[i-1])
        	{
        		result=nums[i];
        		//break;
        	}
        }
        if(nums[0]!=nums[1]){
        	result=nums[0];
        }
        else if(nums[nums.length-1]!=nums[nums.length-2]){
        	result=nums[nums.length-1];
        }*/
    }
}
