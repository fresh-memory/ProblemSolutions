/*
* Three ways
* 
*/


        //first reverse first k postion
        //then reverse position afte k
        // reverse whole array
        //O(2N) time complexity  O(1) space
       static int[] rotateArray(int[] arr,int k){
        	int x=0, y=k-1;
        	while(x<y){
                int temp=arr[x];
                arr[x]=arr[y];
                arr[y]=temp;
                x++;
                y--;
        	}        	
        	 x=k; y=arr.length-1;
        	while(x<y){
        		 int temp=arr[x];
                 arr[x]=arr[y];
                 arr[y]=temp;
                 x++;
                 y--;
        	}
        	x=0;y=arr.length-1;
        	while(x<y){
        		int temp=arr[x];
                arr[x]=arr[y];
                arr[y]=temp;
                x++;
                y--;
        	}
        return arr;
        }
        
      static  int[] rotateArray3(int[] arr, int k){
             int[] copy =new int[k];
             
             for(int i=0;i<k;i++){
            	 copy[i]=arr[i];
             }
             for(int i=k;i<arr.length;i++){
            	 arr[i-k]=arr[i];
             }
             int j=0;
             for(int i= arr.length-k;i<=arr.length-1;i++){
            	 arr[i]=copy[j++];
             }
             return arr;
        }
        
       static  int[] rotateArray2(int[] arr, int k){
        	 int start=-1;      	 
        	 for(int i=0;i<GCD(arr.length, k);i++){
        		 start=start+1;
        		int curValue=arr[start];
        		int cur=start;
        		int prev=cur+k;
        		 while(prev!=start){
	        		arr[cur]=arr[prev];
	        		cur+=k;
	        		prev+=k;
	        		if(cur>arr.length-1) cur=cur-arr.length;
 	        		if(prev>arr.length-1) prev= prev-arr.length;
        		 } 
        		 if(prev==start){
        		 arr[cur]=curValue;
        		 }
        			
        	 }
        	 
        	 return arr;
         } 
       
       
       public static int GCD(int a, int b) {
    	   if (b==0) return a;
    	   return GCD(b,a%b);
    	}
