/*
* Revers a number may cause overflow
* Need to discuss with interviewer about if a negative number can be palindrome number
*    
* Cut the start and end digits until find false or only one digits left.
*
*/
public class Solution {
    public boolean isPalindrome(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(x<0) return false;
        if(x<10 &&x>=0 ) return true;
        int m=1;
        while(x/m>=10){
            m*=10;
        }
       
        while(x>=10){
            int right = x%10;
            int left = x/m;
            if(left!=right) return false;
            x=(x-right-left*m)/10;
            m=m/100;
            
        }
        
        return true;
    }
    
}
