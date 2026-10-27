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

    int count =0;
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> prefix = new ArrayList();
        count = 0;
        prefixCheck(root,prefix,k);

        return prefix.get(k-1);
        
    }

    public void prefixCheck(TreeNode node,List prefix,int k){
        if(node == null) return;
        if(count==k) return;
        prefixCheck(node.left,prefix,k);
        count++;
        prefix.add(node.val);
        prefixCheck(node.right,prefix,k);
    }
}
