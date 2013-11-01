Two Solutions:

1.


// bit manipulation
/** If an element appears in a subset depends on if the same index bit of the binary representation is 1 or 0
* For example, [1,2,3] correponds to 000-111 (from 0 to 7)
*  If it is 5, the binary form is 101
* then we put 1 and 3 in the subset
* 
* When  go through 0-7, we get all subsets.
*/
 
public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int size = S.length;
        int range = 1 << size;
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < range; i++) {
            res.add(generateSubset(i, S));
        }
        return res;
    }
    
    
    public ArrayList<Integer> generateSubset(int x, int[] S) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        int size = S.length;
        for(int i = 0; i < size; i++) {
            int y = x >> i;
            int lastbit = y&1;
            if(lastbit==1){
                arr.add(S[i]);
            }
        }
        return arr;
    }
}





2. Recursion


public class Solution {
    ArrayList<ArrayList<Integer>> res;
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        //**
        res = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(S);
        ArrayList<Integer> arr = new ArrayList<Integer>();
        subsetHelper(arr, 0, S);
        return res;
    }
    
    
    public void subsetHelper(ArrayList<Integer> arr, int start, int[] S) {
        //**
        ArrayList<Integer> arr1 = new ArrayList<Integer>(arr);
        res.add(arr1);
        int size = S.length;
        for(int i = start; i < size; i++) {
            arr.add(S[i]);
            subsetHelper(arr,i+1,S);
            arr.remove(arr.size()-1);
            }
        }

}
