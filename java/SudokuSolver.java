/*
* For the board, find all empty cells.
* Call Helper function from the first empty cell, recursively solve the problem.
* After a failed try, don't forget to restore current cell and previous cell to '.'
* For each cell, find all posible valid entries.
*/


public class Solution {
    
          public static void solveSudoku(char[][] board) {
                String[] idx = new String[81];
            int row = board.length;
            int col = board[0].length;
            int k=0;
            for(int i=0;i<row;i++){
                for(int j=0; j<col;j++){
                   if(board[i][j]=='.'){
                       idx[k++]=i+","+j;
                   }
               
               }
            }
                 
            
                   solveSudokuH(board, 0, 0, idx, 0, k);
            }
            
            
            
            
            public static boolean solveSudokuH(char[][] board, int previ, int prevj,String[] emptyPos, int p, int emptyCount) {
                
            
            if(p==emptyCount) return true;
             String xy = emptyPos[p];
              int i =  Character.getNumericValue(xy.charAt(0)); 
              int j = Character.getNumericValue(xy.charAt(2));  
         
          
                 if(board[i][j]=='.'){
                    
                     Character[] candidates=availableEntries(board, i, j);
                     if(candidates.length==0) { 
                         board[previ][prevj]='.'; 
                         return false;                  
                     }
                       for(char c:candidates){
                           board[i][j]=c;
                           if(solveSudokuH(board, i, j, emptyPos, p+1, emptyCount)){
                               return true;
                           }    
                          //cannot miss this line
                           board[i][j]='.';
                       }
                       //run out of candidates
                       return false;
            }
            else return false;
            

            }
            

            
            
            //return a set of candidate elements
          static  Character[] availableEntries(char[][] board, int x, int y ){
        	  System.out.println(x+"---"+y);
                  HashSet<Character> hs = new HashSet<Character>();
                  
                  for(char i='1'; i<='9';i++){
                      hs.add(i);
                  }
                  
                  for(int i=0; i<9;i++){
                      if(hs.contains(board[i][y])){
                          hs.remove(board[i][y]);
                      }
                      if(hs.contains(board[x][i])){
                          hs.remove(board[x][i]);
                      }
                  }
                  int m = x/3*3;
                  int n = y/3*3;
                  int endm=m+2;
                  int endn=n+2;
                  for(int a=m;a<=endm;a++){
                      for(int b=n;b<endn;b++){
                          if(a!=x && b!=y){
                              if(hs.contains(board[a][b])){
                              hs.remove(board[a][b]);
                      }
                          }
                      }
                  }

//cannot cast Object[] to Character[] 
                  Character[] ccc= new Character[hs.size()];
                  int mx=0;
                  Object[] xxx =hs.toArray();
                  for(Object o:xxx){
                	  ccc[mx++]=(Character) o;
                  }               
                  
                  return ccc;
          }
    
}
