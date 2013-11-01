/*   output the most frequent consecutive characters
*
 * "this is a sentence" => [t, h, i, s, i, s, a, s, e, n, t, e, n, c, e]
"thiis iss a senntencee" => [i, s, n, e]
"thiisss iss a senntttenceee" => [s, t, e]
"thiisss iss a sennnntttenceee" => [n]
 * @param args
 */
	
	
	
	public ArrayList<Character> topChar(char[] str){
		ArrayList<Character> arr = new ArrayList<Character>();
		if(str.length==0) return arr;
		int count=1, max=0; char cur=str[0];
		for(int i=1;i<str.length;i++){
			if(str[i]==' ') continue;
			if(str[i]==cur){
				count++;
			}
			else{
				if(count>max){
					arr.clear();
					arr.add(cur);
					max=count;
				}
				else if(count==max){
					arr.add(cur);
				}
				cur=str[i];
				count=1;
		    }		
		}
		//don't miss 
		if(count==max){arr.add(cur);}
		
		return arr;
	}
	
	
