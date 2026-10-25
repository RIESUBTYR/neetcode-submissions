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
    public int goodNodes(TreeNode root) {
        return dfs(root,root.val);
    }

    public int dfs(TreeNode node, int maxValue)
    {
        if(node == null) return 0;
        int goodNode = 0;
        if(node.val >= maxValue){
            goodNode = 1;
            maxValue= node.val;
        }
        return goodNode + dfs(node.left,maxValue) + dfs(node.right,maxValue);
    }
}
