/*
* using constant space
*reserve first row and first column as info storage bit
*
*1. scan first row and first column to decide if they would be set as zeros.
*2. scan from second row and second column if matrix[j][i]==0, set the corresponsing position in first row and column as zero
*3. set whole row and whole column as zero according to the 1st row and 1st column
*4. reset first row and first column according to the two boolean vairable set in step 1.
*/


public class Solution {
    public void setZeroes(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int y=matrix.length;
        int x=matrix[0].length;
        
    int i=0,j=0;
    boolean firstrowzero=false, firstcolumnzero=false;
    for(i=0;i<x;i++){
        if(matrix[0][i]==0){
            firstrowzero=true;
        }
    }
    
    for(j=0;j<y;j++){
        if(matrix[j][0]==0){
            firstcolumnzero=true;
        }
    }
    
    for(i=1;i<x;i++){
        for(j=1;j<y;j++){
            if(matrix[j][i]==0){
                matrix[0][i]=0;
                matrix[j][0]=0;
                
            }
        }
    }
    
    for(i=1;i<x;i++){
        if(matrix[0][i]==0){
            for(j=1;j<y;j++){
                matrix[j][i]=0;
            }
        }
    }    
    
    for(j=1;j<y;j++){
        if(matrix[j][0]==0){
            for(i=1;i<x;i++){
                matrix[j][i]=0;
            }
        }
    }  
    
    if(firstrowzero){
        for(i=0;i<x;i++){
        matrix[0][i]=0;
    }}
    if(firstcolumnzero){
        for(j=0;j<y;j++){
        matrix[j][0]=0;
    
    }
    }
}



}
