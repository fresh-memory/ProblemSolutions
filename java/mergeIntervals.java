/**
* Sort the interval using start and then end
* O(nlogn)
* find and insert could be O(n2)
*/


/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        if(intervals==null) return null;
        if(intervals.size()==0) return intervals;
        Comparator<Interval> comparator = new Comparator<Interval>(){
           
           @Override
            public int compare(Interval itv1, Interval itv2){
                if(itv1.start>itv2.start) return 1;
                else if (itv1.start < itv2.start) return -1;
                else {
                    if(itv1.end>itv2.end){
                        return 1;
                    }
                    else if(itv1.end < itv2.end) {
                        return -1;
                    }
                    else return 0;
                }
                
            }
        };
    
    Collections.sort(intervals, comparator);
    ArrayList<Interval> res = new ArrayList<Interval>();
    Interval currInt = intervals.get(0);
    for(int i=1; i <intervals.size();i++){
        Interval it2 = intervals.get(i);
        if(currInt.end < it2.start){
             res.add(currInt);
             currInt=intervals.get(i);
         }
         else{
             int newStart = currInt.start>it2.start?it2.start:currInt.start;
             int newEnd=currInt.end>it2.end?currInt.end:it2.end;
             currInt = new Interval(newStart, newEnd);
             
         }
    }
    res.add(currInt);
    return res;
}
    
    
}






//no extra space solution



/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        //as we modify the arraylist when traversing it
        // we'd be better traverse from end to begin
        // from end to begin decides we need to sort the intervals based on the
        // end value of the interval
        
        Comparator<Interval> comp = new Comparator<Interval>(){
          @Override            
         public int compare(Interval intv2, Interval intv1){
             //ascendingly
              if(intv1.end<intv2.end) return 1;
              if(intv1.end==intv2.end){
                   if(intv1.start<intv2.start) return 1;
                   if(intv1.start==intv2.start) return 0;
                   else return -1;
               }
               else return -1;
                
            }
        };
        
        Collections.sort(intervals, comp);
        
        //Assuming intervals are sorted by first key
        int size=intervals.size();
        if(size==0) return intervals;
        Interval cur = intervals.get(size-1);
        for(int i=size-1;i>=0;i--){
            Interval ii = intervals.get(i);
            if(cur.start<=ii.end){
                intervals.remove(i);
                cur = new Interval(Math.min(cur.start,ii.start), Math.max(cur.end, ii.end));
            }
            else{
                intervals.add(i+1,cur);
                cur=ii;
                intervals.remove(i);
            }
            
        }
        
        //don't forget
        intervals.add(0,cur);
        
        return intervals;
        
    }
    
 
}
