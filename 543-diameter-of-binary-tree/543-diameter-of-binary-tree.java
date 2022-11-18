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
     int res = 0;
    public int height(TreeNode root){
        if(root == null) return 0;
        int lh = height(root.left);
        int rh = height(root.right);
        res = Math.max(lh+rh , res);
        return 1 + Math.max(lh, rh);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        int ans = height(root);
        return res;
    }
}