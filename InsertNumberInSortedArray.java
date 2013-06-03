public class Solution {
    public int searchInsert(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return helper(A,target, 0, A.length-1);
    }
    
    
    public int helper(int[] A, int target, int left, int right){
        
        //must have > , e.g., [1,3] 0
        if(left>=right){
            
            if(A[left]<target) return left+1;
            else return left;
           
       }
       
      int mid= left+(right-left)/2;    
      if(target==A[mid]) return  mid;
      else if (target>A[mid]) return helper(A,target, mid+1, right);
      else return helper(A,target,left, mid-1);
      
    }
}
