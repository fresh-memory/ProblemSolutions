/*
*
*   don't compare char with integer!!!!!!!!!!  Check if some cel's value exist or not don't use array index because cannot do arithmetics straightforwardly on characters. Should use hashset.      lDon't need to check diagnal.It is not required.
*
*/

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
      if(board==null) return false;
      int row=board.length;
      int col=board[0].length;
      if(row!=col) return false;
      for(int i=0; i <row;i++){
          if(!isValid(board,i,0,i,col-1)) return false;
          if(!isValid(board,0,i,row-1,i)) return false;
      }
      
        for(int i=0; i<row; i=i+3){
          for(int j=0;j<col;j=j+3){
             if(!isValid(board,i,j,i+2,j+2)) return false;
          } 
       }
  /**      
HashSet<Character> hs = new HashSet<Character>();
     for(int a=0;a<9;a++){
          if(board[a][a]=='.') continue;
          if(board[a][a]>'9' ||board[a][a]<'1' ) return false;
          if(hs.contains(board[a][a])) return false;
             hs.add(board[a][a]);
      }
      
      
HashSet<Character> hs2 = new HashSet<Character>();
      
     for(int a=0;a<row;a++){
          if(board[a][row-1-a]=='.') continue;
         if(board[a][row-1-a]>'9' ||board[a][row-1-a]<'1' ) return false;
          if(hs2.contains(board[a][row-1-a])) return false;
            hs2.add(board[a][row-1-a]);
      
      }
      
  **/    
      return true;
    }
    
    
    public boolean isValid(char[][] board, int startx, int starty, int endx, int endy){
     
      
     HashSet<Character> hs = new HashSet<Character>();
     for(int b=startx;b<=endx;b++){
        for(int a=starty;a<=endy;a++){
            if(board[b][a]=='.') continue;
         if(board[b][a]>'9' ||board[b][a]<'1' ) return false;
          if(hs.contains(board[b][a])) return false;
          hs.add(board[b][a]);
      
     } }
     
     
     return true;
    }
}
