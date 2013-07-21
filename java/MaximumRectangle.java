/*
*
* Stack store index 
* similar to longest parenthesis
*
*
*/

public class Solution {
    public int largestRectangleArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
         int max=0;
         if(height.length<1) return 0;
         Stack<Integer> stk = new Stack<Integer>();
         stk.push(0);
         int index=1;
         while(index<height.length){
            
            if(stk.isEmpty() || height[index]>=height[stk.peek()]){
                    stk.push(index++);
            }
            else{
                    int pos =stk.pop();
                    int width = stk.isEmpty()?index: index-stk.peek()-1;
                    max=Math.max(max, width*height[pos]);
            
            }
         }    
           
            while(!stk.isEmpty()){
            
                    int pos =stk.pop();
                    int width = stk.isEmpty()?index: index-stk.peek()-1;
                    max=Math.max(max, width*height[pos]);
            
            }
       return max;
    }
}
