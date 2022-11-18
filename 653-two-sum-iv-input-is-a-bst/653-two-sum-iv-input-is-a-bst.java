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
    static Set<Integer> hs;
    public boolean findTarget(TreeNode root, int k) {
        hs=new HashSet<Integer>();
        return inorder(root,k);
    }
    static boolean inorder(TreeNode node,int target){
        if(node==null) return false;
        int rest=target-node.val;
         boolean val=false;
        if(hs.contains(node.val)) 
        return true;
       
        else{
        hs.add(rest);
        if(node.left!=null)
            val=val || inorder(node.left,target);
        if(node.right!=null)
            val=val || inorder(node.right,target);
        }
        return val;
    }
}