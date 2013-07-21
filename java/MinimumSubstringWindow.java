/*
*  
* 
*
*/


public class Solution {
    public String minWindow(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
HashMap<Character, Integer> needToFind = new HashMap<Character, Integer>();
      HashMap<Character,Integer> found = new HashMap<Character,Integer>();
      int count=0, start=-1, end=-1;
      Queue<Integer> next= new LinkedList<Integer>();
      int min = Integer.MAX_VALUE;
      int lent=T.length();
      int lens=S.length();
 
      //corner cases
      if(lent>lens) return "";
 
 
      for(int i=0;i<lent;i++){
          char cur = T.charAt(i);
          if(needToFind.containsKey(cur)){
              needToFind.put(cur, needToFind.get(cur)+1);
          }
          else needToFind.put(cur,1);
      }
 
 
    for(int j=0;j<lens;j++){
        char c = S.charAt(j);
     if(!needToFind.containsKey(c)){continue;}
     if(found.containsKey(c)){
            found.put(c, found.get(c)+1);
        }
     else found.put(c, 1);
     next.add(j);

     if(found.get(c)<=needToFind.get(c)){count++;}
        //find all chars of T
     if(count==lent){
       char startChar = S.charAt(next.peek());
       while(found.get(startChar)>needToFind.get(startChar)){
         next.remove();
         found.put(startChar,found.get(startChar)-1);
         if(next.size()>0){
         startChar = S.charAt(next.peek());
         }
         else break;
     }//while

       // if(next.size()<=0) break;
        int ss=next.peek();
        if(j-ss+1<min){
             start=ss;
             end=j;
             min=j-ss+1;
            }


   //no need to remove the start because we can handle more than neccessary of start char
   //   next.remove(0);
   //     count--;

     }//if
    }//for s

    return start>=0?S.substring(start,end+1):"";
    }
}



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
