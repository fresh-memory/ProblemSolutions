public class Solution {
    int count=0;
    public int totalNQueens(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
       count=0;
      int[] q = new int[n];
      enumerate(q);
      return count;
    }
    
       boolean isConsistent(int[] q, int n){
         //for all filled rows, decide if q[n] is allowed
         for(int i=0;i<n;i++){
           //same column
           if(q[i]==q[n]) return false;
           //same first diagnal 
           if(q[n]-q[i]==n-i) return false;
           //same second diagnal
           if(q[i]-q[n]==n-i) return false;
         }
           return true;
   }
   
   void enumerate(int[] q){
       
        enumerate(q, 0);
   }
   void enumerate(int[] q, int n){
       
       int len = q.length;
       if(n==len){
           count++;
           return;
       } 
       for(int i =0;i<len;i++){
           q[n]=i;
           if(isConsistent(q,n)){ 
                enumerate(q,n+1);
           }  
       }
       
   }

}
