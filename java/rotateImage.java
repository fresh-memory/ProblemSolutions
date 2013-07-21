/**
*  see comment inline
*  
*
*/


public class Solution {
    public void rotate(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
     int row=matrix.length;
     //int col=matrix[0].size();
     
     int temp=0,level=0;
     //be careful about the stop condition 
     for(int x=0; x<row-level-1;x++,level++){      
         for(int y=x; y<row-1-level;y++){
             //start from left ->top, only need one temp var
                 temp=matrix[x][y];
                 //left->top
                 matrix[x][y]=matrix[row-1-y][x];
                 //bottom->left
                 matrix[row-1-y][x] = matrix[row-1-x][row-1-y];
                 //right->bottom
                 matrix[row-1-x][row-1-y]=matrix[y][row-1-x];
                 //top->right
                 matrix[y][row-1-x]=temp;
         }
     }
     
     
    }
}
