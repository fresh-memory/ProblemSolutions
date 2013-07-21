/*
*
*  Just iterate once through the array
*  last and max tracks how far current number of steps can reach and how far current-1 number of steps can reach
*
*/

public class Solution {
    public int jump(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len=A.length;
        int max=0, last=0,cursteps=0;
        
        
        for(int i=0;i<len;i++){
            //unreachable 
            if(i>max) return -1;
           
           // last # of steps cannot reach here but steps+1 can
            if(i>last){
                
                last =max;
                cursteps++;
            }
        
              //keeps tracking in the current number of steps, how far can be reached
              int nmax=i+A[i];
              if(nmax>max) max=nmax;
        
        }
        
       return steps;    
        
    }
}

