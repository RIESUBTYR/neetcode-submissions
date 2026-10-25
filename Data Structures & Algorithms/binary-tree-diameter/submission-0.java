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
    int maximum =0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        int ldepth = dia(root.left);
        int rdepth = dia(root.right);
        int rootDia = ldepth+rdepth;
        int sub = Math.max(diameterOfBinaryTree(root.left),diameterOfBinaryTree(root.right));
        return Math.max(rootDia,sub);
    }

    public int dia(TreeNode root){
        if(root == null) return 0;

        return 1+Math.max(dia(root.left),dia(root.right));
    }
}
