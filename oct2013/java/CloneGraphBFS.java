//key is to create HashMap<OrigirnalNode, CopiedNode>

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
       // HashMap<UndirectedGraphNode, Boolean> map = new HashMap<UndirectedGraphNode, Boolean>();
        if(node == null) return null;
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
        UndirectedGraphNode newHead = new UndirectedGraphNode(node.label);
        map.put(node, newHead);
      
        q.add(node);
      
        while(!q.isEmpty()) {
            UndirectedGraphNode nodex = q.poll();
            UndirectedGraphNode curNode = null;
            if(!map.containsKey(nodex)) {
                curNode = new UndirectedGraphNode(nodex.label);
                map.put(nodex, curNode);
            }
            else {
                curNode = map.get(nodex);
            }
            for(UndirectedGraphNode n : nodex.neighbors) {
                 //unvisited node, add to queue
                if(map.containsKey(n)) {
                    curNode.neighbors.add(map.get(n));
                    // cannot include, otherwise will have duplicate
                    //map.get(n).neighbors.add(curNode);
                }
                else {
                    q.add(n);
                    UndirectedGraphNode cpNode = new UndirectedGraphNode(n.label);
                    map.put(n, cpNode);
                    curNode.neighbors.add(cpNode);
                 // to avoid duplicate
                  //  cpNode.neighbors.add(curNode);
                }
            }
        }
        return newHead;
    }
}
