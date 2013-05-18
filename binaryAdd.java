/**
*1.  don't forget convert char to digit using Character.digit(ch,radix)
* Interger.parseInt(String) does not work since char is not string
*2. compute remainder before carrier, otherwise carrier from last round maybe changed to this round's 
*always use carrier from last round
*
*/


public class Solution {
    public String addBinary(String a, String b) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        int len1=a.length()-1;
        int len2=b.length()-1;
        StringBuilder strb =new StringBuilder();
        int sum=0,remainder=0,carrier=0;
        while(len1>=0 && len2>=0){
             sum = Character.digit(a.charAt(len1),10)+Character.digit(b.charAt(len2),10);
             remainder = (carrier+sum)%2;
             carrier = (carrier+sum)/2;
             strb.append(remainder);
             len1--;
             len2--;
        }
        
        if(len1<0){
            
            while(len2>=0){
                sum=0+Character.digit(b.charAt(len2),10);                            remainder = (carrier+sum)%2;
                carrier = (carrier+sum)/2;
                strb.append(remainder);
                len2--;
            }
            
        }
        if(len2<0){
            
            while(len1>=0){
                sum=0+Character.digit(a.charAt(len1),10);
                remainder = (carrier+sum)%2;
                carrier = (carrier+sum)/2;
                strb.append(remainder);
                len1--;
            }
        }
        if(carrier!=0)
            strb.append(carrier);
        String m = strb.toString();
        StringBuilder st = new StringBuilder();
        for(int i=m.length()-1; i>=0;i--){
            st.append(m.charAt(i));
        }
        return st.toString();
    }
}
