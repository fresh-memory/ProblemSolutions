public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int cur=m+n-1;
        int p=m-1, q=n-1;
        while(p>=0 || q>=0){
            if(p<0 && q>=0){
                A[cur--]=B[q--];
                continue;
            }
            if(q<0){
                break;
            }
            A[cur--]=A[p]<B[q]?B[q]:A[p];
            if(A[p]>B[q]) p--;
            else q--;
        }
        
        
    }
}
