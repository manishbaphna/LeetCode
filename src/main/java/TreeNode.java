import com.sun.source.tree.Tree;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    void addLeftNode(TreeNode node, TreeNode leftValue) {
        node.left = leftValue;
    }
    void addLeftNode(TreeNode node, int leftValue) {
        node.left = new TreeNode(leftValue, null, null);
    }

    void addRightNode(TreeNode node, TreeNode leftValue) {
        node.right = leftValue;
    }
    void addRightNode(TreeNode node, int leftValue) {
        node.right = new TreeNode(leftValue, null, null);
    }

    void printTree(TreeNode node, int level) {
        if ( node == null )
            return;

        for (int i=0; i<level; ++i)
            System.out.printf("\t");
        System.out.println(node.val);
        printTree(node.left, level - 2);
        printTree(node.right, level + 2);
    }

}