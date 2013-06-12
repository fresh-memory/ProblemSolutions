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
