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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        List<Integer> pre2 = preorderTraversal(p);
        List<Integer> pre1 = preorderTraversal(q);
        if (pre1.size() != pre2.size()) return false;

        for (int i = 0; i < pre1.size(); i++) {
            if (!pre1.get(i).equals(pre2.get(i))) {
                return false;
            }
        }
        return true;



    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preOrder(root,result);
        return result;
        
    }
    public void preOrder(TreeNode node,List<Integer> result){
        if(node==null){
            result.add(0);
            return;
        }
        result.add(node.val);
        preOrder(node.left,result);
        preOrder(node.right,result);
    }
    
    
}
