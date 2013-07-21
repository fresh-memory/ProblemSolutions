/**
*  How to initialize the hashMap???
*  Less complicated than combination
*  But remember when change function signature need to double check previous written functions' signature
* 
*
/



public class Solution {
    
    public ArrayList<String> letterCombinations(String digits) {
       //build the hashMap
    HashMap<String, ArrayList<String>> hm = new HashMap<String, ArrayList<String>>();
    //int counter=0;
    ArrayList<String> a = new ArrayList<String>();
    int digit=2;
    for(char i='a'; i<'p';i++){
      if((i-'a')%3==2){
          a.add(String.valueOf(i));
          hm.put(String.valueOf(digit), a);
          digit++;
         a = new ArrayList<String>();
      }
      else a.add(String.valueOf(i));
    }
    
     a = new ArrayList<String>();
          a.add(String.valueOf('p'));
          a.add(String.valueOf('q'));
          a.add(String.valueOf('r'));
          a.add(String.valueOf('s'));
          hm.put("7", a);
      
     a = new ArrayList<String>();
          a.add(String.valueOf('t'));
          a.add(String.valueOf('u'));
          a.add(String.valueOf('v'));
        //  a.add(String.valueOf('s'));
          hm.put("8", a);
    
     a = new ArrayList<String>();
          a.add(String.valueOf('w'));
          a.add(String.valueOf('x'));
          a.add(String.valueOf('y'));
          a.add(String.valueOf('z'));
          hm.put("9", a);
          
      ArrayList<String> xx= new ArrayList<String>();
    
        if(digits.length()==0 || digits==null) {
            xx.add("");
            return  xx;
        }
        return letterHelper(digits, 0, hm);
        
    }
    public ArrayList<String> letterHelper(String digits, int i, HashMap<String, ArrayList<String>> hm) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        
    
        if(i==digits.length()-1) return hm.get(digits.substring(digits.length()-1));
        if(digits.charAt(i)=='1') return letterHelper(digits,i+1,hm);
        ArrayList<String> arr = letterHelper(digits,i+1,hm);
        ArrayList<String> res = new ArrayList<String>();
        for(String str: arr){
             for(String x: hm.get(String.valueOf(digits.charAt(i)))){
            String newStr= x+str;
            res.add(newStr);
        }
        }
     return res;
        
    }
}
