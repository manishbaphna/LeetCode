
class MaxDiffNodeAndAncestor {

    private int diffImpl(TreeNode node, int parent) {
        if ( node == null )
            return 0;

        int localMax = Math.abs(node.val - parent);
        if (node.left != null )
            localMax = Math.max(localMax, Math.abs(node.left.val - parent));
        if (node.right != null )
            localMax = Math.max(localMax, Math.abs(node.right.val - parent));

        return Math.max(localMax, Math.max(diffImpl(node.left, node.val), diffImpl(node.right, node.val)));
    }
    public int maxAncestorDiff(TreeNode root) {
        return Math.max(diffImpl(root.left, root.val), diffImpl(root.right, root.val));
    }
}