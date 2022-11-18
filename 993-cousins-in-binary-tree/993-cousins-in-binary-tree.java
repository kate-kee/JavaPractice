/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null)
            return false;
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        q.add(root);
        while(!q.isEmpty()){
            
            int levelSize= q.size();
            List<Integer> l= new ArrayList(levelSize);

             for(int i=0;i<levelSize;i++){

            TreeNode curr=q.poll();
            
            if(curr.left != null && curr.right != null){
            if(curr.left.val==x && curr.right.val==y)
                return false;
            if(curr.right.val==x && curr.left.val==y)
                return false;
        }
            l.add(curr.val);
            if(curr.left!=null){
            q.add(curr.left);
            }
            if(curr.right!=null){
                q.add(curr.right);
            }
       
    }
             if(l.contains(x) && l.contains(y))
                return true;
        }
      return false;  
}
}