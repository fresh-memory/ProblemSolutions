/*
* Iterative
* Failed large case 
* Memory limit exceeded probably because of the matrix.
* 
*
/

public class Solution {
    public int jump(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
    
        int len=A.length;
        if(len==1) return 0;
        int[][] matrix = new int[len][len];
        
        for(int i=0;i<len-1;i++){
            int steps=A[i];
            int j=i+1;
            while(steps>0){
                
             //[1]    
                if(j<len){
                  matrix[i][j++]=1;
                  steps--;
            }
            else break;
        }}
       
        for(int i=len-2;i>=0;i--){
            for(int j=i+1;j<len;j++){
               if(matrix[i][j]==0){
                    int min = 10000;
                   for(int x=i+1;x<j;x++){
                       if(matrix[i][x]!=0 && matrix[x][j]!=0){
                       min=Math.min(min, matrix[i][x]+matrix[x][j]);
                       }
                   }
               matrix[i][j]=min;
               }    
            }
        }
        
        return matrix[0][len-1];
    }
}
