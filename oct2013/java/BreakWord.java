// build the table from the beginning, true means from substring(0, current index) is breakable
// it depends on breakAble[j] + dict.contains( substring(j,i))

//O(n^2) time solution

public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int len = s.length();
        boolean[] breakAble = new boolean[len+1];
        breakAble[0]=true;
       
        for(int i = 1; i < len+1; i++){
            for(int j = 0; j < i; j++){
                if(breakAble[j] && dict.contains(s.substring(j, i))){
                    breakAble[i] = true;
                    break;
                }
            }
        }
        return breakAble[len];
    }
}
