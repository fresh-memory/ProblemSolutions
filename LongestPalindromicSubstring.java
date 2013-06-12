/*  O(N2) solution. There exists O(N) solution...
*  Expand to two sides
*  Note there are 2N-1 center!!!!!!! As it could be even palindrom or odd palindrom.
*/

public class Solution {
    public String longestPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int lens=s.length();
        if(lens<2 ) return s; 
        int max = Integer.MIN_VALUE;
        int left=0, right=0;
        String res = "";
        for(int i=0;i<lens;i++){
            //2*lens-1 center as the center could be in the middle of two letters
            left=i-1;
            right=i+1;
            while(left>=0 && right<lens && s.charAt(left)==s.charAt(right)){
                left--;
                right++;
            }
            int len = right-left-1;
            if(len>max) {
                max=len;
             res = s.substring(left+1, right);
            
            }
            left=i-1;
            right=i;
            while(left>=0 && right<lens && s.charAt(left)==s.charAt(right)){
                left--;
                right++;
            }
            
            len = right-left-1;
            if(len>max){
                max=len;
            
            res = s.substring(left+1, right);
            }
        
        }
       
        return res;
    }
}
