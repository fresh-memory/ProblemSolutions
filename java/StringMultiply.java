/*
* O(m+n) one dimension array space
* O(mn) time
* Key point : observe the pos of product with the operand 
* compact the addition matrix into one dimension
* Pass large test 
*/

public class Solution {
    public String multiply(String num1, String num2) {
            int len1=num1.length();
            int len2 = num2.length();
            if(num1.equals("0") || num2.equals("0")) return "0";
        int[] res= new int[len2+len1];
        for(int i=len2-1;i>=0;i--){
            int b = num2.charAt(i)-'0';
            int sum=0, carry=0;
            for(int j=len1-1;j>=0;j--){
                int a = num1.charAt(j)-'0';
                //key idea
                sum=a*b+carry+res[len1+len2-2-i-j];
                res[len1+len2-2-i-j]=sum%10;
                carry=sum/10;
            }
            if(carry>0) res[len1+len2-1-i]+=carry;
        }
        
        StringBuilder strBuilder = new StringBuilder();
        for(int i=0;i<len1+len2;i++){
              strBuilder = strBuilder.insert(0,res[i]);
        }
        String str = strBuilder.toString();
        if(str.charAt(0)=='0') return str.substring(1);
        else
        return str;
    }
    
    
}
