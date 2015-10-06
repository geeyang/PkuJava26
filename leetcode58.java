import java.util.Scanner;
public class leetcode58 {
	public static void main(String[] args)
	{
		Scanner in=new Scanner(System.in);
		String a=in.nextLine();
		System.out.print(lengthOfLastWord(a));
	}
	public static int lengthOfLastWord(String a) {
		if(a.trim().isEmpty()){
			return 0;
		}
        String[] aa = a.split(" ");//改成数组
        return aa[aa.length-1].length();
    }
}
