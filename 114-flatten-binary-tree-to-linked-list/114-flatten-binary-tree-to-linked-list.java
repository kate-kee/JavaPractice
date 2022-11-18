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
    public void flatten(TreeNode root) {
        while(root!=null){
            if(root.left!=null){
              TreeNode leftTree=root.left;  
            
            while(leftTree.right!=null){
                leftTree=leftTree.right;}
            leftTree.right=root.right;
            root.right=root.left;
            root.left=null;
            }
            root=root.right;
        }
        
        }
}