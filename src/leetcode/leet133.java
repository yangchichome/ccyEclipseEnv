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
     if (node == null) return null;
     // get Node to List
     List<Node> nodes = getNodes(node);

     //Map node to new node with same val
     Map<Node,Node> map = new HashMap<>();
     for(Node n: nodes){
         if (!map.containsKey(n)){
             map.put(n, new Node(n.val));
         }
     }

     //Create node2
     for(Node n:nodes){
         Node nodeNew = map.get(n);
         for(Node neighbor: n.neighbors){
             Node neiNew = map.get(neighbor); 
             nodeNew.neighbors.add(neiNew);
         }
     }

     return map.get(node);
 }

 private List<Node> getNodes(Node node){
     Queue<Node> queue = new LinkedList<>();
     HashSet<Node> set = new HashSet<>();

     queue.offer(node);
     set.add(node);
     while(!queue.isEmpty()){
         Node head = queue.poll();
         for(Node n: head.neighbors){
             if (!set.contains(n)){
                 set.add(n);
                 queue.offer(n);
             }
         }
     }

     return new ArrayList<Node>(set);
 }
}