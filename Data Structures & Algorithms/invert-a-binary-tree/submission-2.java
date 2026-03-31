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
    List<Integer> res = new ArrayList<>();
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;
        }
        TreeNode a = root.left;
        TreeNode b = root.right;
        
        root.left = b;
        root.right = a;
        invertTree(root.left);
        invertTree(root.right);
        return root;
        
    }
}
