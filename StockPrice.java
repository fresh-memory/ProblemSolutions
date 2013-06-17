public class Solution {
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        //need to have
        if(prices.length==0) return 0;
        int min=prices[0];
        int max=prices[0];
        int maxValue=0;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<min){
                min=prices[i];
                max=prices[i];
            }
            
            if(prices[i]>max){
                max= prices[i];
            }
            
                if(max-min >maxValue){
                    maxValue=max-min;
                }
        }
        return maxValue;
    }
}
