public class Solution {
    public int uniquePaths(int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
    int[][] grid = new int[m][n];
     if(m<2||n<2) return 1;
     for(int x=0;x<m;x++){
       for(int y=0;y<n;y++){
          if(x==0 || y==0) grid[x][y]=1;
          //must have else otherwise outofbound error
          else 
          grid[x][y] = grid[x-1][y]+grid[x][y-1];
       }   
     
     }
     
     return grid[m-1][n-1];
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int m =obstacleGrid.length;
        int n =obstacleGrid[0].length;
        int[][] grid = new int[m][n];
        if(obstacleGrid[0][0]==1) return 0;
        else grid[0][0]=1;
          for(int x=0;x<m;x++){
          for(int y=0;y<n;y++){
              if(obstacleGrid[x][y]==1){
                  grid[x][y]=0;
              }
              else{
                  
            if(x==0 && y!=0){
                grid[x][y]=grid[x][y-1];
            }
            else if(y==0 &&x!=0){
                grid[x][y]=grid[x-1][y];
            }
            else if(x!=0 && y!=0) //must have this condition otherwise will faile {{0}} case! 
            grid[x][y] = grid[x-1][y]+grid[x][y-1];
          } 
    }
     
     }
     
     return grid[m-1][n-1];
    }


}
