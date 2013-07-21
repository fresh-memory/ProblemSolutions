/*
*
* Greedy
* As long as have profit, sell
*
*/
public class Solution {
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        //need to have
        if(prices.length==0) return 0;
        int profit=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>prices[i-1]){
                profit+=prices[i]-prices[i-1];
            }
        }
     return profit;  
  }

}
