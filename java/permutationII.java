/**
*
* The difference to permutation I is adding a hashset to avoid duplicate permutations
*
*/

public class Solution {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
       HashSet<Integer> hs = new HashSet<Integer>();
       return permuteHelper(num, hs);
    
    
    
    }
    
    
    
        public ArrayList<ArrayList<Integer>> permuteHelper(int[] num, HashSet<Integer> hs){
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        int length = num.length;
        if(num==null || length==0 ) return res;
        ArrayList<Integer> arr = new ArrayList<Integer>();
        if(length==1){
            arr.add(num[0]);
            res.add(arr);
            return res;
        }
        for(int i=0;i<length;i++){
         if(!hs.contains(num[i])){
             hs.add(num[i]);
            int[] newArr = new int[length-1];
              int x=0;
              //omit current element 
             for(int j=0;j<length;j++){
                 if(j!=i){
                     newArr[x++]=num[j];
                 }     
             }
             
             //every recursive level should have a different hashset
            ArrayList<ArrayList<Integer>> part_res= permuteHelper(newArr, new HashSet<Integer>());
            for(ArrayList<Integer> eleArray: part_res){
                eleArray.add(num[i]);
              //   ArrayList<Integer> nArray =eleArray; 
              //   res.add(nArray);
                  res.add(eleArray);
            
            }
            
        }
        
        }
     return res;   
    }
}
