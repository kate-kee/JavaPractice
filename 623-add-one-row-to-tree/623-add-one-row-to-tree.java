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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
         if (root == null)
            return null;
        if(depth==1)
        {
           TreeNode n=new TreeNode(val);
            n.left=root;
            return n;
        }
        if(depth==2)
        {
            TreeNode tempL=new TreeNode();
            TreeNode tempR=new TreeNode();
            tempL=root.left;
            root.left=new TreeNode(val);
            root.left.left=tempL;
            tempR=root.right;
            root.right=new TreeNode(val);
            root.right.right=tempR;
            return root;
        }
        if(root.left!=null)
        root.left=addOneRow(root.left,val,depth-1);
        if(root.right!=null)
        root.right=addOneRow(root.right,val,depth-1);
        
        return root;
    }
}