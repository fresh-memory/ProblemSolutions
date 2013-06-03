public class Solution {
    public boolean canJump(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
       int max=0;
       
       for(int i=0;i<A.length;i++){
           
           if(max<i) return false;
       
        int nmax=i+A[i];
        if(nmax>max) max=nmax;
       
       }
       
       return true;
    }
}
