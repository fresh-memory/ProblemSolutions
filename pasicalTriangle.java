//Iterative
public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> arr = new ArrayList<Integer>();
        if(numRows<1) return res;
        arr.add(1);
        res.add(arr);
       // if(numROws==1) return res;
        
        
        while(numRows>1){
           ArrayList<Integer> newArr = new ArrayList<Integer>(arr.size()+1);
           newArr.add(1);
           for(int i=1;i<arr.size();i++){
               newArr.add(arr.get(i-1)+arr.get(i));
           }
           newArr.add(1);
           res.add(newArr);    
           arr= newArr;
           numRows--;
        }
        return res;
    }
}
