public class Solution {
    public int lengthOfLastWord(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
     int len=s.length();
     if(s==null ||len==0) return 0;
     int count=0, j=len-1;
     while(j>=0 && s.charAt(j)==' '){
         j--;
     }
     if(j==-1) return 0;
     
     for(int i=j;i>=0;i-- ){
         if(s.charAt(i)!=' '){
              count++;
         }
         else return count;
         
     }
     
     
     return count;
     
    }
}
