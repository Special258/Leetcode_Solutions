class Solution {

    public boolean isSymmetric(TreeNode root) {

        if (root == null) {
            return true;
        }

        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode root1, TreeNode root2) {

        // Both are null
        if (root1 == null && root2 == null) {
            return true;
        }

        // Only one is null
        if (root1 == null || root2 == null) {
            return false;
        }

        // Values are different
        if (root1.val != root2.val) {
            return false;
        }

        // Compare opposite sides recursively
        return isMirror(root1.left, root2.right)
                && isMirror(root1.right, root2.left);
    }
}