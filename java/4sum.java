/*
*
* pay attention to how to avoid duplicate
* O(n^3) not good there are O(n^2) solution
*
*/
public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
     ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
     if(num.length<4) return res;
     Arrays.sort(num);
     
     for(int i=0;i<num.length-3;i++){
        
          if(i>0 &&num[i]==num[i-1]) continue;
        for(int j=i+1;j<num.length-2;j++){
            
            // j!=i+1 if this round just started, we don't care if duplicate
            //-1,0,1,2,-1,-4
           if(num[j]==num[j-1] && j!=i+1) continue;
          for(int m=j+1;m<num.length-1;m++){
               if(num[m]==num[m-1] && m!=j+1) continue;
              for(int n =num.length-1;n>m;n--){
                  if(num[i]+num[j]+num[m]+num[n]==target){
                      ArrayList<Integer> arr = new ArrayList<Integer>();
                      arr.add(num[i]);
                      arr.add(num[j]);
                      arr.add(num[m]);
                      arr.add(num[n]);
                      res.add(arr);
                      break;
                  }
                  else if(num[i]+num[j]+num[m]+num[n]>target){continue;}
                  else break;
                  
              }
          }
     } 
         
     }
     
     return res;
    }
}
