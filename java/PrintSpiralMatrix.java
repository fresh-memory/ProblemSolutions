/**
* manipulate the index 
* know when to make a turn
* Corner case: n=0,n=1;
* stop crieria : layer = (n+1)/2
*
/


public class Solution {
    public int[][] generateMatrix(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        int[][] matrix = new int[n][n];
        if(n<=0) return matrix;
        int number=1;
        int layer=0, x=0,y=0;
        while(layer<=(n+1)/2){
           
            //left->right
            while(y<=n-1-layer){
                matrix[x][y++]=number++;
            }
            y--;
            x++;
            //top->bottom
            while(x<=n-1-layer){
                
                matrix[x++][y]=number++;
                
            }
            x--;
            y--;
            //right->left
            while(y>=layer){
                
                matrix[x][y--]=number++;
            }
            //bottom->top
            y++;
            x--;
            while(x>=layer+1){
                matrix[x--][y]=number++;
            }
            
            x++;
            layer++;
            y++;
        }
    return matrix;
    }
}
