/*
*   Ideas id to find which side is roated and compare target with nonrotated range then decide which side to search
*
*
/
public class Solution {
    public int search(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return helper(A,target,0,A.length-1);
    }
    
    
    public int helper(int[] A, int target, int left, int right){
         
         if(left>right) return -1;
         int mid=left+(right-left)/2;
         if(A[mid]==target) return mid;
         if(A[left]>A[mid]){
             if(target>A[mid] &&target<=A[right])
                return helper(A,target,mid+1, right);
             else
                 return helper(A,target,left, mid-1);
         }
         else{
         //if(A[mid]>A[right]) rotated in the right or neihter left nor right rotated
             if(target<A[mid] && target>=A[left])
                 return helper(A,target, left, mid-1);
             else 
             return helper(A,target, mid+1,right);
         }
    }
    
    
}

