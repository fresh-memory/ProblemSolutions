public class Solution {
    public String countAndSay(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(n<1) return null;
        if(n==1) return "1";

         char[] base={'1'};
        // String res="";
         //int counter=1;
         
        while(n>1){
	  // start a new String to store the result.
           String res="";
           int counter=1;
           for(int i=1;i<base.length;i++){
                if(base[i]==base[i-1]){
                counter++;
                }
                else{
                    res+=String.valueOf(counter)+String.valueOf(base[i-1]);
                }
               
            }

           // corner case when reach the end of base, need to output the last seen digit
            res+=String.valueOf(counter)+String.valueOf(base[base.length-1]);
            base=res.toCharArray();
            n--;
        }
        
        return new String(base);
    }
}
