public class isValidParenthese {
    public boolean isValid(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
    Stack<Character> st = new Stack<Character>();
    for(int i =0; i<s.length();i++){
        char curr = s.charAt(i);
        if((curr=='{' )||(curr=='[')||(curr=='(' ) ){
            st.push(curr);
        }
        else if((curr=='}' )||(curr==']')||(curr==')' ) ) {
            if(st.isEmpty()) return false;
            if(isMatching(st.peek(), curr))st.pop();
            else return false;
        }
    }
    
    if(st.isEmpty())
        return true;
    else return false;
    }
   
    boolean isMatching(char a, char b){
        if((a=='(' && b==')') ||(a=='[' && b==']')||(a=='{' && b=='}'))
            return true;
    
        else return false;
    }
}
