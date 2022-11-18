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
    int max_val=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        findMaxPathSum(root);
        return max_val;
    }

    public int findMaxPathSum(TreeNode root){
        if(root==null)
            return 0;
        int currval=root.val;
        int lVal=Math.max(0,findMaxPathSum(root.left));
        int rVal=Math.max(0,findMaxPathSum(root.right));
        max_val=Math.max(max_val,currval+lVal+rVal);
        return Math.max(currval+lVal,currval+rVal);
    }
    
    
    // public int findMaxPathSum(TreeNode curr){
    //     if(curr==null) return 0;
    //     int leftsum=Math.max(findMaxPathSum(curr.left),0);
    //     int rightsum=Math.max(findMaxPathSum(curr.right),0);   
    //     maxi=Math.max(maxi,curr.val+leftsum+rightsum);
    //     return Math.max(leftsum,rightsum)+curr.val;
    // }
}