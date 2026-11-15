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
        int index=0;
        HashMap<Integer,Integer> in = new HashMap();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++){
            in.put(inorder[i],i);
        }

        return buildTree(0,preorder,preorder.length-1);

    }

    public TreeNode buildTree(int l, int[] preorder,int r ){
        if(l>r) return null;
        int val = preorder[index++];
        TreeNode rt = new TreeNode(val);
        int inOrderIndex = in.get(val);
        rt.left = buildTree(l,preorder,inOrderIndex-1);
        rt.right = buildTree(inOrderIndex+1,preorder,r);

        return rt;

    }

}
