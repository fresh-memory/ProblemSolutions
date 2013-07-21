/*
*  pass small test 
* fail large test
*
*
*/


public class Solution {
    public int longestConsecutive(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        HashSet<Integer> hs = new HashSet<Integer>();
        int length=num.length;
        for(int i=0;i<length;i++){
            hs.add(num[i]);
        }
        
        int counter; int max=Integer.MIN_VALUE;
        for(int j=0;j<length;j++){
            int curr=num[j];
            counter=1;
            while(hs.contains(curr-1)){
                counter++;
                curr--;
            }
            
            curr=num[j];
            while(hs.contains(curr+1)){
                counter++;
                curr++;
            }
            if(counter>max){
                max=counter;
            }
            
        }
        
        return max;
        
        
    }
}
