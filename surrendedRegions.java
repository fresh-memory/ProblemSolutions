/**
*  Cannot pass large test
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
