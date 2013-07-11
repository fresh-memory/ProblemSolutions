//hasmap to track if seen and where had seen

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        int lens = s.length();
        if(lens==0) return 0;
        int max=Integer.MIN_VALUE;
        int count=0,start=0;
        Map<Character, Integer> hs = new HashMap<Character, Integer>();
        for(int i = 0;i<lens;i++){
            if(hs.containsKey(s.charAt(i))){
                int p = hs.get(s.charAt(i));
                //need to remove intermediate repeating characters
                //abbcb
                for(int j= start;j<=p;j++){
                    hs.remove(s.charAt(j));
                    count--;
                
                }
                start=p+1;
        }
         hs.put(s.charAt(i),i);
         count++;
         max=Math.max(max,count);
       
    }
      return max;
 
    }
 
}









public class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        HashMap<Character, Integer> hs = new HashMap<Character, Integer>();
        int lens = s.length();
        if(lens==0 || s==null) return 0;
        int start=0, max= Integer.MIN_VALUE;
        
        for(int j=0;j<lens;j++){
            
            if(hs.containsKey(s.charAt(j))){
                int pos =hs.get(s.charAt(j));
                 //don't forget to remove ommited intermeidate value from hashmap     
                 for(int i=start; i<pos+1;i++){
                  hs.remove(s.charAt(i));
                }
               start =pos +1;
             }
             else {
               int   l  =j-start+1;
                  if(l>max) max =l;
             }
           hs.put(s.charAt(j), j);

        }
        return max;
    }
}
