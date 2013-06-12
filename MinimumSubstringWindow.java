/*
*  
* 
*
*/


public class Solution {
    public String minWindow(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        HashMap<Character, Integer> needFind = new HashMap<Character, Integer>();
        HashMap<Character, Integer> find = new HashMap<Character, Integer>();
        
        int lens = S.length();
        int lent = T.length();
        int min = Integer.MAX_VALUE;
        String str = "";
        for(int i =0; i<lent;i++){
            char c =T.charAt(i);
            if(needFind.containsKey(c)){
                needFind.put(c, needFind.get(c)+1);
            }
            else {
                needFind.put(c, 1);
            }
        
        }
        int[] next = new int[lens];
        int start=-1, end=0, count=0;
        if(needFind.containsKey(S.charAt(0))){
            start= 0;
        }
        int arrayTk=1, arraywrite=0;
        while(end<lens){
            char e = S.charAt(end);
            if(needFind.containsKey(e)){
                if(start==-1) {
                    start=end;
                }
               // store the position of  possible candidates
               next[arraywrite++]=end;
                
                if(!find.containsKey(e)){
                        find.put(e,1);
                }
                else
                    find.put(e, find.get(e)+1);
               if(find.get(e)<=needFind.get(e)){ 
                   //count how many needed are seen so far 
                   count++;
               }
               //find a window
                 if(count>=lent){
               
                char mm = S.charAt(start);
                
                // more than necessary
                 while(find.get(mm)>needFind.get(mm)){
                     //min window and string         
                 find.put(mm, find.get(mm)-1);
                  //move start to next
                 if(arrayTk<next.length){
                    start = next[arrayTk++];
                     mm=S.charAt(start);
                     
                 }
                 }
                  if(end-start+1< min){
                     min = end-start+1;
                     str=S.substring(start,end+1);
                 } 
                 
             }
               
            }
           
             
              end++;
   
        }
   
        return str;
    }
}
