/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    StringBuilder str_enc=new StringBuilder();
    StringBuilder str_dec=new StringBuilder();
    public void preorder(TreeNode root){
        if(root==null){
            return;
        }
        str_enc.append(root.val);
        str_enc.append(',');
        if(root.left==null)
            str_enc.append('/');
        else
            preorder(root.left);
        if(root.right==null)
            str_enc.append('/');
        else
            preorder(root.right);
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root){
        preorder(root);
        return str_enc.toString();
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data){
        Queue<Integer> s=new LinkedList<Integer>();
        char[] t=data.toCharArray();
        if(data.isEmpty())
            return null;
        int size=t.length;
        int i=0;
        while(i<size){
            
            if(t[i]==',')
            {
                i++;
            }
            else if(t[i]=='/'){
                s.add(1001);
                i++;
            }
            else{
            StringBuilder ch=new StringBuilder();
            while(t[i]!=','){
                ch.append(t[i]);
                i++;
            }
            s.add(Integer.valueOf(ch.toString()));
            }
            
        }
        // while(!s.isEmpty()){
        // System.out.println(s.poll());}
        
        TreeNode root=deserial(s);
        return root;
    }
    
    public TreeNode deserial(Queue<Integer> s){
        TreeNode root=new TreeNode();
        if(!s.isEmpty()){
         int c=s.poll();
            if(c==1001){
                return null;
            }
            else{
                root.val=c;
                root.left=deserial(s);
                root.right=deserial(s);
            }
        }
        return root;
    }
}
// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));