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
    public boolean isBalanced(TreeNode root) {

        if(root == null) return true;

        int ldepth = maxHeight(root.left);
        int rdepth = maxHeight(root.right);

        boolean isBalancedNode = Math.abs(ldepth-rdepth)<=1;

        return isBalancedNode && isBalanced(root.left) && isBalanced(root.right);
        
    }

    public int maxHeight(TreeNode root){
        if(root == null) return 0;

        return 1+Math.max(maxHeight(root.left),maxHeight(root.right));
    }
}
