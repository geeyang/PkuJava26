import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class tongji {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println("请输入第一个文件名");
		String a = in.next();
		System.out.println("请输入第二个文件名");
		String b = in.next();
		
		System.out.println("请输入操作：1、统计所有的单词  2、统计重复的单词 3、各自包含单词的总数");
		int n;
		n = in.nextInt();
		switch(n){
		case 1: all(a,b); break;
		case 2:chongfu(a,b,n);break;
		case 3:chongfu(a,b,n);break;
		default: break;
		
		}
		
		
	}
	public static void all(String a,String b){
		String s;
		String sum1="";
		try{
			File first = new File(a);
			FileInputStream firstinput = new FileInputStream(a);
			InputStreamReader isr = new InputStreamReader(firstinput);
			BufferedReader br = new BufferedReader(isr);
			while((s=br.readLine())!=null){
				sum1=sum1+s;
			}
			firstinput.close();
			br.close();
			
			File second = new File(b);
			FileInputStream secondinput = new FileInputStream(b);
			InputStreamReader isrb = new InputStreamReader(secondinput);
			BufferedReader brb = new BufferedReader(isrb);
			while((s=brb.readLine())!=null){
				sum1=sum1+s;
			}
		}catch(IOException e){
			e.printStackTrace();
		}
		/*System.out.println(sum1);*/
		/*for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}*/
		char[] sum = sum1.toCharArray();
		/*for(int m=0;m<sum.length;m++){
			System.out.print(sum[m]);
		}
		System.out.println();*/
		char[][] voca = new char[1000][20];
		int i=0,j=0,n=0;
		int length=0;
		while(n<sum.length){
			if((sum[n]>65&&sum[n]<90)||(sum[n]>97&&sum[n]<122)){
				voca[i][j] = sum[n];
				/*System.out.print(voca[i][j]);*/
				j++;
				n++;
			}
			else{
				while(n<sum.length&&!((sum[n]>65&&sum[n]<90)||(sum[n]>97&&sum[n]<122))){
					n++;
				}if(n<sum.length){
					i++;
					j=0;
				}
				
			}
		}
		length = i+1;  //length一共有多少个单词；
		/*for(i=0;i<length;i++){
			for(j=0;j<voca[i].length;j++){
				System.out.print(voca[i][j]);
			}
			System.out.println();
		}*/
		String[] sum2 = new String[length];
		for(i=0;i<length;i++){
			sum2[i] = String.valueOf(voca[i]);
			/*System.out.println(sum2[i]);*/
		}
		/*System.out.println(sum2[0]);
		System.out.println(sum2[15]);
		if(sum2[0].equals(sum2[15])){
			System.out.println("*");
		}*/
		for(i=0;i<length;i++){
			for(j=i+1;j<length;j++){
				if(sum2[j].equals(sum2[i])){
					for(int m=j;m<length-1;m++){
						sum2[m]=sum2[m+1];
					}
					length--;
				}
			}
		}
		System.out.println("不重复的单词词汇表为:");
		for(i=0;i<length;i++){
			System.out.println(sum2[i]);
		}
	
	}
	public static void chongfu(String a,String b,int caozuo){
		String s;
		String sum1="";
		String sum2="";
		try{
			File first = new File(a);
			FileInputStream firstinput = new FileInputStream(a);
			InputStreamReader isr = new InputStreamReader(firstinput);
			BufferedReader br = new BufferedReader(isr);
			while((s=br.readLine())!=null){
				sum1=sum1+s;
			}
			firstinput.close();
			br.close();
			
			File second = new File(b);
			FileInputStream secondinput = new FileInputStream(b);
			InputStreamReader isrb = new InputStreamReader(secondinput);
			BufferedReader brb = new BufferedReader(isrb);
			while((s=brb.readLine())!=null){
				sum2=sum2+s;
			}
		}catch(IOException e){
			e.printStackTrace();
		}
		char[] char1 = sum1.toCharArray();
		char[] char2 = sum2.toCharArray();
		
		char[][] voca1 = new char[1000][20];
		char[][] voca2 = new char[1000][20];
		int i=0,j=0,n=0;
		int length1=0,length2=0;
		while(n<char1.length){
			if((char1[n]>65&&char1[n]<90)||(char1[n]>97&&char1[n]<122)){
				voca1[i][j] = char1[n];
				j++;
				n++;
			}
			else{
				while(n<char1.length&&!((char1[n]>65&&char1[n]<90)||(char1[n]>97&&char1[n]<122))){
					n++;
				}if(n<char1.length){
					i++;
					j=0;
				}
				
			}
		}
		length1 = i+1;  
		n=0;i=0;j=0;
		while(n<char2.length){
			if((char2[n]>65&&char2[n]<90)||(char2[n]>97&&char2[n]<122)){
				voca2[i][j] = char2[n];
				j++;
				n++;
			}
			else{
				while(n<char2.length&&!((char2[n]>65&&char2[n]<90)||(char2[n]>97&&char2[n]<122))){
					n++;
				}
				if(n<char2.length){
					i++;
					j=0;
				}
			}
		}
		length2 = i+1; 
		String[] s1 = new String[length1];
		for(i=0;i<length1;i++){
			s1[i] = String.valueOf(voca1[i]);
		}
		for(i=0;i<length1;i++){
			for(j=i+1;j<length1;j++){
				if(s1[j].equals(s1[i])){
					for(int m=j;m<length1-1;m++){
						s1[m]=s1[m+1];
					}
					length1--;
				}
			}
		}
		
		String[] s2 = new String[length2];
		for(i=0;i<length2;i++){
			s2[i] = String.valueOf(voca2[i]);
		}
		for(i=0;i<length2;i++){
			for(j=i+1;j<length2;j++){
				if(s2[j].equals(s2[i])){
					for(int m=j;m<length2-1;m++){
						s2[m]=s2[m+1];
					}
					length2--;
				}
			}
		}
		String[] repeat = new String[length1];
		n=0;
		for(i=0;i<length1;i++){
			repeat[i]="";
		}
		for(i=0;i<length1;i++){
			for(j=0;j<length2;j++){
				if(s1[i].equals(s2[j])){
					boolean isexist=false;
					if(repeat.length==0){
						repeat[n]=s1[i];
						n++;
					}else{
						for(int m=0;m<repeat.length;m++){
							if(repeat[m].equals(s1[i])){
								isexist =true;
							}
						}
						if(!isexist){
							repeat[n] = s1[i];
							n++;
						}
					}
				}
			}
		}
		int num = n;
		if(caozuo==2){
			System.out.println("重复的单词为：");
			for(i=0;i<num;i++){
				System.out.println(repeat[i]);
			}
		}
		if(caozuo==3){
			double baifenbi1 = (double)(Math.round(num*1000/length1)/1000);;
			double baifenbi2 = (double)(Math.round(num*100/length2)/1000);
			System.out.println("第一个文件中单词个数为："+length1+" 重复比为："+(float)num/length1*100);
			System.out.println("第一个文件中单词个数为："+length2+" 重复比为："+(float)num/length2*100);
		}
		
	}
	
}
