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
    int count=0;
    public int goodNodes(TreeNode root) {
    if(root==null)
        return 0;
    preorder(root,root.val);
    return count;
    }
    public void preorder(TreeNode root,int max){
        int curr=root.val;
        if(curr>=max){ 
            max=curr; 
            count++; 
        }
        if(root.left!=null)
        preorder(root.left,max); 
        if(root.right!=null)
        preorder(root.right,max); 
        return;
    }
}