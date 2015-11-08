public class Solution {
    public String intToRoman(int num) {
         String[][] roman = {  
            {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},  //1~9
            {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},  //10~90
            {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},  //100~900
            {"", "M", "MM", "MMM"}                                         //1000~3000
        };  
        String result="";
        int digit=0;
        while (num != 0) {  
            int remain = num % 10;  
            result = roman[digit][remain] + result;  
            digit++;  
            num /= 10;  
        } 
        return result;
        
    }
}