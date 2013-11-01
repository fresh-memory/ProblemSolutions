/**Recusive
*  easy to write but failed large case
*
*/

public class Solution {
    public boolean isMatch(String s, String p) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s==null || p==null) return false;
        
        return helper(s,p,0,0,s.length(),p.length());
        
    }
    
    public boolean helper(String s, String p, int i, int j, int lens, int lenp){
        
        if(j==lenp) return lens==i;
        if(i==lens){
            for(;j<lenp;j++){
                if(p.charAt(j)!='*') return false;
            }
            return true;
        }
        if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='?') return helper(s,p,i+1,j+1,lens,lenp);
        else if(p.charAt(j)=='*'){
            // deal with case multiple * case such as aa*****b
            while(j<lenp&& p.charAt(j)=='*'){ j++;}
            if(j==lenp) return true;
            //match a with b after*
            while(i<lens){
             if(helper(s,p,i,j,lens,lenp)) return true;
                 i++;
            }
        }
        //s(i)does not match p(j)
            return false;
        
    }
}





public class Solution {
    public boolean isMatch(String s, String p) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int j=0;

         //corner cases
        if(s.length()==0){
            while(j<p.length()&&p.charAt(j)=='*') j++;
            if(j==p.length()) return true;
            else return false;
        }
        if(p.length()==0){
            if(s.length()==0) return true;
            else return false;
        }
        
        
        
        return isMatch(s,p,0,0);
        
    }
    
    
    public boolean isMatch(String s, String p, int i, int j){
        if(i==s.length() && j==p.length()) return true;
        if((i==s.length() &&p.charAt(j)!='*')|| j==p.length()) return false;
        if(p.charAt(j)=='*') {
           //  
            while(j<p.length() && p.charAt(j)=='*'){ j++;}
            if(j==p.length()) return true;
            for(int x=i;x<s.length();x++){
                if(isMatch(s,p,x,j))
                return true;
            }
             return false;    
        }
        if(p.charAt(j)=='?' || p.charAt(j)==s.charAt(i)) return isMatch(s,p,i+1,j+1);
        return false;
               
    }
    
    
}
