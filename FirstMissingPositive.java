/*
*  make positive number i available at index i-1, check if A[i] ==i+1
*
*
/

public class Solution {
    public int firstMissingPositive(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len=A.length;
        if(len==0) return 1;
        for(int i=0;i<len;i++){
            
            //need to prevent index out of bound exception- A[i]-1<len
            while(A[i]>=1 &&A[i]-1<len && A[A[i]-1]!=A[i] ){
                int temp=A[A[i]-1];
                A[A[i]-1]=A[i];
                A[i]=temp;
            }
        }
        
        for(int i=0;i<len;i++){
          if(A[i]!=i+1) return i+1;   
        }
        
        return A[len-1]+1;
    }
}
