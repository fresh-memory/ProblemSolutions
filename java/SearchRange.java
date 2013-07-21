/*
*
* If find target, still need to find target in two sides 
* Different conditions, merge results.
*
/

public class Solution {
    public int[] searchRange(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
         int len=A.length;
         int start=0, end=len-1;
        
     return helper(A,target, start, end);
     
    }
    
    
    
    public int[] helper(int[] A, int target, int start, int end){
        
        int mid = start+(end-start)/2;
        int[] res = new int[2];
        
        if(start>end){
            res[0]=-1;
            res[1]=-1;
            return res;
        }
        
      //  if(start<=end){
             if(target>A[mid]){
                res= helper(A,target,mid+1,end);
                 
             }
             else if(target< A[mid]){
                res= helper(A, target, start, mid-1);
             }
             
             else {
                 
                 int[] res1= helper(A, target, start, mid-1);
                 int[] res2 = helper(A,target,mid+1,end);
                 if(res1[0]!=-1 && res2[0]!=-1) {
                     res[0]=res1[0];
                     res[1]=res2[1];
                 }
                 
                 if(res1[0]==-1 && res2[0]==-1) {
                     res[0]=mid;
                     res[1]=mid;
                 }
                 
                 if(res1[0]!=-1 && res2[0]==-1){
                     res[0]=res1[0];
                     res[1]=mid;
                 }
                 
                 if(res1[0]==-1 && res2[0]!=-1){
                     res[0]=mid;
                     res[1]=res2[1];
                 }
             }
             
         //}
        return res;
    }
}
