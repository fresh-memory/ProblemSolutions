/*
*   need to consider space normal space between words in the word length count else it will be harder to know the number of words
* that are needed to form a line.......If don't count space, tend to pack more word into a line....
*
*
*
*/

public class Solution {
    public ArrayList<String> fullJustify(String[] words, int L) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        
              
              
              ArrayList<String> arr = new ArrayList<String>();
              if(words.length==0) return arr;
              
              
              int prev=-1;
              int count=0;
              int len=0;
              for(int i=0;i<words.length;i++){
                //  System.out.println(i+"==="+words[i].length());
                  len+= words[i].length();
                 // empty string
                 //if(len!=0)
                 // System.out.println(count+"-"+len);
                  count++;
        
                //  System.out.println(count+"-"+len);
                  if(len+count-1==L){
                      //len=len-count+1;
                     // System.out.println(L+"-"+(prev+1)+"-"+i+"-"+len+"-"+count);

                      arr.add(printAndJustify(words, L, prev+1,i,len,count));
                      prev=i;
                      len=0;
                      count=0;
                  }
                  else if(len+count-1>L){
                   //   len=len-count+1;
                      len=len-words[i].length();
                      i--;
                      count--;
                      //print line and justify it
                    //  System.out.println(L+"-"+prev+1+"-"+i+"-"+len+"-"+count);
                      String line = printAndJustify(words, L, prev+1, i, len, count);
                      arr.add(line);
                      prev=i;
                      len=0;
                      count=0;
                  } 
                  else if(i==words.length-1){
                    //  len=len-count+1;
                      String res ="";
                      for(int j= prev+1;j<=i;j++){
                         if(j!=i)
                         res+=words[j]+" ";
                         else
                         res+=words[j];  
                      }
                      while(len+count-1<L){
                          res+=" ";
                          len++;
                      }
                      
                      arr.add(res);  
                  }
                  
              }
             // System.out.println(arr);
              return arr;
              
          }
          
          String  printAndJustify(String[] words, int L, int start, int end, int len, int count){
              String res="";
             if(start==end){
               res=words[start];
               for(int x=L-len;x>=1;x--){
                   res+=" ";
               }
             
               return res;
             }       
             
             
              int empty= L-len;
             
              
              while(start<end){
                  res+=words[start];
                  start++;
              int pad = empty/(count-1);
                  if(pad*(count-1)<empty){
                         pad=pad+1;
                  }       
                  for(int m=0;m<pad;m++){
                          res+=" ";
                  } 
                  empty=empty-pad;
                  count--;
              }
              
         
               res+=words[end];
               return res;
          
          }
}
