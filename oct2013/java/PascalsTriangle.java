public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(numRows == 0) return result;
        
        for(int i = 0; i < numRows; i++) {
            ArrayList<Integer> arr = new ArrayList<Integer>(i+1);
            if(i < 2) {
                for(int j = 0; j <= i; j++){
                    arr.add(1);
                }
               // result.add(arr);
            }
            else{
                for(int j = 0; j<=i; j++){
                    if(j == 0 || j ==i){
                        arr.add(1);
                    }
                    else{
                        ArrayList<Integer> preList = result.get(i-1);
                        arr.add(preList.get(j-1) + preList.get(j));
                    }
                   
                }
                 
            }
            result.add(arr);
        }
        return result;    
    }
}
