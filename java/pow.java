/** Recursive 
*  formula for odd/even number and pos/neg number
* store half = pow(x,y/2) as optimization 
**
/

public class Solution {
    public double pow(double x, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(n==0) return 1;
        double half = pow(x,n/2);
        if(n%2==0){
            return half*half;
            }
        if(n>0){
                return half*half*x;
        }
        else{ //n<0
        return half*half/x;
        
        }
        
        
        
    }
}
