/**
**  Recursive
**  add addition element at the end
** should ask interviewer to clarify if there is duplicate element in the array
*  This solution suppose no duplicate element.
/

public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        return permuteHelper(num);
       
    
    }
    
    public ArrayList<ArrayList<Integer>> permuteHelper(int[] num){
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        int length = num.length;
        if(num==null || length==0 ) return res;
        ArrayList<Integer> arr = new ArrayList<Integer>();
        if(length==1){
            arr.add(num[0]);
            res.add(arr);
            return res;
        }
        for(int i=0;i<length;i++){
            int[] newArr = new int[length-1];
              int x=0;
              //omit current element 
             for(int j=0;j<length;j++){
                 if(j!=i){
                     newArr[x++]=num[j];
                 }     
             }
            ArrayList<ArrayList<Integer>> part_res= permuteHelper(newArr);
            for(ArrayList<Integer> eleArray: part_res){
                eleArray.add(num[i]);
              //   ArrayList<Integer> nArray =eleArray; 
              //   res.add(nArray);
                  res.add(eleArray);
            
            }
            
        }
     return res;   
    }
    
}
