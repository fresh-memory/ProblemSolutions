
/**
*  Cannot pass large test
*  Bug when first row has 0, this code may create false positives
* just need to recursive right and down because need to traverse all the matrix. 
* left and upper will eventually be covered
*
* Another dfs solutions:
1. iterate through 4 borders and recursive mark all the "O" connected to edge cell "O" as "+"
2. Iterate through the matrix Mark "O" as "X" because the leftover "O" cannot reached by "+" 
and is surrended by all "X"
3. Change "+" back to "O"
* To pass large case: 
* Should implement bfs one using queue
* 
*/


//DFS

public class Solution {
    public void solve(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        int rows = board.length;
        if(rows==0) return;
        int columns = board[0].length;
       // Queue<Character[][]> q = new LinkedList<Character[][]>();
        for(int i=0;i<columns;i++){
            if(board[0][i]=='O'){
               helper(board,0,i);
            }
            if(board[rows-1][i]=='O'){
                helper(board,rows-1,i);
            }
        }
        for(int j=1;j<rows-1;j++){
            if(board[j][0]=='O'){
               helper(board,j,0);
            }
            if(board[j][columns-1]=='O'){
                helper(board,j,columns-1);
            }
        
        }
        
        for(int i=0;i<columns;i++){
            for(int j=0;j<rows;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }
                else if(board[i][j]=='*'){
                    board[i][j]='O';
                }
            }
        }
        
    }
    
    public void helper(char[][] board, int x, int y){
           Queue<Integer> q = new LinkedList<Integer>();
           
           if(x>=0 && x<board[0].length&&y>=0&&y<board.length&&board[x][y]=='O'){
             
             board[x][y]='*';
             
             helper(board,x+1,y);
             helper(board,x-1,y);
             helper(board,x,y+1);
             helper(board,x,y-1);
           }
    }
    
}
















//BFS

public class Solution {
    public void solve(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        int rows = board.length;
        if(rows==0) return;
        int columns = board[0].length;
        for(int i=0;i<columns;i++){
            if(board[0][i]=='O'){
               helper(board,0,i);
            }
            if(board[rows-1][i]=='O'){
                helper(board,rows-1,i);
            }
        }
        for(int j=1;j<rows-1;j++){
            if(board[j][0]=='O'){
               helper(board,j,0);
            }
            if(board[j][columns-1]=='O'){
                helper(board,j,columns-1);
            }
        
        }
        
        for(int i=0;i<columns;i++){
            for(int j=0;j<rows;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }
                else if(board[i][j]=='*'){
                    board[i][j]='O';
                }
            }
        }
        
    }
    
    public void helper(char[][] board, int x, int y){
           Queue<Integer> q = new LinkedList<Integer>();
           
            check(board, x,y,q);
            
             while(!q.isEmpty()){
                 int coor = q.remove();
                 int i=coor/board.length;
                 int j=coor%board.length;
                 check(board,i+1,j,q);
                 check(board,i-1,j,q);
                 check(board,i,j+1,q);
                 check(board,i,j-1,q);
             }
      }
    
    
    
    void check(char[][] board, int x, int y, Queue q){
        if(x>=0 && x<board[0].length&&y>=0&&y<board.length&&board[x][y]=='O'){
               board[x][y]='*';
               q.add(x*board.length+y);
               
        } 
    }
}
















public class Solution {
    public void solve(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
       
       int xlen=board.length-1;
       //two dimension array need to decide if row is empty 
       if(xlen<2) return;
       int ylen=board[0].length-1;
       
       //not together with xlen
       if(ylen<2) return;
       for(int i=1;i<xlen;i++){
               for(int j=1;j<ylen;j++){
                 if(board[i][j]=='X') continue;
                 else{
                     if(helperBoolean(board,i,j,xlen,ylen)){
                         helperflipping(board,i,j,xlen,ylen);
                     } 
                 }
               }
    }
    }
    
    public boolean helperBoolean(char[][] board, int x, int y, int xlen, int ylen){
           
            if(x==0 || y==0 || x==xlen || y==ylen){
                         if(board[x][y]=='X') return true;
                         else return false;
            }
             if(board[x][y]=='X')
              return true;
         
      
          
          
          boolean  right=helperBoolean(board,x,y+1,xlen,ylen);
        
          boolean    down= helperBoolean(board,x+1,y,xlen,ylen);
          
          return right&&down;      
            
        
    }
    
    
    public void helperflipping(char[][] board, int x, int y,int xlen, int ylen){
     
     
             if(x<=0 || y<=0 ||x>=xlen || y>=ylen)  return;
             
             if(board[x][y]=='X') return;
             if(board[x][y]=='O')
              board[x][y]='X';             
              
     
             helperflipping(board,x,y+1,xlen,ylen);
             helperflipping(board,x+1,y,xlen,ylen);
    }
    
}
