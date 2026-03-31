class Solution {
    boolean ans = true;

    public boolean isBalanced(TreeNode root) {
        return isbalanced(root);
    }

    public boolean isbalanced(TreeNode root){
        if(root == null){
            return true;
        }

        int l = depth(root.left);
        int r = depth(root.right);

        // check current node + left subtree + right subtree
        boolean ans = isTrue(l, r) 
                      && isbalanced(root.left) 
                      && isbalanced(root.right);

        return ans;
    }

    public boolean isTrue(int x, int y){
        if(x - y == 0 || x - y == 1 || x - y == -1){
            return true;
        } else {
            return false;
        }
    }

    public int depth(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = depth(root.left) + 1;
        int right = depth(root.right) + 1;

        if(left >= right){
            return left;
        } else {
            return right;
        }
    }
}
