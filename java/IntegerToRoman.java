/**
*
*  come up the string with frequent numbers
* 
/


public class Solution {
    public String intToRoman(int num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int index=0;
        StringBuilder st = new StringBuilder();
        while(num>0){
            
            int times=num/nums[index];
            for(int i=times;i>0;i--){
                st.append(symbols[index]);
            }
            
            num=num-times*nums[index];
            index++;
        }
    
       return st.toString();
    
    }
    
}
