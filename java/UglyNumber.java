/*
* http://www.geeksforgeeks.org/ugly-numbers/
*/

int uglyNumber(int n){
        	if(n<1) return 0;
          int i2=0, i3=0,i5=0;
          int[] ugly = new int[n];
          ugly[0]=1;
          int[] arr = {2,3,5};
          for(int i=1;i<n;i++){
	          int a = Math.min(arr[0]*ugly[i2], arr[1]*ugly[i3]);
	          int b = Math.min(a, arr[2]*ugly[i5]);
	          ugly[i]=b;
	          if(b==arr[0]*ugly[i2]){
	        	  i2++;
	          }
	          if(b==arr[1]*ugly[i3]){
	        	  i3++;
	          }
	          if(b==arr[2]*ugly[i5]){
	        	  i5++;
	          }
          }
          
          return ugly[n-1];
          }
