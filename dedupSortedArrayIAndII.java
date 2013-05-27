/**
* The idea is using cur to track the cell to be filled and j to select the element to fill the cur cell.
* cur initilized to the first pos to be changed and then advance 1 pos at a time
* j should find the element not the same as the one it previously sent to cur.
* dedup array I and II or very similar

* Only differs by cur-1, cur-2
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
        // redundent ---  if(cur==length) return length;
        for(int j=cur+1;j<length;j++){
            //A[j]!=A[j-1]
              // should use if (A[j]==A[cur-1]), it is more clear
              // if j sent the an number before, j should avoid sending the number again 
              // see II 
            if(A[j]==A[cur] || A[j]==A[j-1]){continue;}
            else 
              A[cur++]=A[j];
            }
        // A[cur]='\0';
         return cur;   
    }





    public int removeDuplicatesII(int[] A) {
        int length = A.length;
        if(length<3) return length;
        int cur=2;
        while(cur<length && A[cur]!=A[cur-2]) cur++;
        for(int j=cur+1;j<length;j++){
            if(A[j]==A[cur-2]) {continue;}
            A[cur++]=A[j];
       }
      // A[cur]='\0'; not needed otherwise causing indexoutofbound exception
       return cur;
}
}
