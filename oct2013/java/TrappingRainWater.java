/**   scan array find the max bar
* scan from left to max bar, keep maining left side max as scan to the max bar, any bar shorter than the left max can 
* trap water by (A[leftmax] -A[current])
*
*Similar to the right side, any bar shorter than right max can trap water 
*Because the max bar and leftmax (or rightmax) guarantee two boundries.
*/


public class Solution {
    public int trap(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int max = 0, water = 0;
        for(int i = 0; i < A.length; i++) {
            if(A[i]>A[max]){
                max=i;
            }
        }
        
        int leftMax=0;
        for(int i=0;i<max;i++){
            if(A[i]<=A[leftMax]){
                water+=A[leftMax]-A[i];
            }
            else {
                leftMax=i;
            }
        }
        int rightMax=A.length-1;
        for(int i=A.length-1;i>max;i--){
            if(A[i]>A[rightMax]) {
                rightMax=i;
            }
            else {
                water+=A[rightMax]-A[i];
            }
        }
        return water;
    }
}
