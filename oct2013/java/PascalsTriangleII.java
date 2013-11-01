/*
* 
* arraylist add 
* arraylist set
*
*/
public class Solution {
    public ArrayList<Integer> getRow(int rowIndex) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
     
        ArrayList<Integer> arr = new ArrayList<Integer>(rowIndex);

        for(int i = 0; i <= rowIndex; i++) {
                
                arr.add(0,1); 
                for(int j = 1; j < i; j++){
                            arr.set(j, arr.get(j+1) + arr.get(j));
                }
            }
        return arr;
    }
}
