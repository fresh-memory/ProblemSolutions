/*
*  
* similar to word segmentation
* break the string into two parts and further break down one layer until find valid ip component 
* probbaly better to do recursive breakdown
/

public class Solution {
    public ArrayList<String> restoreIpAddresses(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
    ArrayList<String> arr = new ArrayList<String>();
    
    if(s==null || s.length()>12 || s.length()<4)
        return arr;
    
      
                for(int i=1;i<s.length()-2;i++){
                    ArrayList<String> left = restoreHelper(s.toCharArray(),0,i);
                    ArrayList<String> right =  restoreHelper(s.toCharArray(),i+1,s.length()-1);
                    
                    if(left.size()!=0 && right.size()!=0){
                        for(String s1:left){
                            for(String s2:right){
                                arr.add(s1+"."+s2);
                            
                        }
                    
                    }
                }}
        return arr;
    }
    
    
    public ArrayList<String> restoreHelper(char[] s, int start, int end){
                ArrayList<String> arr = new ArrayList<String>();
    
                int len=s.length;
                if(end-start<1 || (end-start)>5){
                    return arr;
                }
                 for(int j=start;j<=end-1;j++){
                    if(isValidIPComponent(s,start,j) && isValidIPComponent(s,j+1,end)){
                        String left="";
                        for(int k=start;k<=j;k++){
                         left+=String.valueOf(s[k]);
                        }
                        left=left+".";
                        for(int k=j+1;k<=end;k++){
                         left+=String.valueOf(s[k]);
                        }
                        arr.add(left);
                    }

                 }
                 
              
            return arr;
    }
    
    
    boolean   isValidIPComponent(char[] s,int start, int end){
        
         int digit=0, num=0;
        for(int i=start;i<end+1;i++){
            digit=(int)s[i]-(int)'0';
            num=num*10+digit;
        }
        
        if(end-start<0 || end-start>3 || num>255 || num <0 ||(end-start>0 &&s[start]=='0')) return false;
        
        else return true;
    }
    

}
