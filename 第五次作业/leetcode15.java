public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
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
       
            
            for(j=0;j<nums.length-2;j++)
            {
                
                m=j+1;
                n=nums.length-1;
                while(m<n)
                {
                    if(nums[m]+nums[n]==-nums[j])
                    {
                        List<Integer> row=new ArrayList<Integer>();

                        row.add(nums[j]);
                        row.add(nums[m]);
                        row.add(nums[n]);
                        result.add(row);
                        while(nums[n]==nums[n-1]&&n<nums.length&&n>m)//�������ظ���while����Ҫ�ټ�һ�η�Χ�����Խ��
                        {
                            n--;
                        }
                        while(nums[m]==nums[m+1]&&m+1<nums.length-1)
                        {
                            m++;
                        }
                        m++;
                    }else if(nums[m]+nums[n]>-nums[j])
                    {
                        n--;
                        
                    }else if(nums[m]+nums[n]<-nums[j])
                    {
                        m++;
                        
                    }
                    
                }
                while(nums[j]==nums[j+1]&&j<nums.length-2)//�����ڴ�ѭ����ǰ�淢��0000������ˣ���Ҫ������ٺ����ظ���
                {
                    j++;
                }
                
            }
          
        return result;
    }
}