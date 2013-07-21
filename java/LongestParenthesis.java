/*
*  Stack for index of left parenthesis
*  lastIndex tracks the new start of possible matches (start over point)
* 
*/

public class Solution {
    public int longestValidParentheses(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int max=0;
        int left=0, lastIndex=-1;
        Stack<Integer> stk = new Stack<Integer>();
        for(int i=0;i<s.length();i++){
           if(s.charAt(i)=='('){
              stk.push(i);
           }
           else{
               if(!stk.isEmpty()){
                   stk.pop();
                     if(stk.isEmpty()){
                           max= Math.max(max,i-lastIndex);
                      }
                    else{
                          max=Math.max(max,i-stk.peek());
                     }
               
              }
              else{
                  lastIndex=i;
              }
        } 
    }
     return max;
    }
}
