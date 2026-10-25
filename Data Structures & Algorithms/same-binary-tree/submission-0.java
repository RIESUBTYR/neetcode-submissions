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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return traversal(p).equals(traversal(q));
    }

    public String traversal(TreeNode root){
        if(root == null){
            return "";
        }

        String left = root.left == null ? " " : ""+traversal(root.left);
        String right = root.right == null ? " " : ""+traversal(root.right);

        return ""+root.val+left+right;
    }
}
