
public class leetcode7 {
	public static void main(String[] args)
	{
		int n=1534236469;
		int m=n;
		int length=0;
		while(m!=0){
			m=m/10;
			length++;
		}
		//System.out.print(length);
		int[] a=new int[length];
		int i;
		if(n>0){
			m=n;
		}else{
			m=-n;
		}
		while(m!=0)
		{
			for(i=0;i<length;i++)
			{
				a[i]=m%10;
				m=m/10;
			}
		}
		/*for(i=0;i<length;i++)
		{
			System.out.print(a[i]);
		}*/
		int start=0;
		for(i=0;i<length;i++)
		{
			if(a[i]!=0)
			{
				start=i;
				break;
			}
		}
		//System.out.print(start);
		long result=0;
		for(i=start;i<length;i++)
		{
			//System.out.print(a[i]);		
				result=(long)(result+a[i]*(long)Math.pow(10,length-1-i));
		}
			
		//System.out.print(result);
		if(n<0){
			result=-result;
		}
		if(result>Integer.MAX_VALUE||result<-Integer.MIN_VALUE){
			System.out.print(0);
		}
			//System.out.print(result);
		
	}
}
