class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        // Swap left and right children
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // Recurse on left and right subtrees
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}