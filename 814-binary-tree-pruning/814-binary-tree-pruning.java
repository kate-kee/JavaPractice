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
    public TreeNode pruneTree(TreeNode root) {
        return containsOne(root);
    }
    TreeNode containsOne(TreeNode root){
        if(root.left!=null)
             root.left=containsOne(root.left);
        if(root.right!=null)
            root.right=containsOne(root.right);
        if(root.val==0 && root.right==null && root.left==null)   
            return null;
        return root;
    }
}