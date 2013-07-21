/*
*  recursive+ backtracking
*
*/

public class Solution {
    ArrayList<String[]> rslt;
    public ArrayList<String[]> solveNQueens(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
      rslt = new ArrayList<String[]>(); 
      int[] q = new int[n];
      enumerate(q);
      return rslt;
    
    }
    
    String[] printQueens(int[] q){
        String[] board = new String[q.length];
          for(int i=0;i<q.length;i++){
              String str="";
            for(int j=0;j<q.length;j++){
                if(q[i]==j){
                    str+="Q";
                }
                else{
                    str+=".";
                }
                
            }
            board[i]=str;
          }   
      return board;
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
           String[] board = printQueens(q);   
           rslt.add(board);
           return;
       }

        //for each row, there are len possible placement 
       for(int i =0;i<len;i++){
           q[n]=i;
           if(isConsistent(q,n)){ 
                enumerate(q,n+1);
           }  
       }
       
   }
}
