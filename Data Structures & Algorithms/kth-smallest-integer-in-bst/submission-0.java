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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> prefix = new ArrayList();

        prefixCheck(root,prefix);

        return prefix.get(k-1);
        
    }

    public void prefixCheck(TreeNode node,List prefix){
        if(node == null) return;
        prefixCheck(node.left,prefix);
        prefix.add(node.val);
        prefixCheck(node.right,prefix);
    }
}
