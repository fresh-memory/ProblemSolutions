int findPrime(int count){
        ArrayList<Integer> al=new ArrayList<Integer>();
        int i=1;

        while(count>0){
            i++;
            for(int j=0;j<al.size() && al.get(j)*al.get(j)<=i;j++){
                if(i%al.get(j)==0){
                    continue loop;
                }
            }

            al.add(i);
            count--;
        }
       
        return al.get(al.size()-1);
    }
