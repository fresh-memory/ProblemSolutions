/**
*
* Failed large case
*
*
/

public class Solution {
    HashMap<String, ArrayList<ArrayList<String>>> hm = new HashMap<String, ArrayList<ArrayList<String>>>();
    public ArrayList<ArrayList<String>> partition(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
              if(s==null || s.length()==0) return null;
    
              return partitionHelper(s,0,s.length()-1);
    
    
    }
    
    
    
    public ArrayList<ArrayList<String>> partitionHelper(String s, int start, int end) {
         ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
         HashSet<ArrayList<String>> tRes = new HashSet<ArrayList<String>>();
         ArrayList<String> arr = new ArrayList<String>();
         
        
              if(start==end){
                  String subString = s.substring(start,end+1);
                  arr.add(subString);
                  res.add(arr);
                  if(!hm.containsKey(subString)){
                    hm.put(subString, res);
                  }
                  return res;
              }
              //if(start==end-1){
            //      if(s.charAt(start)==s.charAt(end)){
             //         return 
              //    }
              //}
              
             for(int i=start;i<end;i++){
               String front = s.substring(start,i+1);
               String back = s.substring(i+1,end+1);
               ArrayList<ArrayList<String>> left;
               ArrayList<ArrayList<String>> right;
               if(hm.containsKey(front)){
                   left=hm.get(front);
               }
               else
               left =partitionHelper(s, start,i);
               if(hm.containsKey(back)){
                   right=hm.get(back);
               }
               else
               right=partitionHelper(s, i+1,end);
             
               
              
         for(ArrayList<String> a1: left){
                for(ArrayList<String> a2:right){
                      ArrayList<String> stArr1 = new ArrayList<String>();
                        for(String tm:a1){
                            stArr1.add(tm);
                    }
                    for(String tmp:a2){
                       stArr1.add(tmp);                    
                    }
                    tRes.add(stArr1);                            
                    }
                    }
             
             }
            if(isPalindrome1(s.substring(start,end+1))){ 
                  ArrayList<String> stArr = new ArrayList<String>();
                   stArr.add(s.substring(start,end+1));
                   tRes.add(stArr);
                   
            }
            for(ArrayList<String> result_arr: tRes){
                res.add(result_arr);
            }
            String wholeS= s.substring(start,end+1);
            if(!hm.containsKey(wholeS)){
                hm.put(wholeS, res);
            }
            
             return res; 
    }
    
    static boolean isPalindrome1(String str){
     if(str==null || str=="") return false;
     int length=str.length();
     int p=0, q=length-1;
     //assume only character nad numbers in the String
     while(p<q){
         if(str.charAt(p)!=str.charAt(q)){
             return false;
         }
         p++;
         q--;
     }
     return true;
 }
}
