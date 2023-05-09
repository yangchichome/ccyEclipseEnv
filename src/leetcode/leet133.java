package leetcode;

public class leet133 {

}
/*
//Definition for a Node.
class Node {
 public int val;
 public List<Node> neighbors;
 public Node() {
     val = 0;
     neighbors = new ArrayList<Node>();
 }
 public Node(int _val) {
     val = _val;
     neighbors = new ArrayList<Node>();
 }
 public Node(int _val, ArrayList<Node> _neighbors) {
     val = _val;
     neighbors = _neighbors;
 }
}
*/

class Solution {
 public Node cloneGraph(Node node) {
     if (node == null){
         return null;
     }

     //set Node list
     ArrayList<Node> nodes = getNodes(node);

     //clone nodes
     HashMap<Node, Node> map = new HashMap();
     for(Node n: nodes){
         map.put(n, new Node(n.val));
     }
     
     //clone edges
     for(Node n: nodes){
         Node newNode = map.get(n);
         for(Node e: n.neighbors){
             Node newEdge = map.get(e);
             newNode.neighbors.add(newEdge);
         }
         System.out.println("");
     }

     return map.get(node);
 }

 public ArrayList<Node> getNodes(Node node) {
     Set<Node> set = new HashSet<>();
     Queue<Node> queue = new LinkedList<>();

     queue.offer(node);
     set.add(node);

     while (!queue.isEmpty()) {
         Node n = queue.poll();
         for (Node nei : n.neighbors) {
             if (!set.contains(nei)) {
                 queue.offer(nei);
                 set.add(nei);
             }
         }
     }

     return new ArrayList<Node>(set);
 }

}