/*
* Pay attention to  Initialization 
* and how to build up the table
*  condition 1 : p.charAt(j) == '*' res[i][j] decided by (res[i-1][j-1] ||res[i-1][j] ||res[i][j-1])
*  condition 2 :p.charAt(j) != '*'  then match or not match i-1,j-1
  res[i][j] decided by (res[i-1][j-1])
*/






public class Solution {
    public boolean isMatch(String s, String p) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int lens=s.length();
        int lenp=p.length();
        //rotating array
        boolean[][] dp = new boolean[2][lenp+1];
        dp[0][0]=true;
        for(int i=1;i<lenp+1;i++){
            if(p.charAt(i-1)=='*'){
               dp[0][i]=dp[0][i-1];
            }
            else{
               dp[0][i]=false;

            }
        }

        for(int i=1;i<lens+1;i++){
            char a = s.charAt(i-1);
            for(int j=1;j<lenp+1;j++){
                char b = p.charAt(j-1);
                if(a==b || b=='?'){
                    dp[i%2][j]=dp[(i-1)%2][j-1];
                }
                else if (b=='*'){

                    dp[i%2][j]=(dp[(i-1)%2][j-1] || dp[(i-1)%2][j]||dp[i%2][j-1]);
                }
                //a!=b
                else{
                    dp[i%2][j]=false;
                }
            }

        }


        return dp[lens%2][lenp];

    }
}



public class Solution {
		public boolean isMatch(String s, String p) {
			// Start typing your Java solution below
			// DO NOT write main() function

			int lens = s.length();
			int lenp = p.length();

			boolean[][] res = new boolean[lenp + 1][lens + 1];
			// Arrays.fill(res[0],false);
			res[0][0] = true;
			for (int j = 1; j < lenp + 1; j++) {
				if (p.charAt(j - 1) == '*' && res[j - 1][0])
					res[j][0] = true;
				else
					res[j][0] = false;
			}

			for (int i = 0; i < lenp; i++) {
				char c = p.charAt(i);
				for (int j = 0; j < lens; j++) {
					char cs = s.charAt(j);
					if (c == '*') {
						if (res[i][j] || res[i][j + 1]) {
							for (; j < lens; j++) {
								res[i + 1][j + 1] = true;
							}
						}
					} else if (c == '?' || c == cs) {

						res[i + 1][j + 1] = res[i][j];
					} else
						res[i + 1][j + 1] = false;
				}

			}
			return res[lenp][lens];
		}
	}
