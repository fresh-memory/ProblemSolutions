/*
*
* Not optimal solution, failed large test
* 
*
/

    public int numDecodings(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s==null ||s.equals("")) return 0;
        int length=s.length();
        int x=Integer.parseInt(s);
        // must define 0
        if(s.charAt(0)=='0' || s.equals("0")){
            return 0;
        }
        if(x<=10 && x>0){
            return 1;
        }
        if(x<=26){
            return 2;
        }
        if(x<100 && x>=27){
            if(!s.contains("0")){
                return 1;
            }
        else return 0;
        
        }
        
        int sum=0;
        for(int i=0;i<length-1;i++){
            //301 =>30,1 the first part is not valid
            //avoid duplicate addition 1029 =>(10,29 102,9)
            int t = Integer.parseInt(s.substring(0,i+1));
            if(t>0 && t<27){
            sum+=numDecodings(s.substring(i+1,length));
            }
        }
        return sum;
        
    }
