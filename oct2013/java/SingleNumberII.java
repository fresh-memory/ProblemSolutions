/*
*   Bit operation:
*  This problem applies to a general question:
*  A number occurs once and all other numners occur n times (n can be 2,3,4,5,...n)
*  Consider from the bit, if a number appreas three times, all its binary representation bit will be shown three times
*  If a bit appears three times, it can be crossed off. It does not matter at all if other numbers also have 1 in the same bit
* because it that number appreas three times, this bit will be crossed off again.Otherwise, the number is the one we 
* are looking for.
*
*     Need to pay attention how to use bit vector, how to shit bits to make it as a result base 10;
*/


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
            // don't use pow(2,(31-k)) 
            // it won't work for negative numbers, can cause overflow
              result+=(array[k]%3)<<(31-k);
            }
        }
        return result;
    }
}
