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
    List<Integer> output;
    public List<Integer> rightSideView(TreeNode root) {
        output = new ArrayList();
        depthSearch(root,0);

        return output;
    }

    public void depthSearch(TreeNode node, int depth){
        if(node == null){
            return;
        }

        if(output.size() == depth){
            output.add(node.val);
        }

        depthSearch(node.right,depth+1);
        depthSearch(node.left,depth+1);
    }
}
