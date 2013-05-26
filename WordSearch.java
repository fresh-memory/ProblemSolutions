/** 
     DFS recursive
*
* Note how to avoid a flag[][] by changing the cell to an impossible character
*
* Also be careful about the edge case. See comment inline.
*
*
/
public class Solution {
       
          public static boolean exist(char[][] board, String word) {
            // Start typing your Java solution below
            // DO NOT write main() function
            if(word==null || board==null ||word.length()==0) return false;
            char[] w = word.toCharArray();
          // boolean[][] flags= new blooean[board.size()][board[0].size()];
           int rowsize=board.length;
           int colsize=board[0].length;
           for(int i=0;i<rowsize;i++){
               for(int j=0;j<colsize;j++){
               // boolean[][] flags= new boolean[rowsize][colsize];
              //  System.out.println(flags[0][0]);
                   if(existHelper(board, i, j, w, 0 ))
                     return true;
                    }
               }
            return false;
        }   
        public static boolean existHelper(char[][] board,int curi,int curj, char[] w, int x){
           int rowsize=board.length;
           int colsize=board[0].length;
           int  wsize=w.length;
           //what's the default value for boolean array? false since they are null;   
           boolean up=false,down=false,left=false, right=false;
                   if(x<wsize){
                     if (board[curi][curj]==w[x]){
                         char c= board[curi][curj];
                        // a good way to avoid flag[][]
                    	 board[curi][curj]='0';
                        // under this condition no recursive call at all but cannot return false since this is true scenario
                        if(wsize==x+1) return true;
                        if(curi+1<rowsize){
                            down=existHelper(board, curi+1, curj, w, x+1);
                            //flag[curi+1][curj]=true;
                            if(down) return true;
                        }
                        if(curj+1<colsize){
                            right=existHelper(board, curi, curj+1,w,  x+1);
                            //flag[curi][curj+1]=true;
                            if(right) return true;
                        }
                        
                        if(curi-1>=0){
                            up=existHelper(board, curi-1, curj, w, x+1);
                            //flag[curi-1][curj]=true;
                            if(up) return true;
                        }
                        
                        if(curj-1>=0){
                            left=existHelper(board, curi, curj-1,w, x+1);
                           if(left) return true;
                        }
                        board[curi][curj]=c;
                      // cannot return false directly what if w just have one character 
                      //added the check at the begining;
                     return false;
                    }//word[x] does not match any next Neighbor char
                    else return false;
                    
                   }//reach the end of word
                   else{
                       return true;
                   }
            }
       
}
