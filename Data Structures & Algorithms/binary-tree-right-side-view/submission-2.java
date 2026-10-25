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
 
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> output = new ArrayList();
        depthSearch(root,output,0);

        return output;
    }

    public void depthSearch(TreeNode node,List<Integer> output, int depth){
        if(node == null){
            return;
        }

        if(output.size() == depth){
            output.add(node.val);
        }

        depthSearch(node.right,output,depth+1);
        depthSearch(node.left,output,depth+1);
    }
}
