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
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> level=new ArrayDeque<TreeNode>();
        level.add(root);
        List<Double> result=new ArrayList<Double>();
        while(!level.isEmpty()){
            int lsize=level.size();
            double sum=0;
            for(int i=0;i<lsize;i++){
                TreeNode p=level.poll();
                sum+=p.val;
                if(p.left!=null)
                    level.add(p.left);
                if(p.right!=null)
                    level.add(p.right);
            }
            result.add(sum/lsize);
        }
    return result;
    }
}