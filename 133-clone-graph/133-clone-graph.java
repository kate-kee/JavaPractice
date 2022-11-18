/*
// Definition for a Node.
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
        if(node == null) 
            return null;
        
        //Keep track of visited nodes as well as created clones
        Map<Node, Node> visited = new HashMap<>();
        
        Node cloneNode = new Node(node.val);
        
        visited.put(node, cloneNode);
        
        //Depth First Traversal
        dfs(node, visited);
        
        return cloneNode;
    }
    
    private void dfs(Node node, Map<Node, Node> visited) {        
        Node cloneNode = visited.get(node);
        
        for(Node child : node.neighbors) {
            Node cloneChild = visited.getOrDefault(child, new Node(child.val));
            cloneNode.neighbors.add(cloneChild);
            
            if(!visited.containsKey(child)) {
                visited.put(child, cloneChild);
                dfs(child, visited);
            }
        }
    }
}