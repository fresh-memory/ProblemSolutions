
// a string is possible valid only when it start with 0, 1, or 2.
public class Solution {
    public ArrayList<String> restoreIpAddresses(String s) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        return restoreAddr(s, 0, s.length()-1, 4);
    }
    
    
    public ArrayList<String> restoreAddr(String s, int start, int end, int part) {
        
        int strLen = end - start + 1;
        ArrayList<String> arr = new ArrayList<String>();
        //fast fail
        if(s.equals("") || s == null || strLen < part || strLen > 3*part) {
            return arr;
        }
        //base case
        if(part == 1) {
            String str = s.substring(start, end+1);
            if(isValid(str)) {
                arr.add(str);
                return arr;
            }
        }
        for(int i = start; i <=start+2 && i<=end; i++) {
            //fast fail
            //if no this line, will infinit loop
            if(!isValid(s.substring(start,i+1))) continue;
            ArrayList<String> arr1 = restoreAddr(s, start, i, 1);
            ArrayList<String> arr2 = restoreAddr(s, i+1, end, part-1);
            if(arr1 != null && arr2 != null) {
                for(String s1 : arr1) {
                    for(String s2 : arr2) {
                        arr.add(s1+"."+s2);
                    }
                }
            }
        }
        return arr;
    }
    
    public boolean isValid(String s) {
        int len = s.length();
        if(s == null || len == 0 || len >3 || (s.charAt(0) == '0' && len > 1)){
            return false;
        }
        int number = Integer.parseInt(s);
        return number < 256 && number >=0; 
        
    }
}
