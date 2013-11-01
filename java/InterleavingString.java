/* This doc contains three solutions
*
*  2D array DP, 1D array DP, and recursive
*
*/


/*
*  2D array s1 as rows and s2 as  columns
*/


public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len1=s1.length();
        int len2=s2.length();
        int len3=s3.length();
        if(len1+len2!=len3) return false;
        boolean[][] res= new boolean[len1+1][len2+1];
        res[0][0]=true;
        for(int i=1;i<len1+1;i++){
            if(res[i-1][0]&&s3.charAt(i-1)==s1.charAt(i-1)){
              res[i][0]=true;   
            }
            else break;
        }
        
        for(int j=1;j<len2+1;j++){
            if(res[0][j-1]&&s3.charAt(j-1)==s2.charAt(j-1)){
              res[0][j]=true;   
            }
            else break;
        }
        
        for(int i=1;i<len1+1;i++){
            for(int j=1;j<len2+1;j++){
              res[i][j]=res[i-1][j]&&(s1.charAt(i-1)==s3.charAt(i+j-1))|| (res[i][j-1]&&s2.charAt(j-1)==s3.charAt(i+j-1));
         }
        
       }
       return res[len1][len2];
    }

}




/*
*
*  DP 
*  1D table
* Passed large case  see recursive one at the end but it failed large case
*/
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        return helper(s1,0,s2,0,s3,0);
        
        
    }
    
    
    
    public boolean helper(String s1, int p1, String s2, int p2, String s3, int p3){
        
    int n1=s1.length();
    int n2=s2.length();
    int n3=s3.length();
    
    if(n1+n2!=n3) return false;
    //only need to have array of smaller size of the two
    if(n1<n2){
        String temp=s2;
        s2=s1;
        s1=temp;
        n1=s1.length();
        n2=s2.length();
    }
    boolean[] arr = new boolean[n2+1];
    arr[0]=true;   
   
   //initilaize first row
    for(int i=1;i<=n2;i++){
       arr[i]= arr[i-1] && (s3.charAt(i-1)==s2.charAt(i-1));
       if (!arr[i]) break;  
        
    }
    //build the table
    for(int i=1;i<=n1;i++){  
       //iniitalize first column 
       arr[0]=arr[0]&&(s1.charAt(i-1)==s3.charAt(i-1));
       for(int j=1;j<=n2;j++){   
        arr[j]=arr[j]&&s3.charAt(i+j-1)==s1.charAt(i-1) || ( arr[j-1]&&s3.charAt(i+j-1)==s2.charAt(j-1)); 
     
       }
    }
    return arr[n2];
}}









/**
* Recursive
* Failed large case
*
*/

public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        return helper(s1,0,s2,0,s3,0);
        
        
    }
    
    
    
    public boolean helper(String s1, int p1, String s2, int p2, String s3, int p3){
        
        if(p3==s3.length() && p2==s2.length() && p1==s1.length()) return true;
        if(p3!=s3.length() && (p2!=s2.length() || p1!=s1.length())){
            if(p2==s2.length()){
                return s3.substring(p3).equals(s1.substring(p1));
            }
            if(p1==s1.length()){
                return s3.substring(p3).equals(s2.substring(p2));
            }
         if(s3.charAt(p3)==s2.charAt(p2) && s1.charAt(p1)==s3.charAt(p3)){
             return helper(s1,p1, s2, p2+1,s3, p3+1) || helper(s1,p1+1,s2,p2,s3,p3+1);
         }
         if(s3.charAt(p3)!=s2.charAt(p2) && s1.charAt(p1)!=s3.charAt(p3)){
            return false;
         } 
         if(s3.charAt(p3)==s2.charAt(p2)){
             return helper(s1,p1, s2,p2+1, s3, p3+1);
         }
         else{
             return helper(s1,p1+1, s2,p2, s3,p3+1);
         }
            
            
        }
        else return false;
        
    }
    
}
