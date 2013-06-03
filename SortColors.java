/*
*
* Initialize the s,m as 0 and e as len-1
* s tracks the index to fill 0, m tracks the index to fill 1 and e tracks 2
/

public class Solution {
    public void sortColors(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
     
     int len=A.length;
    
    int m=0,s=0,e=len-1;
    int temp=0;
    while(m<=e){
         if(A[m]==1){
          m++;   
         }
         
         else if(A[m]==0){
             temp= A[m];
             A[m]=A[s];
             A[s]=temp;
             s++;
             //m can advance as A[s] always smaller than or equal to A[m]
             m++;
         }
         //A[m]==2
         else {
             temp=A[m];
             A[m]=A[e];
             A[e]=temp;
             e--;
             //m++;
             // m cannot advance as A[e] may be smaller than 1 (0)
         }
         
         
     }
     
    }
}
