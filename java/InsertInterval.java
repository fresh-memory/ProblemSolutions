/*
*  Many conditions to consider:
*  
*  new interval smaller than all
*  new interval greater than all
*  merge condition: cur.end>=newInterval.start but newInterval.end not less than cur.start

* if newInterval already inserted just copy the rest of the original
* otherwise need to check if the newInterval become the last one, if so need to append at the end
*
*
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
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Interval> rslt = new ArrayList<Interval>();
        int len = intervals.size();
        for(int i=0;i<len;i++){
            
            Interval itvl_i =intervals.get(i);
            if(newInterval!=null){
                Interval aInterval=null;
                if(itvl_i.end>=newInterval.start){
                    //not overlap samller than cur
                    if(newInterval.end<itvl_i.start){
                        rslt.add(newInterval);
                        rslt.add(itvl_i);
                        newInterval=null;
                    }
                    else{
                       //overlap
                        aInterval= new Interval(Math.min(itvl_i.start, newInterval.start), Math.max(itvl_i.end, newInterval.end));
                        newInterval= aInterval;
                    }
                }
                //not overlap newInterval bigger than cur
                else{
                    rslt.add(itvl_i);
                }
            }
            else{
                 rslt.add(itvl_i);
            }
        
        }
        //newInterval become the last interval
        if(newInterval!=null){
            rslt.add(newInterval);
        }
        
        return rslt;
    }
}
