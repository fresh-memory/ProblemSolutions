/*
* Pay attention to  Initialization 
* and how to build up the table
*
*/

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
