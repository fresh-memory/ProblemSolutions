public class Solution {
    public ArrayList<Integer> getRow(int rowIndex) {
        // Start typing your Java solution below
        // DO NOT write main() function
     
      ArrayList<Integer> arr = new ArrayList<Integer>(rowIndex+1);
      if(rowIndex<0) return arr;
      arr.add(1);
      int r = rowIndex+1;
      
      while(rowIndex>0){
          for(int i=r-rowIndex-1;i>=1;i--){
              
              //set not add
              arr.set(i, arr.get(i-1)+arr.get(i));
              
          }
          arr.add(1);
          rowIndex--;
      }
      
     return arr;
    }
}
