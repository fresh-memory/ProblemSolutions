public int jump(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        return jumpHelper(A, A.length-1);
    }
    
    
    public int jumpHelper(int[] A, int end){
        
        if (end==0) return 0;
        int min = Integer.MAX_VALUE;
        // no i==end
        for(int i=end-1;i>=0;i--){
            if(A[i]>=end-i){
             int nMin= jumpHelper(A,i);
             if(nMin<min) min=nMin;
            
            }
        }
        
        return min+1;
    }
