/* Walk through an example to summarize the pattern:::    
*  scan from end to start, find the pos where num[pos]<[pos+1] 
 if backend has larger value, find the smallest larger value and then sort pos+1 onward ascendingly.
 if no break position, this is the largest representation, just reverse the array. 
*
*
*/
public class Solution {
    public void nextPermutation(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
     
     int len = num.length;
     if(len<2) return;
    //int min=num[len-1];
    // int pos=len-1;
     int i=len-2;
     for(;i>=0; i--){
         
         if(num[i]<num[i+1]){
             for(int k=len-1;k>i;k--){
                if(num[k]>num[i]){
                 int temp = num[i];
                  num[i]=num[k];
                  num[k]=temp;
                  break;
             }
             }
         
         for(int m=i+1;m<len;m++){
             int small=1000, spos =-1;
             for(int n=m;n<len;n++){
                 if(num[n]<small){
                  small=num[n];
                  spos=n;
                 }
                 
                }
                 int t = num[m];
                 num[m]=small;
                 num[spos]=t;
             
           }
           break;
         }
    
     }
     
    // reverse
    if(i==-1){
     int x=0, y=len-1;
     while(x<y){
         int mt=num[x];
         num[x]=num[y];
         num[y]=mt;
         x++;
         y--;
     }
    }
     
 }
}
