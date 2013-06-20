public class Solution {
   // HashMap<Integer, Integer> hs =null;
    public int numTrees(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
      //  hs = new HashMap<Integer, Integer>();
    if(n<1) return 0;
    if(n==1) return 1;
    int x=0;
      for(int i=1;i<=n/2;i++){
            int a = numTrees(i-1);
            int b = numTrees(n-i);
            if(a==0 || b==0){x=x+a+b;}
            else x+=a*b;
            
        }
    
       if(n%2==1){
           int a = numTrees(n/2);
           // int b = numTrees(n/2);
          if(a==0)
         return  x=x*2+2*a;
          
          else return x=x*2+a*a;
       }
     
  
    
    return 2*x;

    }
}
