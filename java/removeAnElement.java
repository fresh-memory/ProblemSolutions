/**
* Similar to string dedup
* Simple should not make any mistakes
* pay attention to corner cases. empty, all, none.
*/

  public int removeElement(int[] A, int elem) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int index=0;
        for(int i=0;i<A.length;i++){
             if(A[i]!=elem){
                 A[index]=A[i];
                 index++;
             }
        }
        return index;
    }


public class Solution {
    public int removeElement(int[] A, int elem) {
            if(A.length==0 || A==null){ return 0;
                
            }
            int start=0;
            
            for(int i=0;i<A.length;i++){
                if(A[i]!=elem){
                    A[start]=A[i];
                    start++;
                }
                
            }
            
        return start;
    }
}
