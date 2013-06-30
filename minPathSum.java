/**DP Iterative*/


public class Solution {
    public int minPathSum(int[][] grid) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(grid==null || grid.length==0) return 0;
        int wid=grid.length;
        int len=grid[0].length;
        int[][] matrix = new int[wid][len];
        matrix[0][0]=grid[0][0];
        for(int i=1;i<wid;i++){
            matrix[i][0] = grid[i][0]+matrix[i-1][0];
        }    
        for(int j=1;j<len;j++) {
            matrix[0][j] = grid[0][j]+matrix[0][j-1];
        }
        for(int i=1;i<wid;i++){
            for(int j=1;j<len;j++){
                matrix[i][j]= Math.min(matrix[i-1][j], matrix[i][j-1])+grid[i][j];
                
            }
        }
    
      return matrix[wid-1][len-1];    
    }
    
    
}
