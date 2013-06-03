/*
*
* It is not difficult just treat the matrix as a 1D array.
* Should not make any mistake
*
/

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
     int row=matrix.length;
     int col=matrix[0].length;
     int last = row*col-1;
     
     if(row==0) return false;
     return searchHelper(matrix, target, 0, last, col);
     
    }
    
    
    public boolean searchHelper(int[][] matrix, int target, int start, int end, int col){
        
        if(start>end) return false;
        
        int mid = start+(end-start)/2;
        int midValue=matrix[mid/col][mid%col];
        if(midValue==target) return true;
        else if(midValue>target){
             return searchHelper(matrix,target,start, mid-1, col);
        }
        else {
            return searchHelper(matrix, target, mid+1,end, col);
        }
        
        
    }
    
    
//2nd Solution 
    public boolean searchMatrix(int[][] matrix, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
     int row=matrix.length;
     int col=matrix[0].length;
     int r=0;
     for(int x=0;x<row;x++){
         if(matrix[x][0]==target) return true;
         if(matrix[x][0]>target){
          if(x==0) return false;
          else{
              r=x-1;
              return searchHelper(matrix, target, r, 1, col-1);
          }
          
         }
         
     }
     
    // [[1,3]] find 3
    //reach the last row 
     
        return searchHelper(matrix,target, row-1, 1, col-1);
    }
    
    
    public boolean searchHelper(int[][] matrix, int target, int x, int starty, int endy){
        
        if(starty>endy) return false;
        
        int midy = starty+(endy-starty)/2;
        int midValue=matrix[x][midy];
        if(midValue==target) return true;
        else if(midValue>target){
             return searchHelper(matrix,target, x, starty, midy-1);
        }
        else {
            return searchHelper(matrix, target,x, midy+1, endy);
        }
        
        
    }
    
    
    
}
