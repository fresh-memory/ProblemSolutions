/*
* The pattern is every two colums (2*nrows-2)elements repeats the pattern
* Not recursive though. Need to tweak about the index.
* The index for row 0 and row nrows-1 follows same pattern
* The rest rows index changes with row number...
* Read the problem carefully. understand the direction of the change.
* Another way of solving this problem is using matrix to store
* the generated string row by row and then glue lines together.
* Not good as this solution in terms of space complexity.
*/


public class Solution {
    public String convert(String s, int nrows) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s==null || nrows <=0) return null;
        if(nrows==1) return s;
        int length=s.length();
        if(length<=nrows) return s;
         StringBuilder strb = new StringBuilder();
        for(int i=0;i<nrows;i++){
         int index=i;
         while(index<length){
          strb.append(s.charAt(index));
            index+=2*nrows-2;
           if((i!=0) && (i!=nrows-1) && (index-2*i<length)){
                strb.append(s.charAt(index-2*i));
            }
         }
        }    
        return  strb.toString();  
    }
}
