public int sqrt(int x) {
	    	double epsi = 0.00001;
	    	double target = x/2;
	    	double sq = target*target;
	    	double left=0;
	    	double right = x;
            //special
            if(x==1) return 1;
	    	while(Math.abs(x-sq)>epsi){
	    		if(x-sq>0){
                    left=target;
	    			target=(target+right)/2;
	    		    
	    		}
	    		else{
                    right=target;
	    			target=(left+target)/2;
	    		    
	    		}
	    		sq=target*target;
	    		
	    	}
	    	
	    	return (int)(target);
	    	
	    }

/**
* The quickest way is newton's method based on f(x1)=x1^2-x2=0
* Then progam according to the formula
* This implementation is based on  binary-search 
*/



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
}

