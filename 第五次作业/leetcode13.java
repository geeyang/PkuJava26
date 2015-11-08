public class Solution {
    public int romanToInt(String s) {
	 /*1~9: {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        10~90: {"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};

        100~900: {"C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};

        1000~3000: {"M", "MM", "MMM"}.*/
     char[] ss=s.toCharArray();
     int ret = toNumber(ss[0]);  
        for (int i = 1; i < ss.length; i++) {  
            if (toNumber(ss[i - 1]) < toNumber(ss[i])) {  
                ret += toNumber(ss[i]) - 2 * toNumber(ss[i - 1]);  
            } else {  
                ret += toNumber(ss[i]);  
            }  
        }  
        return ret;  
    }  
      
    int toNumber(char ch) {  
        switch (ch) {  
            case 'I': return 1;  
            case 'V': return 5;  
            case 'X': return 10;  
            case 'L': return 50;  
            case 'C': return 100;  
            case 'D': return 500;  
            case 'M': return 1000;  
        }  
        return 0;    
    }
}