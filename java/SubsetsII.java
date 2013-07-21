/*
*  ArrayList<ArrayList> as gloabl variable
*ArrayList as recursive function parameter 
*  DFS  
*
*/public class Solution {
     ArrayList<ArrayList<Integer>> res = null;
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        res = new ArrayList<ArrayList<Integer>>();
        res.clear();
        if(num.length==0 || num==null) return res;
        ArrayList<Integer> arr =  new ArrayList<Integer>();
        Arrays.sort(num);
        subsetHelper(num,0,arr);
        return res;
    }
    public void subsetHelper(int[] num, int pos, ArrayList<Integer> arr){
        
              res.add(new ArrayList<Integer>(arr));
              
              int prev=-5;
              for(int i=pos;i<num.length;i++){
                      if(prev!=num[i]){
                          arr.add(num[i]);
                          subsetHelper(num, i+1, arr);
                          //go back to upper level
                          arr.remove(arr.size()-1);
                          //used for forloop 
                          prev=num[i];       
                   }
            }
    
        }

}
