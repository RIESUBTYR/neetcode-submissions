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

public class Codec {

    

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String serial = "";
        if(root == null){
            return "";
        }
        Queue<TreeNode> queue = new ArrayDeque();

        queue.add(root);

        while(!queue.isEmpty()){
            TreeNode curr = queue.remove();
            if(curr.val == 1001){
                serial = serial + "N#";
            }
            else{
                serial = serial + curr.val + "#";
                if(curr.left == null){
                    queue.add(new TreeNode(1001));
                }
                else{
                    queue.add(curr.left);
                }
                if(curr.right == null){
                    queue.add(new TreeNode(1001));
                }
                else{
                    queue.add(curr.right);
                }
            }
        }

        return serial;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        System.out.println(data);

        if(data == ""){
            return null;
        }
        String[] nodes = data.split("#");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        queue.add(root);
        int n = 1;

        while (!queue.isEmpty()){
            TreeNode curr = queue.remove();

            if(!nodes[n].equals("N")){
                curr.left = new TreeNode(Integer.parseInt(nodes[n++]));
                queue.add(curr.left);
            }
            else n++;

            if(!nodes[n].equals("N")){
                curr.right = new TreeNode(Integer.parseInt(nodes[n++]));
                queue.add(curr.right);
            }
            else n++;
        }

        return root;
    }
}
