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
