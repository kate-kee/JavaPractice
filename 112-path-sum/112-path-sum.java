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
    public boolean returnval;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null)
            return false;
        else if(returnval==true)
            return true;
        else if(root.left==null && root.right==null && targetSum-root.val==0)
        return true;
        else if(root.left==null && root.right==null && targetSum-root.val!=0)
        return false;
        else{
            if(root.left!=null)
            returnval=returnval||hasPathSum(root.left,targetSum-root.val);
            if(root.right!=null)
            returnval=returnval||hasPathSum(root.right,targetSum-root.val);
        }
        return returnval;
    }
}