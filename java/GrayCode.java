/*
* Recursive solution 
*
*
*/


public class Solution {
    public ArrayList<Integer> grayCode(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> arr = new ArrayList<Integer>();
        if(n<=1){
            arr.add(0);
            if(n==1) arr.add(1);
            return arr;
        }
        
        int high= 1<<(n-1);
        ArrayList<Integer> preList = grayCode(n-1);
        //need to add the most significant bit 1 from the right of the previous results.
        //  sequence for (n+1) will be twice for n and the difference come from the most significant bit
        // e.g., 1->2 :   0 1 => 0 1  11 10
        for(int j=preList.size()-1; j>=0;j--){
            preList.add(preList.get(j)+high);
            
        }
        
        return preList;
    }
}
