/*
*  Be careful about how to change /add Object returned from a method call.
* 
*
*
*/

public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    if(k>n) return res;
    return combineHelper(1, n, k);
    
    }
    
    public ArrayList<ArrayList<Integer>> combineHelper(int start, int end, int k){
    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> arr = new ArrayList<Integer>(); 
        if(k==1) {
            for(int q=start;q<=end;q++){
                ArrayList<Integer> arrTemp = new ArrayList<Integer>(); 
                arrTemp.add(q);
            res.add(arrTemp);
            }
          return res;  
        }
        if(end-start+1<k){
            return res;
        }
        if(end-start+1==k){
            for(int i=start;i<=end;i++){
                arr.add(i);
            }
        res.add(arr);
        return res;
        }
        ArrayList<ArrayList<Integer>> rightRes = null;
        for(int j = start; j<=end-k+1;j++){
            rightRes = combineHelper(j+1,end,k-1);
           // for(ArrayList<Integer> rightArr : rightRes){
             int size = rightRes.size();
             for(int m=0;m<size;m++){
                 ArrayList<Integer> atemp = rightRes.get(m);// cannot add the original list 
                 atemp.add(j); //return boolean
                 Collections.sort(atemp);
             res.add(atemp);
               // Collections.sort(rightArr);
            }
        }
        return res;
    }
    
    
    
}
