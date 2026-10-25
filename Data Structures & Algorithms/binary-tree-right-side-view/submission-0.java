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
    List<List<Integer>> graph;
    public List<Integer> rightSideView(TreeNode root) {
        graph = new ArrayList();
        depthSearch(root,0);

        List<Integer> output = new ArrayList();

        for(int i = 0;i<graph.size();i++){
            output.add(graph.get(i).get(graph.get(i).size()-1));
        }

        return output;
        
    }

    public void depthSearch(TreeNode node, int depth){
        if(node == null){
            return;
        }

        if(graph.size() == depth){
            graph.add(new ArrayList());
        }

        graph.get(depth).add(node.val);
        depthSearch(node.left,depth+1);
        depthSearch(node.right,depth+1);
    }
}
