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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res=new ArrayList<Integer>();
        Queue<TreeNode> q= new ArrayDeque<TreeNode>();
        if(root==null)
            return res;
        q.offer(root);
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode curr=q.poll();
                if(i==0){
                    res.add(curr.val);
                }
                if(curr.right!=null)
                    q.offer(curr.right);
                if(curr.left!=null)
                    q.offer(curr.left);
            }
            
        }
        return res;
    }
}