//Only a few line change compared to combinationSumI
// Becareful about dedup conditions
// in the same level of recursion, skip duplicate element e.g., 1,2,2,2,5   sumto 5
// from iterate from right to left, skip the first two 2s but in the next round of recursion, the second 2 should not consider
//as duplicate of the third 2, since in the next round of recursion, the third 2 is not considered at all. 



public class Solution {
 public ArrayList<ArrayList<Integer>> combinationSum2(int[] candidates, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Arrays.sort(candidates);
        
     return combinationSumHelper(candidates, target,candidates.length-1);
     
    }
    public ArrayList<ArrayList<Integer>> combinationSumHelper(int[] can, int target, int j) {


        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();        
       // if(!binarysearch(can,target, 0, can.length-1)) return res;
        ArrayList<Integer> alist=null;
        if(target<can[0]) return res;
          if(binarysearch(can,target, 0, j)) {
              alist = new ArrayList<Integer>();
              alist.add(target);
              res.add(alist);
          }
        for(int i=j;i>=0;i--){
            //dedup conditions i!=j means in recursion does not skip rightmost element
            // skip duplicate in the same level of recursion but not next level
           if(i+1<can.length && i!=j){
               if(can[i]==can[i+1]){continue;}
            }
            ArrayList<ArrayList<Integer>> temp = combinationSumHelper(can, target-can[i], i-1);
            if(temp.size()==0) continue;
            else{
              for(ArrayList<Integer> atemp: temp){
                  atemp.add(can[i]);
                  res.add(atemp);
              }
        }
        }
        return res;
    }    
 
      boolean binarysearch(int[] arr, int tar, int left, int right){
      
       if(left<=right){
        int mid=(right-left)/2+left;
          if(tar==arr[mid]) return true;
          if(tar>arr[mid]) return binarysearch(arr, tar,mid+1, right);
          else return binarysearch(arr, tar,left, mid-1);          
       }
       return false;
    }
}
