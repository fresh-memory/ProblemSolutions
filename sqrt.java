 public static int sqrt(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        float left=0, right=x;
        float y=0;
        double epsi=0.001;
        while((x-y)>epsi){
            if(x/y==y)
                return (int) y;
            else if(x/y>y){
                left=y;
            }
            else 
                right=y;
            y=(left+right)/2;
        }
        
        return (int) y;
/**
* The quickest way is newton's method based on f(x1)=x1^2-x2=0
* Then progam according to the formula
* This implementation is based on  binary-search 
*/
