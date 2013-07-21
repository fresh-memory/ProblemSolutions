/** Similar to break a sentence to valid words list
* Passed small test and failed large test 
* need further optimization
* Some optimization done by storing already computed values
*/

public class Solution {
    
    HashSet<String> hs = new HashSet<String>();
    public int minCut(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        int length=s.length();
        return minCutHelper(s, 0, length-1);
    }
    
    
    
   public int minCutHelper(String s, int start, int end){
        int min=Integer.MAX_VALUE;
        if(start > end) return -1;
        if(s==null ||s=="") return 0;
        String tmp = s.substring(start,end+1);
        if(hs.contains(tmp)) return 0;
        if(isPalindrome(tmp)) {
            hs.add(tmp);
            return 0;
        }
        int left=0, right=0, sum=0;
        for(int i=start;i<end;i++){
               left =minCutHelper(s, start,i);
               right= minCutHelper(s,i+1,end);
            
            sum=left+right+1;
            if(sum<min){
                min=sum;
            }
        }
        
        return min;
    }
    
    
    
    boolean isPalindrome(String str){
        if(str==null || str=="") return false;
        int length=str.length();
        int p=0, q=length-1;
        //assume only character nad numbers in the String
        while(p<q){
            if(str.charAt(p)!=str.charAt(q)){
                return false;
            }
            p++;
            q--;
        }
        return true;
    }
}
