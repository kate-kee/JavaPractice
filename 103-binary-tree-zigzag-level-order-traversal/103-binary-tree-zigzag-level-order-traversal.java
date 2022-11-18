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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

     Deque<TreeNode> order=new ArrayDeque<TreeNode>();
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        if (root==null)
            return result;
        order.add(root);
        boolean isOdd=false;
        while(!order.isEmpty()){
            int order_size=order.size();
            List<Integer> level=new ArrayList<Integer>();
            for(int i=0;i<order_size;i++){
                if(isOdd==false){
                TreeNode polled=order.pollLast();
                level.add(polled.val);
                    if(polled.left!=null)
                    order.addFirst(polled.left);
                    if(polled.right!=null)
                    order.addFirst(polled.right);
                }
                else{
                 TreeNode polled=order.pollFirst();
                level.add(polled.val);
                    if(polled.right!=null)
                        order.add(polled.right);  
                    if(polled.left!=null)
                        order.add(polled.left);
 
                }
            }
            result.add(level);
            if(isOdd==true)
                isOdd=false;
            else
                isOdd=true;
        }
        return result;
    }
}