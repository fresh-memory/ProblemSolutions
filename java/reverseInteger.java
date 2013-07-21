/**
 *  710 =>71
 *   overflow???
 */
public class Solution {
    public int reverse(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
    
       
       int mod=1,res=0;
       int y=x;
       if(x<0) y=-x;
       while(y!=0){
           
           mod= y % 10;
           res=res*10+mod;
           y=y/10;
       }
       
       if(x<0) return -1*res;
       return res;
    }
}
