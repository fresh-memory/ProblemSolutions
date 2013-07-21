/***
*pay attention to level_counter place holder e.g., "---", when queue is empty
* just break, otherwise will cause stack overflow (infinite loop)
* How to find the edit-distance one word is tricky!!!
*
*This code works for both small and large test
*
*/


public class Solution {
    public int ladderLength(String start, String end, HashSet<String> dict) {
            // Start typing your Java solution below
	        // DO NOT write main() function
	   
	    if (start.equals(end)) return 2;
	    final String dummy="---";
	    int counter=1;
	    HashMap<String, Boolean> visited = new HashMap<String, Boolean>();
	    Queue<String> q = new LinkedList<String>();
	    q.add(start);
	    q.add(dummy);
	    visited.put(start,true);
	    //visited.put(start,true);
	    while(!q.isEmpty()){
	        String pop = q.remove();
	        
	        if(pop==dummy) {
	            counter++;
	            if(q.isEmpty()) break;
	            q.add(dummy);
	        }
	        else{     
	        ArrayList<String> arr = getValidEditDistance1Words(pop, dict);
	        for(String word:arr){
	            if(word.equals(end)) return counter+1;
	            else {
	                if(visited.get(word)==null){
	                   q.add(word);
	                   visited.put(word,true);
	                }
	            }
	        }
	    }
	    }
	    return 0;
	    }
	    
	   static ArrayList<String> getValidEditDistance1Words(String str1, HashSet<String> dict){
	        ArrayList<String> arr = new ArrayList<String>();
	        for(int i=0; i<str1.length();i++){
	            for(char c='a'; c<='z';c++){
	                if(str1.charAt(i)!=c){
	                    String str2 = str1;
	                    char[] st_char= str2.toCharArray();
	                    st_char[i]=c;
	                    String temp = String.valueOf(st_char);
	                    if(dict.contains(temp)){
	                      arr.add(temp);
	                    }
	                }
	            }
	        }
	        return arr;
	    }
        
        
    }
