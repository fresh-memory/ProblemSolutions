public class Solution {
   
    ArrayList<ArrayList<Integer>> res;
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] S) {
        res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> arr = new ArrayList<Integer>();
        Arrays.sort(S);
        subsets(S,0, arr);
        return res;
    }


    public void subsets(int[] s, int j, ArrayList<Integer> arr){

        ArrayList<Integer> newArr = new ArrayList<Integer>(arr);
        res.add(newArr);
        int pre=-100;
        for(int i=j;i<s.length;i++){
            if(pre>=0 && s[pre]==s[i]) continue;
            arr.add(s[i]);
            subsets(s,i+1,arr);
            arr.remove(arr.size()-1);
            pre=i;
        }
    }

}
