/*
* very similar to 
*  word break  
* use cache to avoid duplicate recursive
* have a  base case 
* when i == len - 1, it is a special case
*
*/

public class Solution {
    //ArrayList<ArrayList<String>> partitionList = new ArrayList<ArrayList<String>>(); 
    public ArrayList<ArrayList<String>> partition(String s) {
        HashMap<String, ArrayList<ArrayList<String>>> map = new HashMap<String, ArrayList<ArrayList<String>>>();
        return partition(s, map);
    }
    public ArrayList<ArrayList<String>> partition(String s, HashMap<String, ArrayList<ArrayList<String>>> map) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(map.containsKey(s)) return map.get(s);
        int len = s.length();
        ArrayList<ArrayList<String>> partitionList = new ArrayList<ArrayList<String>>(); 
        ArrayList<String> partition = new ArrayList<String>();
        //basecase
        if(len == 1) {
            partition.add(s);
            partitionList.add(partition);
            return partitionList;
        }
        
        for(int i = 0; i < len; i++) {
            //special case
            if(i == len - 1) {
                if(isPalindrome(s)) {
                    partition.add(s);
                    partitionList.add(partition);
                }
            }
            else {
                String prefix = s.substring(0, i+1);
                String postfix = s.substring(i+1);
                if(isPalindrome(prefix)) {
                    ArrayList<ArrayList<String>> p = partition(postfix, map);
                    if(!map.containsKey(postfix)) {
                        map.put(postfix, p);
                    }
                    if(p != null) {
                        for(ArrayList<String> arr : p) {
                            ArrayList<String> nArr = new ArrayList<String>(arr);
                            nArr.add(0, prefix);
                            partitionList.add(nArr);
                        }
                    }
                }
                
            }
        }    
        return partitionList;
    }
    
    
    
    
    
    public boolean isPalindrome(String s) {
        int len = s.length();
        int start = 0, end = len-1;
        while(start < end) {
            if(s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
