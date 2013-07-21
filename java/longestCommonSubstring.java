public class Solution {
    public String longestCommonPrefix(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(strs==null || strs.length==0) return "";
        String res="";
        for(int i=0;i<strs[0].length();i++){
            char a = strs[0].charAt(i);
            for(int j=1;j<strs.length;j++){
                // pruning  
                if(strs[j].equals("")) return "";
                //don't forget validity check
                if(i>=strs[j].length() || strs[j].charAt(i)!=a) return res;
            }
            res+=String.valueOf(a);
        }
        
        return res;
    }
}
