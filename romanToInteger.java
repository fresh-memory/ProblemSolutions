/**
* start the processing from end.
* encounter smaller value  subtract from sum
* encounter large value sum to sum
*
*Should know the value of each character in Roman vocabulary
*
/


public class Solution {
    
    public int romanToInt(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        if(s==null) return 0;
        if(s.trim()=="") return 0;
    HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
    hm.put('I',1);
    hm.put('V',5);
    hm.put('X',10);
    hm.put('M',1000);
    hm.put('D',500);
    hm.put('C',100);
    hm.put('L',50);
    
    
    int length=s.length();
   
    int curr=hm.get(s.charAt(length-1));
    if(length==1){ 
        return curr;
    }
    int sum = curr;
    int pre=0;
    for(int i= length-2; i>=0;i--){
        pre =hm.get(s.charAt(i));
        if(curr > pre) sum-=pre;
        else sum+=pre;
        curr=pre;
    }
    
    return sum;
}

}
