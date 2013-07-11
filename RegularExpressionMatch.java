/*
*   Recursive
*   three conditions: the  next pos of p is *, not *,
* and j, the pointer of p points to the last position
*
*/

public class Solution {
    public boolean isMatch(String s, String p) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        return isMatch(s,p,0,0);
    }
    
    public boolean isMatch(String s, String p, int i, int j){
        
           if(j>=p.length()) return i==s.length();
        //pattern's next char is not *
        if(j+1<p.length() && p.charAt(j+1)!='*'){
              return (i<s.length()&&(s.charAt(i)==p.charAt(j)||p.charAt(j)=='.'))&& isMatch(s,p,i+1,j+1);
        }
        else if(j+1<p.length() && p.charAt(j+1)=='*')
        {
            
             //  int k=i;
               while(i<s.length() && (s.charAt(i)==p.charAt(j) ||p.charAt(j)=='.')){
                        if(isMatch(s,p,i,j+2)){
                          return true;
                         }
                         i++;
                    
                    }//while
            
                   return isMatch(s,p,i,j+2);
       }
        //j is the last of p
        else{
            return (i<s.length()&&(p.charAt(j)==s.charAt(i) ||p.charAt(j)=='.')&&i==s.length()-1);
      }
        
    }
}
