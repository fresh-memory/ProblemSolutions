/*
* Tail recursion => iterative
* 
*/

public class Solution {

    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(triangle==null) return 0;
        int len = triangle.size();
        int[] arr = new int[len+1];
        int counter=len-1;
        while(counter>=0){
         ArrayList<Integer> level = triangle.get(counter);
         
       for(int pos=0;pos<level.size();pos++){
           if(arr[pos]<arr[pos+1]){
                arr[pos]=arr[pos]+level.get(pos);
           }
           else{
               arr[pos]=arr[pos+1]+level.get(pos);
           
           }
       }
        
         counter--;   
        }    
        
      return arr[0];
        
    }
}
