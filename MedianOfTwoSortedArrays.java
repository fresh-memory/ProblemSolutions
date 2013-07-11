/*
*    Left in A, right in B
*    l>r reverse
*
*/
public class Solution {
    double findMedian(int A[], int B[], int l, int r, int lenA, int lenB) {
        //??? 
        
        // l, r both are indices of shorter array A
        if (l>r) 
            return findMedian(B, A, Math.max(0, (lenA+lenB)/2-lenA), Math.min(lenB-1, (lenA+lenB)/2), lenB, lenA);
       //ASSERT(i+j+1=(l+r)/2) invariant
        int i = (l+r)/2;
        int j = (lenA+lenB)/2 - i - 1;
        
        if (j>=0 && A[i] < B[j]) return findMedian(A, B, i+1, r, lenA, lenB);
        else if (j<lenB-1 && A[i] > B[j+1]) return findMedian(A, B, l, i-1, lenA, lenB);
        // A[i]>=B[j] && A[i]<=B[j+1] ======> find candidate
        else {
            //odd
            if ( (lenA+lenB)%2 == 1 ) return A[i];
            //even 
            if (i>0) { 
                //A=3 5 7
                //B=4 6 8
                //or
                //A=1 3 5 6
                //B=7 8
                int pre = (j < 0) ? A[i - 1] : Math.max(B[j], A[i-1]);
                return (A[i]+pre)/2.0;
            }
            //i==0
            return (A[i]+B[j])/2.0;
        }
    }

    double findMedianSortedArrays(int A[], int B[]) {     
        return findMedian(A, B, Math.max(0, (B.length+A.length)/2-B.length), Math.min(A.length-1, (B.length+A.length)/2), A.length, B.length);
    }
}














public class Solution {
  private double findMedian(int A[], int B[], int left, int right) {  
   int m = A.length, n = B.length, mid = (m+n)/2;  
   if (left > right) {  
     return findMedian(B, A, Math.max(0, mid-m), Math.min(n-1, mid));  
   }  
     
   int indexI = (left+right) / 2, j = mid - indexI - 1;  
   if (j >= 0 && A[indexI] < B[j]) // A[indexI] < median  
     return findMedian(A, B, indexI+1, right);  
   if (j < n-1 && A[indexI] > B[j+1]) // A[indexIi] > median  
     return findMedian(A, B, left, i-1);  
   // m+n is odd  
   if ( ((m+n) & 0x1) > 0 || (i <= 0 && (j < 0 || j >= n)))  
     return A[indexI];  
   // m+n is even  
   if (j < 0 || j >= n)  
     return (A[indexI] + A[indexI-1]) / 2.0;  
   if (i <= 0)  
     return (A[indexI] + B[j]) / 2.0;  
   return (A[indexI] + Math.max(B[j], A[indexI-1])) / 2.0;  
 }  
   
 public double findMedianSortedArrays(int A[], int B[]) {  
   int m = A.length, n = B.length, mid = (m+n)/2;  
   if (m<n)  
     return findMedian(A, B, Math.max(0, mid-n), Math.min(m-1, mid));  
   else  
     return findMedian(B, A, Math.max(0, mid-m), Math.min(n-1, mid));  
 } 
}
