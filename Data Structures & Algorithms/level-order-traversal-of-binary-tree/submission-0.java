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

    public int maxDepth(TreeNode root) {
        return depthSearch(root,-1);
    }

    public int depthSearch(TreeNode root,int depth){
        if(root == null){
            return depth+1;
        }

        int lDepth = depthSearch(root.left,depth+1);
        int rDepth = depthSearch(root.right,depth+1);

        return Math.max(lDepth,rDepth);

    }
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        graph = new ArrayList();
        int height = maxDepth(root);

        for(int i = 0 ; i < height ;i++){
            graph.add(new ArrayList());
        }
        
        insertGraph(root,0);

        return graph;
    }


    public void insertGraph(TreeNode node, int depth)
    {
        if(node == null){
            return;
        }

        graph.get(depth).add(node.val);

        insertGraph(node.left,depth+1);
        insertGraph(node.right,depth+1);
    }
}
