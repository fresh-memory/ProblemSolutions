public class isValidPalindrome {
/***
*
*Knows how to decide a character is a valid character!
*/

 public static boolean isPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
       if(s==null) return true;
       
     int i=0, j = s.length()-1;
     while(i<j){
      while(!isCharAlphanumeric(s.charAt(i))) {i++;
      if(i>j) return true;
      
      }
      while(!isCharAlphanumeric(s.charAt(j))) {
          j--;
          if(i>j) return true;
      }
      if((i<j) && (s.charAt(i)!=s.charAt(j))) return false;
      else {
          i++;
    	  j--;
     }
     }
     return true;
       
       
    }
    
    
    static boolean  isCharAlphanumeric(char ch){
            if((ch>='a' && ch<='z') || ((ch>='A' && ch<='Z')) ||((ch>='0' && ch<='9'))){
                return true;
            }   
            else return false;
           
       }
}
