import java.util.*;
public class leetcode263_2 {
	public static void main(String[] args){
		int num=210;
		
		if(num==0){
			System.out.println("");
		}
		while(num%2==0){
			num=num/2;
		}
		while(num%3==0){
			num=num/3;
		}
		while(num%5==0){
			num=num/5;
		}
		if(num!=1){
			System.out.println("not ugly number");
		}
	}
}
