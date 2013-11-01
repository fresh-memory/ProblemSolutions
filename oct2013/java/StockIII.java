public class Solution {
   /**
   *   exchange space for time:
   * left -> right scan    maintain an array up to index i, what is the maxprofit
   * right -> left scan                       from index i to end, what is the maxprofit    
   *      compare max with  sum of (left[i] + right[i])
   * / 

  //Esentially DP     (space for time, have array to store intermediate results)
    public int maxProfit(int[] prices) {
    /**    // Note: The Solution object is instantiated only once and is reused by each test case.
        int max=0;
        for(int i=0;i<prices.length;i++) {
             int tempMax = maxProfitI(prices, 0,i)+maxProfitI(prices, i, prices.length-1); 
             if(tempMax>max) max = tempMax;
        }
        
        return max;
    }
    
    public int maxProfitI(int[] prices, int start, int end){
        int min = prices[start];
        int max=0;
        for(int i=start+1;i<=end;i++) {
            if(prices[i]>min){
                max=Math.max(max, prices[i]-min);
            }
            else {
                min = prices[i];
            }
        }
        return max;
    }
    
    **/
    int len = prices.length;
    if(len<2) return 0;
    int min=prices[0], max=prices[prices.length-1];
    int maxProfit=0;
    int[] left  = new int[prices.length];
    int[] right = new int[prices.length];
    for(int i=0;i<prices.length;i++){
        if(prices[i]<min){
            min=prices[i];
            left[i]=maxProfit;
        }
        else{
            maxProfit=Math.max(maxProfit,prices[i]-min);
            left[i]=maxProfit;
        }
    }
    maxProfit=0;
    for(int j=prices.length-1;j>=0;j--) {
        if(prices[j]>max){
            max=prices[j];
            right[j]=maxProfit;
        }
        else{
            maxProfit = Math.max(maxProfit, max-prices[j]);
            right[j]=maxProfit;
        }
    }
    maxProfit=0;
    for(int m=0;m<prices.length;m++){
        maxProfit = Math.max(maxProfit, left[m]+right[m]);
    }
    return maxProfit;
 }
}
