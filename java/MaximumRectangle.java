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







public class Solution {
    public int largestRectangleArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(height.length==0) return 0;
        Stack<Histo> stk = new Stack<Histo>();
        stk.add(new Histo(height[0],0));
        int max=0, count=0,   finalIndex=0;
        for(int i=1;i<height.length;i++){
            if(height[i]>=stk.peek().h){
            
                stk.add(new Histo(height[i],i));
            }
            else{
                finalIndex=i-1; 
                // don't forget stk.isEmpty()!!!!!!
                while(!stk.isEmpty()&&stk.peek().h>height[i]){
                    Histo obj = stk.pop();
                    int h= obj.h;
                    int index= obj.index;
                    //?
                    int lastIndex=-1;
                    if(!stk.isEmpty()){
                        lastIndex=stk.peek().index;
                    }
                    max=Math.max(max,h*(index-lastIndex)+h*(finalIndex-index));
                }
                //
                //if(stk.size()==0) count=0;
                stk.add(new Histo(height[i],i));
                
            }
        
        }
        if(!stk.isEmpty())
           finalIndex=stk.peek().index;
        while(!stk.isEmpty()){
             Histo obj = stk.pop();
             int h= obj.h;
             int index= obj.index;
             int lastIndex=-1;
             if(!stk.isEmpty()){
                    lastIndex=stk.peek().index;
             }
            max=Math.max(max,h*(index-lastIndex)+h*(finalIndex-index));
            
        }
        
        
        return max;
    }
    
    
    class Histo{
        int h;
        int index;
        Histo(int _height, int _index){
             this.h=_height;
            this.index=_index;
        }
    }
}
