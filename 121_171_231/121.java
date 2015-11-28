public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length<2){
            return 0;
        }
        int length = prices.length;
        int i,j,profit=0,min=prices[0];
        for(i=1;i<length;i++){
            if(prices[i]<min){
                min = prices[i];
            }
            else if(prices[i]-min>profit){
                profit = prices[i]-min;
            }
        }
        return profit;
    }
}