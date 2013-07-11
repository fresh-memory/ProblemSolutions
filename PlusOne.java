public class Solution {
    public int[] plusOne(int[] digits) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] results = new int[digits.length+1];
        int carry =1;
        for(int i=digits.length-1;i>=0;i--){
            if(digits[i]==9){
                digits[i]=0;
            }
            else {
                digits[i]=digits[i]+1;
                return digits;
            }
            
        }
        
        
        results[0]=1;
        for(int j=1;j<results.length;j++){
            results[j]=digits[j-1];
        }    
        return results;
        
    }
}








public class Solution {
    public int[] plusOne(int[] digits) {
        // Start typing your Java solution below
        // DO NOT write main() function
       int len = digits.length;
       int[] res =null;
       if(len==0){
        res= new int[len];
        res[0]=1;
        return res;
       }
       res= new int[len+1];
       int sum=0, carry=1;
       for(int i=len-1;i>=0;i--){
           sum=(digits[i]+carry)%10;
           carry=(digits[i]+carry)/10;
           res[i+1]=sum;
           
       }
       
       if(carry!=0){
       res[0]=carry;
       return res;
       } 
       else{
           int[] res2 = new int[len];
       for(int j =1;j<len+1;j++){
           res2[j-1]=res[j];
       }
       return res2;
    }
}


}
