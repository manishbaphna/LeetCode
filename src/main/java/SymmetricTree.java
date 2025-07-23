import java.util.*;

//https://leetcode.com/problems/symmetric-tree/description/
public class SymmetricTree {
    public boolean isSymmetricDFS(TreeNode root) {
        if ( root == null )
            return true;

        return isMirror(root.left,root.right);

    }

    private boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;

        if (left == null || right == null)
            return false;

        if ( left.val == right.val && isMirror(left.left, right.right) && isMirror(left.right, right.left))
            return true;

        return false;
    }

    public boolean isSymmetric(TreeNode root) {
        if ( root == null )
            return false;

        List<TreeNode> q = new ArrayList<>();
        q.add(root.left);
        q.add(root.right);

        while (!q.isEmpty()) {

            int start = 0, end = q.size()-1;

            while ( start < end) {
                TreeNode startNode = q.get(start);
                TreeNode endNode = q.get(end);

                if ( startNode == null && endNode == null)
                    return true;

                if (startNode == null || endNode == null)
                    return false;

                if (startNode.val == endNode.val) {
                    start++;
                    end--;
                    continue;
                }

                return false;

            }

            List<TreeNode> newq = new ArrayList<>();
            for(int i=0; i <q.size(); ++i) {
                TreeNode node = q.get(i);
                if ( node == null)
                    continue;

                newq.add(node.left);
                newq.add(node.right);
            }
            q = newq;
        }

        return true;

    }

    public static void main(String[] args) {
        SymmetricTree DUT = new SymmetricTree();
        TreeNode root = new TreeNode(1);
        root.addLeftNode(root, 2);
        root.addRightNode(root, 2);
        root.left.addLeftNode(root.left, 3);
        root.left.addRightNode(root.left, 3);
        root.right.addLeftNode(root.right, 4);
        root.right.addRightNode(root.right, 4);

        root.printTree(root,3);

        System.out.println(DUT.isSymmetric(root));

    }
}
