/*
*
* Recursive O(n^n)or DP O(n^4)
*  This is the DP one
*/

public class Solution {
    public boolean isScramble(String s1, String s2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len1 = s1.length();
        int len2 = s2.length();
        if(s1.equals(s2)) return true;
        if(len1!=len2) return false;
        
        boolean[][][] array3D = new boolean[len1][len2][len1];
        for(int i=0;i<len1;i++){
            for(int j=0;j<len2;j++)
             array3D[i][j][0]=(s1.charAt(i)==s2.charAt(j));
        }

        // k at the outer loop is better for boundry check
        for(int k=1;k<len1;k++){
          for(int i=0;i<len1-k;i++){
            for(int j=0;j<len2-k;j++){
                
                    array3D[i][j][k]=false;
                    for(int x=0;x<k;x++){
                        
                    //break k step into difiernt chunks
                    // s1 from index i, s2 from index j, length of k  is scamble string iff 
                    // i~i+x of s1 is scramble string of s2's substring  from j to j+x  
                    // and the rest of k-x-1 length string is scramble string to each other

                    // or s1 from left s2 from right length of x is scramble string and rest of k-x-1 of the two
                    // is scramble string to each other.
                        if((array3D[i][j][x]&&array3D[i+x+1][j+x+1][k-x-1])
                         ||(array3D[i][j+k-x][x]&&array3D[i+x+1][j][k-x-1]))
                        {
                    
                           array3D[i][j][k]=true;
                           break;
                       }
                    
                    }
                }
            }
        }
        
        return array3D[0][0][len1-1];
        
    }
}
