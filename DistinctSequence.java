/*
*  DP 
* formula   if T[i]==S[j] => numDisct(i,j)=numDisct(i-1,j-1)+numDisct(i,j-1);
*           else         => numDisct(i,j)=numDisct(i,j-1);
* 
*   Need to initialize first row as 1 and first colum except matrix[0][0] as 0.
*


public class Solution {
    int numDistinct(String T, String S) {
        // Start typing your java solution below
        // DO NOT write int main() function
        
        if(S==null || T==null) return 0;
        char[] ss = S.toCharArray();
        char[] tt = T.toCharArray();
        int lens=ss.length;
        int lent=tt.length;
      
        int[][] matrix = new int[lens+1][lent+1];
       // initialize first row as zer01
        for(int i=0;i<lent+1;i++){
            matrix[0][i]=1;
        }
        for(int i=1;i<lens+1;i++){
            matrix[i][0]=0;
        }
        
        for(int i=1;i<lens+1;i++){
            for(int j=1;j<lent+1;j++){
                if(ss[i-1]==tt[j-1]){
                  matrix[i][j]=matrix[i][j-1]+matrix[i-1][j-1];
                }
                else{
                matrix[i][j]=matrix[i][j-1];
                }
        
            }
        
        }
        
        return matrix[lens][lent];
    }
}
