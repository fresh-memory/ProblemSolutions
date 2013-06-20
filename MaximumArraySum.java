public class Solution {
    public int maxSubArray(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
    
        int sum=A[0], min=A[0],max=A[0];
        
        for(int index=1;index<A.length;index++){
            
            sum+=A[index];
            if(min<0){
              max=Math.max(max, sum-min);
            }
            // be careful about when min is positive
            else max=Math.max(max, sum);
            if(sum<min){
                min=sum;
            }
        }
        return max;
    }
}
