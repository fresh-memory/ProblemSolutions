/*
* duplicate
* 1131 as special case 
* find the sure case else recursive the other part...
*/
public class Solution {
    public boolean search(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        
     return help(A,target,0,A.length-1);    
        
    }
    
    
    public boolean help(int[] A, int target, int left, int right){
        
        if(left>right) return false;
        int mid=left+(right-left)/2;
        
        if(A[mid]==target) return true;
        if(A[mid]>A[right]){
          if(target<=A[mid] && target>=A[left]){
            return  help(A,target,left,mid-1);
          }
          else{
                  return help(A,target,mid+1,right);
          }
        }
        //11131
        else if (A[mid]==A[right]){
           
            return help(A,target,left,mid-1)||help(A,target, mid+1,right);
         }
        else{
          //a[mid]<A[right]
         if(target<=A[right] && target>A[mid]){
                 return help(A,target,mid+1,right);
   
         }
         else return help(A,target, left,mid-1);
         
        }
        
    }
    
    
}
