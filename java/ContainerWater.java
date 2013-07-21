/**
 *   Three solutions: O(N2) O(NlogN) O(N)
 *   iteratively go through pairwise combo/ sort search furthest/ greedyly move shorter bar 
 *
 *   This problem only let you select two bars to form a container, when you select two bars you don't need to 
 *  care about the rest bars......
 *
 */
public class Solution {
    public int maxArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int left=0, right= height.length-1;int area =0;
        int max=Integer.MIN_VALUE;
        while(left<right){
            if(height[left] > height[right]){
              //move right bar
             area = (right-left)*height[right];
             if(area>max) max=area;
             right --;
            }
            
            else{
                //move left bar
             area = (right-left)*height[left];
             if(area>max) max=area;
               left ++;
            }
                
            }
            
            return max;
        }
        
}    
    
