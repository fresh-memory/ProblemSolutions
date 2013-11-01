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
       
       if(s==null || p==null) return false;
       int lens =s.length();
       int lenp = p.length();
       return helper(s,0,p,0,lens,lenp);
       
    }
    
    public boolean helper(String s, int m, String p, int n, int lens, int lenp){
    // if(m>=lens && n>=lenp) return true;
        if(n>=lenp) return m==lens;
        if(n+1< lenp && p.charAt(n+1)!='*'){
            return (m<lens && (s.charAt(m)==p.charAt(n) || p.charAt(n)=='.')) && helper(s,m+1,p,n+1,lens,lenp);        
        }
        //n+1 is * 
        else if(n+1< lenp && p.charAt(n+1)=='*') {
                //while loop
               while(m<lens &&(p.charAt(n)=='.' || s.charAt(m)==p.charAt(n)) ){             
                  if(helper(s,m,p,n+2,lens,lenp)) return true;
                  m++;
                }
               return helper(s,m,p,n+2,lens,lenp);
        }
        
        return (m==lens-1 &&(s.charAt(m)==p.charAt(n) ||p.charAt(n)=='.')); 
}

}




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
            return ((p.charAt(j)==s.charAt(i) ||p.charAt(j)=='.')&&i==s.length()-1);
      }
        
    }
}
