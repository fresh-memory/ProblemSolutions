/**Recusive
*  easy to write but failed large case
*
*/
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
