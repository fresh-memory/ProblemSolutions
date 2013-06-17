/*
*
* left to right to get max up to i
* right to left to get max from i to rightmost
*
*
*/

public class Solution {
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
   if(prices.length<2 || prices==null) return 0;
   
   int[] arr1 =  new int[prices.length];  
   int[] arr2 = new int[prices.length];
   int min =prices[0];
    //The logic should be this simple... do not need to keep track min max value seen so far
   for(int i=1;i<prices.length;i++){
        min=Math.min(prices[i],min);
        arr1[i]=Math.max(arr1[i-1], prices[i]-min);
    } 
   
   int max=prices[prices.length-1];
   for(int j=prices.length-2;j>=0;j--){
       max=Math.max(prices[j], max);
       arr2[j]=Math.max(max-prices[j], arr2[j+1]);
   }
   
   int maxval=0;
   for(int i=0;i<prices.length;i++){
       maxval=Math.max(arr1[i]+arr2[i],maxval);
   }
   
   return maxval;
   
   }
    
}
