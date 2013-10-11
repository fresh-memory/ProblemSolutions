public class Solution {
    public int singleNumber(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int[] array = new int[32];
        int result=0;
        for(int i:A){
            for(int j=31;j>=0;j--){
                array[j] += i&1;
                i = i>>1;
            }
        }
        for(int k=31;k>=0;k--){
            if(array[k]%3!=0){
             // << is better than pow don't need to handle sign  
             result+=(array[k]%3)<<(31-k);
            }
        }
        return result;
    }
}
