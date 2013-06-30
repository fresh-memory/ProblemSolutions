//http://www.cs.utah.edu/~jeffp/teaching/cs7960/L17-MR-Matrix+DB
2 rounds
Mapper1:m(i,j) -> {j, {m,i,m(i,j)}}
        n(j,k) -> {j,{n,k,n(j,k)}}

Reducer1: for same j, for each pair {m,i,m(i,j)} and {n,k,n(j,k)}
        -> {j, {i,k,m(i,j)*n(j,k)}}

Mapper 2:   from reducer1

         -> {(i,k), v1}

Reducer 2: aggregate on (i,k)



1 round:
Mapper1:m(i,j) -> {(i,k),{ M,j, m(i,j)) } //m(i,j) will be used to compute C(i,k) k is decided by number of column of N
        n(j,k) ->{(i,k),{N,j, n(j,k)}} //n(j,k) will be used to compute C(i,k) is is decided by the number of rows in M

Reducer:  sort (M,j,m(i,j)) by j and 
               (N, j, n(j,k)) by j

       for(all pairs of (i,k) with the same j){
         (i,k)->sum(m(i,j)*n(j,k))
       } 


