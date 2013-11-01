/*
*    Find the local minimum then update on directions on two sides  
*    
*/

public class Solution {
    public int candy(int[] ratings) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int len = ratings.length;
        if(ratings == null || len ==0) return 0;
        int[] pos  = new int[ratings.length];
        for(int i = 0; i < ratings.length; i++) {
             //find local minimum --the bottom
           
	    if((i+1 == ratings.length || ratings[i+1] >= ratings[i])  && (i == 0 || ratings[i] <= ratings[i-1])) {
                pos[i] = 1;
                int j = i;
                //look back
                while( j-1 >=0 && ratings[j-1] > ratings[j] ) {
                    //cover the peek twice one from the previous look forward and one from this look back
                    //so need to take the max
                    pos[j-1] = Math.max(pos[j-1], pos[j] + 1);
                    j--;
                }
                j = i;
		//look forward
                while( j+1 < ratings.length && ratings[j+1] > ratings[j]) {
                    pos[j+1] = pos[j]+1;
                    j++;
                }
                
            }
        }
        int count = 0;
        for(int i  = 0; i < pos.length; i++) {
            count +=pos[i];
        }
        
        return count;
    }
}






// an easier way to write code :
// from left to right, update when ratings increase, otherwise 1. if ratings[i] < ratings[i+1], pos[i+1]=pos[i]+1; else pos[i+1]=1; 
// from right to left, update when ratings increase, otherwise 1. if ratings[i] < ratings[i-1], pos[i-1]= max(pos[i-1],pos[i]+1); else =1;

//Algorithm O(N), memory O(N)
public int candy(int[] ratings) {
   int i,k,len = ratings.length,sum=len;
   int[] res = new int[len];

   for(k=1,i=0;i<len;i++)
       if( (i-1)>=0 && ratings[i]>ratings[i-1] )    res[i]=Math.max(k++, res[i]);
       else                                         k=1;

   for(k=1,i=len-1;i>=0;i--)
       if((i+1)<len && ratings[i]>ratings[i+1] )    res[i]=Math.max(k++, res[i]);
       else                                         k=1;

   for(i=0;i<len;i++)
       sum+=res[i];

   return sum;
}


