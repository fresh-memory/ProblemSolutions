// O(N^3)
 static int balanceString(String str){
        	 int len = str.length();
        	int max=0;
            for(int i=0;i<len;i++){
            	for(int j =i+1;j<len;j++){
            		 int one=0,zero=0;
            		for(int k=i;k<=j;k++){
            			if(str.charAt(k)=='1') one++;
            			else zero++;
            		}
            		if(one==zero){
            			if(max<j-i+1){
            			  max=j-i+1;
            			}
            		}
            	}
            }
        	 return max;
         }         
         
         // O(N) 
         static int balanceStringBetter(String str){
        	int[] arr = new int[str.length()];
        	int tk=0;
        	for(int i=0;i<str.length();i++){
                if(str.charAt(i)=='0'){
                	tk+=1;
                	
                }
                else{
                	tk-=1;	
                }
                arr[i]=tk;
        	}        	
        	int max=0;
        	HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        	for(int j=0;j<arr.length;j++){
                if(!hm.containsKey(arr[j])){
                	hm.put(arr[j], j);
                }
                else{
                	max= Math.max(max,j-hm.get(arr[j]));
                }
        	}        	
        	
        return max;	
        } 
