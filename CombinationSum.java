/**
* Sorting to avoid duplicate resutls
* DP + recursive
* This code's dedup is not good should look at II for example
/

public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
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
           // ArrayList<Integer> alist = new ArrayList<Integer>();
            ArrayList<ArrayList<Integer>> temp = combinationSumHelper(can, target-can[i], i);
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
