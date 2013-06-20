public class Solution {
    public String simplifyPath(String path) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        Stack<String> stk = new Stack<String>();
        String[] sarr = path.split("/");
        for(int i=1;i<sarr.length;i++){
            //if(sarr[i]==/) continue;
            if(sarr[i].equals(".") ||sarr[i].equals("")) continue;
             if(sarr[i].equals("..")){
                if(!stk.isEmpty()){
                    stk.pop();
                }
            }
            else {
                stk.push(sarr[i]);
            }
            
        }
        String res="";
        while(!stk.isEmpty()){
            res="/"+stk.pop()+res;
        }
        
        if(res=="")
        res="/";
        return res;
    }
}
