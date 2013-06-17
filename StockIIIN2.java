/*
* Failed large case
*
*/

public class Solution {
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
      int max=0;
      int rightmax=0;
      if(prices.length<2 || prices==null) return 0;
      for(int i=1;i<prices.length;i++){
          int leftmax=maxHelper(prices,0,i);
          if(i+1<prices.length){
            rightmax=maxHelper(prices,i+1, prices.length-1);
          }
         max=Math.max(max,leftmax+rightmax);
          
      }
      
      return max;
      
    }
    
    
    public int maxHelper(int[] prices, int left, int right){
        //must have
        if(left>=right) return 0;
        int maxval=0;
        int max=prices[left];
        int min=prices[left];
       for(int i=left;i<=right;i++){ 
        if(prices[i]>max){
         max=prices[i];   
        }
        if(prices[i]<min){
          min=prices[i];
          max=min;
        }
        if(max-min>maxval){
            maxval=max-min;
        }
        
       }
       return maxval;
    }
}
