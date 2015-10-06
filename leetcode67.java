import java.util.Scanner;


public class leetcode67 {
	
	public static void main(String[] args)
	{		
	int i;
	int temp;
	Scanner in=new Scanner(System.in);
	String a=in.next();
	String b=in.next();
	int l;
	l=a.length()>b.length()?a.length():b.length();
	
	String[] aa = a.split("");//改成数组
	int[] aaa= new int[l];//改成Int
	for(i=0;i<a.length();i++)
	{
		aaa[i]=Integer.parseInt(aa[i+1]);
	}
	
	String[] bb = b.split("");//改成数组
	int[] bbb= new int[l];
	for(i=0;i<b.length();i++)
	{
		bbb[i]=Integer.parseInt(bb[i+1]);
	}
	
	
	//System.out.print(l);
	
	for(i=0;i<a.length()/2;i++)
	{
		temp=aaa[i];
		aaa[i]=aaa[a.length()-1-i];
		aaa[a.length()-1-i]=temp;
	}
	for(i=0;i<b.length()/2;i++)
	{
		temp=bbb[i];
		bbb[i]=bbb[b.length()-1-i];
		bbb[b.length()-1-i]=temp;
	}
//	System.out.print(bb[1]);
	for(i=1;i<=l;i++)
	{
		//System.out.println(aaa[i]);	
	}
	for(i=1;i<=l;i++)
	{
		//System.out.println(bbb[i]);	
	}
	int[] c=new int[l+1];
	for(i=0;i<l;i++)
	{
		c[i]=aaa[i]+bbb[i];
		
	}
//	System.out.print(bbb[1]);
	for(i=1;i<=l;i++){
	//	System.out.print(c[i]);
	}
	for(i=0;i<l;i++){
		//System.out.print(bbb[i]);
		
		if(c[i]>1)
		{	c[i]=c[i]-2;
			c[i+1]++;
		}
		
	}
	
	String[] cc = new String[l+1]; 
    for(i=0;i<c.length;i++){
    cc[i] = String.valueOf(c[i]); 
    }   
    String cccc= new String();
    for(i=c.length-1;i>=0;i--){
    	cccc+=cc[i];
    }
    if(cccc.charAt(0) == '0'){
    	cccc = cccc.substring(1);
    }
    
    System.out.print(cccc);
    
   /* StringBuffer ccc = new StringBuffer();
    for(i=l;i>0;i--)
    { 
        ccc. append(cc[i]);
    }
    String cccc = ccc.toString();*/
   
	/*for(i=l+1;i>0;i--){
		System.out.print(c[i]);
	}*/
		
	}
}
