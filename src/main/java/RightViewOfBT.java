//https://leetcode.com/problems/binary-tree-right-side-view/description/

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
class RightViewOfBT {
    public List<Integer> rightSideView(TreeNode root) {

        if ( root == null )
            return new LinkedList<>();

        List<Integer> rightView = new LinkedList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean firstElementForTheLevel = true;

        Queue<TreeNode> newq = new LinkedList<>();

        int qsize = q.size();

        while (qsize != 0)
        {
            for (int i=0; i <qsize;++i)
            {
                TreeNode node = q.poll();
                if (firstElementForTheLevel) {
                    rightView.add(node.val);
                    firstElementForTheLevel = false;
                }

                if (node.right != null) q.add(node.right);
                if (node.left != null) q.add(node.left);
            }
            firstElementForTheLevel = true;
            qsize = q.size();
        }

        return rightView;
    }

    public static void main(String[] args) {
        TreeNode root =
                new TreeNode
                        (1,
                        new TreeNode
                                (2,
                                    new TreeNode(4,
                                        new TreeNode(5),
                                        null),
                                null),
                        new TreeNode(3)
                        );
        RightViewOfBT rightViewOfBT = new RightViewOfBT();
        var result = rightViewOfBT.rightSideView(root);
        result.forEach(System.out::println);
    }
}