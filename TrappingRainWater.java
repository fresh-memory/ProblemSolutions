/*
*
* find leftMax and right max, water+=min(leftMax , rightMax) -A[current]
* first pass find the max height bar, remember the index
* then from left to Max index, water+=leftMax-A[Current]
* then from right to Max index, water+=rightMax-A[Current]
*/

public class Solution {
    public int trap(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len=A.length;
        if(len<3){ return 0;}
        int max=0;
        
        
        for(int i=0;i<len;i++){
            if(A[i]>A[max]){
                max=i;
               
            }
        }
        int leftMax=A[0], water=0;
        for(int x=0;x<max;x++){
            if(leftMax>A[x]){
                water+=leftMax-A[x];
            }
            else{
                leftMax=A[x];
            }
            
        }
        
        leftMax=A[len-1];
        for(int j=len-1;j>max;j--){
            if(leftMax>A[j]) water+=leftMax-A[j];
            else leftMax=A[j];
            
        }
        return water;
    }
}
