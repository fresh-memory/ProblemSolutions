//DFS solution more expensive than bfs

// pass tests but failed large test     

public static void surrendedRegion(char[][] board) {
            // Note: The Solution object is instantiated only once and is reused by each test case.
            if(board == null || board.length == 0) return;
            int nrows = board.length;
            int ncol = board[0].length;
            for(int i = 0; i < nrows; i++) {
                for(int j = 0; j <ncol; j++) {
                    if(board[i][j] == 'X') continue;
                    boolean colorable = color(board, i, j, 'O', '3');
                    if(colorable) {
                        color(board, i, j, '3', 'X');
                    }
                    else {
                        color(board, i, j, '3', '0');
                    }
                }
            }
            for(int i = 0; i < nrows; i++) {
            	System.out.print("\n");
            	for(int j =0; j < ncol; j++){
            		System.out.print(board[i][j]);
            	}
            }
        }
        
        
        public static boolean color(char[][] board, int startx, int starty, char from,  char to) {
            if(startx >= board.length || starty >= board[0].length) return false;
            if(board[startx][starty] == 'X') {
                return true;
            }
            else if(board[startx][starty] == from) {
                board[startx][starty] = to;
            }
            boolean blow = color(board, startx+1, starty, from,  to);
            boolean right = color(board, startx, starty+1, from, to);
            return blow && right;
        }

    
