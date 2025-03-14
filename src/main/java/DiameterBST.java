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
import static java.lang.Math.max;

class Pair<T,U> {
    T left;
    U right;

    public T getLeft() {
        return left;
    }

    public U getRight() {
        return right;
    }

    public Pair(T left,U right) {
        this.left = left;
        this.right = right;
    }
}
class DiameterBST {
    private Pair<Integer, Integer> diameterHelper(TreeNode node){
        if (node ==null ) {
            return new Pair<Integer, Integer>(0,-1);
        }

        Pair<Integer,Integer> leftData  = diameterHelper(node.left);
        Pair<Integer,Integer> rightData = diameterHelper(node.right);

        int nodeHeight = 1 + max(leftData.getRight(), rightData.getRight());

        int heightLeft = leftData.getRight() ;
        int heightRight = rightData.getRight() ;
        int diameter = max ( 2 + heightLeft + heightRight,
                max( leftData.getLeft(), rightData.getLeft()));

        return new Pair<>(diameter, nodeHeight);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        return diameterHelper(root).getLeft();
    }
}