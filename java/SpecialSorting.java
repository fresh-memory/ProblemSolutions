/*
*  Given an array contains integers, sort the array to make it represent the biggest number
*  3, 93 -> 93,3
*  69, 6 ->69,6  as 696 >669
*/ 

   static ArrayList<Integer> specialSorting(ArrayList<Integer> arr){
        	 Collections.sort(arr, Solution.comp);
        	 return arr;
         }
         
        public static  Comparator<Integer> comp = new Comparator<Integer>(){
        	  @Override
  			public int compare(Integer a, Integer b) {
        	 // int compare(int a, int b){
        		  int at =a;
        		  int bt=b;
        		  int counter=0;
        		  int att=0, btt=0;
        		  while(at>0 ||bt>0){
        			  if(at==0){att=counter;}
        			  if(bt==0){btt=counter;}
        			  at/=10;
        			  bt/=10;
        			  counter++;
        		  }
        		  if(att==0) att=counter;
        		  if(btt==0) btt=counter;
        	     int ab=(int)(a*Math.pow(10, btt)+b);
        	     int ba= (int) (b*Math.pow(10,att));
        		  if(ab>ba )
        		   return -1;
        		  else if(ab<ba) return 1;
        		  else return 0;
        	  }
          };
