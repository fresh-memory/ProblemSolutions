public int removeDuplicates(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int index=0;
        
        for(int i=0;i<A.length;i++){
              int j=0;
            for(j=0;j<i;j++){
                if(A[j]==A[i]) break;
            }
            if(j!=i) continue;
            A[index++]=A[i];
        }
        
        return index;
    }
