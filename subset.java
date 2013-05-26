/* Iterative
* Not that easy to get right 
* Copy constructor 
*
*  
*/


public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Arrays.sort(S);
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> inArr = new ArrayList<Integer>();
      
        int length = S.length;
        if(S==null ||length==0) return res;
        res.add(inArr);
        int index=0;
        //initiate here
	ArrayList<ArrayList<Integer>>  res1 = new ArrayList<ArrayList<Integer>>(res);
        while(length>0){
            for(ArrayList<Integer> arr: res){
               ArrayList<Integer> arr1 = new ArrayList<Integer>(arr);
               arr1.add(S[index]);
               res1.add(arr1);
            }
            res=res1;
	    //must renew every round
            res1 = new ArrayList<ArrayList<Integer>>(res);
            length--;
            index++;
        }
        
        return res;
    }
}
