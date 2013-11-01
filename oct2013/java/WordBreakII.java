/* 
* similar to palindromepartitioning
*
*/

public class Solution {
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        return wordBreakHelper(s, dict, map);
    }
    
    public ArrayList<String> wordBreakHelper(String s, Set<String> dict, HashMap<String, ArrayList<String>> map){
        
          if(map.containsKey(s)) {
             return map.get(s);
          }
         ArrayList<String> result = new ArrayList<String>();
         //basecase
         if(s.length() <= 1) {
             if(dict.contains(s)) {
                result.add(s);
             }
             return result;
         }
         for(int i = 0; i < s.length(); i++) {
            String prefix = s.substring(0,i+1);
            //special case -- should not recursive call on s again, it will cause infinite loop
            if(prefix.equals(s)) {
                if(dict.contains(prefix)) {
                    result.add(prefix);
                    return result;
                }
                
            }
            if(dict.contains(prefix)) {
                String postfix = s.substring(i+1); 
                ArrayList<String> right = wordBreakHelper(postfix,dict, map);
                if(!map.containsKey(postfix)) {
                    map.put(postfix, right);
                }
                if(right == null) continue;
                    for(String word : right) {
                            result.add(prefix + " " + word);
                        
                    }
            }
    }
    return result;
    }
}
