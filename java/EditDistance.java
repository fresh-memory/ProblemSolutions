/*                            {   deleteCost+ T(i-1,j)
*   Formula    T(i,j) = min       T(i,j-1) + insertCost
                                 { T(i-1, j-1)  if(A[i]==B[j])
                                   T(i-1, j-1)+ replacecost if(A[i]!=B[j]) 
                                 } 
                              }
*   
*   Iterative build the table => fast       
*   Similar to longest common substring/subsequence
*/


public class Solution {
    public int minDistance(String word1, String word2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int m = word1.length();
        int n = word2.length();
        int[][] resArray = new int[m+1][n+1];
        resArray[0][0]=0;
        for(int i=1;i<n+1;i++){
            resArray[0][i]=resArray[0][i-1]+1;
        }
        for(int j=1;j<m+1;j++){
            resArray[j][0]=resArray[j-1][0]+1;
        }
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                int deleteCost=resArray[i][j-1]+1;
                int insertCost=resArray[i-1][j]+1;
                int replaceCost=(word1.charAt(i-1)==word2.charAt(j-1)?resArray[i-1][j-1]:resArray[i-1][j-1]+1);
                resArray[i][j]=Math.min(Math.min(deleteCost,insertCost),replaceCost);
                
            }
        }
        return resArray[m][n];
    }
}










public class Solution {
    public int minDistance(String word1, String word2) {
        // Start typing your Java solution below
        // DO NOT write main() function
      
            char[] w1 = word1.toCharArray();
            char[] w2 = word2.toCharArray();
            
    return minHelper(w1,w2, w1.length, w2.length);
   
    }
    
    
    
    public int minHelper(char[] w1, char[] w2, int m, int n){
        
        if(m==0) return n;
        if(n==0) return m;
        int[][] matrix= new int[m+1][n+1];
        for(int i=0;i<=m;i++){ matrix[i][0]=i;}
        for(int j=1;j<=n;j++){ matrix[0][j]=j;}
        for(int i=1;i<=m;i++){
            for(int j =1; j<=n;j++){
                
        int costDelete=1+matrix[i-1][j];
        int costInsert=matrix[i][j-1]+1;
        int costReplace=0;
        if(w1[i-1]==w2[j-1]) costReplace=matrix[i-1][j-1];
        else costReplace=matrix[i-1][j-1]+1;
        // Math.min(int,int)
        int min = Math.min(costDelete,costInsert);
        matrix[i][j]=Math.min(min, costReplace);
            }
        }
        
       
        return matrix[m][n];
    }
}
