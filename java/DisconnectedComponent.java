Input:
A, B
B, C
D, E
E, F
C, D
F, B
F, D
G, H
I, H

             /-----\
A - B - C - D - E - F
     \ ------------ /

G - H - I

Output:
A, B, C, D, E, F
G, H, I


     List<Set> connectivity(char[][] graph){
           ArrayList<HashSet<Character>> result = new ArrayList<HashSet<Character>>();
           HashSet<Character> hs1 = new HashSet<Character>();
          
           int len = graph.length;
           for(int i=0;i<len;i++){
               char start = graph[i][0];
               char end = graph[i][1];
               boolean exist=false;
               int pos=-1;
               //int size = result.size();
               for(int j=0;j<result.size();j++){
                 HashSet<Character> cur =  result.get(j);
                  if(cur.contains(start)) || cur.contains(end)){
                      if(exist){
                        HashSet<Character> newSet = merge(result,j,pos);
                        result.add(newSet);
                        result.remove(j);
                        result.remove(pos);
                        break;
                      }
                      else{
                      cur.add(start);
                      cur.add(end);
                      exist=true;
                      pos=j;
                  }
                  
                  
               }
               
               return result;
           }
           
      }
      
     
      }


