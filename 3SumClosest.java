/**
*  O(n^2)
* 
*/
public class Solution {
    public int threeSumClosest(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
       Arrays.sort(num);
       int closest=num[0]+num[1]+num[2];
       int len = num.length;
       for(int i=0;i<len-2;i++){
            //speed up
            if(i>=1 && num[i]==num[i-1]) continue;
               // optimize
               int left=i+1;
               int right=len-1;
             while(left<right){
             int sum = num[i]+num[left]+num[right];
             if(sum==target) return sum;
             closest = Math.abs(target-sum)<Math.abs(target-closest)? sum:closest;
             if(sum<target) left++;
             else right--;
         
           }
       }
       return closest;
    }
}
