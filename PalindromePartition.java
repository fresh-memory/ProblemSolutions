/*
*
*  need to dedup 
* by only match the whole string of the left part
*/

public class Solution {
    
    public ArrayList<ArrayList<String>> partition(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
     ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
     if(s.length()==0 || s==null) return res;
     return helper(s,0,s.length()-1);
    }
    
    public ArrayList<ArrayList<String>> helper(String s, int start,int end) {
        
       ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>(); 
        if(start>end){
            //must have these two lines for the case the whole stirng is a palindrome
            //otherwise for(:) won't execute
              ArrayList<String> arr = new ArrayList<String>();
              res.add(arr);
            return res;
        }
        if(start==end){
         ArrayList<String> arr = new ArrayList<String>();
         arr.add(s.substring(start, end+1));
         res.add(arr);
         return res;
        }    

        //need to have i==end
        for(int i=start;i<=end;i++){
            String sub =s.substring(start,i+1);
           if(isPalindrome(sub)) {
            ArrayList<ArrayList<String>> right = helper(s, i+1, end);
               
                for(ArrayList<String> rArr: right){
                     ArrayList<String> arr = new ArrayList<String>();
                     arr.add(sub);
                     arr.addAll(rArr);
                     res.add(arr);
                    }
            }//left part not palindrome
        }
    return res;
    }
    
    public boolean isPalindrome(String s){
        char[] chArray = s.toCharArray();
        int left =0, right= chArray.length-1;
        while(left<right){
          if(chArray[left]!=chArray[right]){
            return false;
          }
          left++;
          right--;
        }
            return true;
    }    
    
    
}
