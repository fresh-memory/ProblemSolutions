/**
*
* Becareful about special condition
* Also the code need to be neat!!!
*
/

public class Solution {
    public int removeDuplicates(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int length=A.length;
        if(length<2) return length;
        int cur=1;
   
        while(cur<length && A[cur]!=A[cur-1]) cur++; 
        if(cur==length) return length;
        for(int j=cur+1;j<length;j++){
            //A[j]!=A[j-1]
            if(A[j]==A[cur] || A[j]==A[j-1]){continue;}
            else 
              A[cur++]=A[j];
            }
            A[cur]='\0';
         return cur;   
    }
}
