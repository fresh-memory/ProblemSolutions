public class Solution {
    public int minCut(String s) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        
        if(s == null || s.length() == 0) {
            return 0;
        }
        return minCutHelper(s);
        
    }
  
    /**
     *  How to build the 1 dimension table
     *
     *
      /  
    public int minCutHelper(String s) {
        int len = s.length();
        int[] c = new int[len+1];
        c[0] = -1;
        for(int i =1; i < len+1; i++) {
            c[i] = 10000;
        }
        for(int i = 1; i < len + 1; i++) {
            
            for(int j = 0; j < i ;j++) {
                String substring = s.substring(j,i);
                if(isPalindrome(substring)) {
                    c[i] = Math.min(c[i], c[j]+1);
                }
            }
            
        }
        return c[len];
    }
    
    
    public boolean isPalindrome(String s) {
        int start = 0, end = s.length()-1;
        while(start < end) {
            if(s.charAt(start) != s.charAt(end) ) {
                return false;
            }
            start++;
            end --;
        }
        return true;
    }
}
