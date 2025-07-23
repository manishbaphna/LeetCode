//https://leetcode.com/problems/binary-tree-inorder-traversal/


import java.util.*;


public class InOrderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> results = new ArrayList<>();
        inorderTraversalImpl(root, results);
        return results;
    }

    void inorderTraversalImpl (TreeNode root, List<Integer> results) {
          if ( root == null)
              return;
          inorderTraversalImpl(root.left, results);
          results.add(root.val);
          inorderTraversalImpl(root.right, results);
    }
}

class Solution {

    public List<Integer> postorderTraversal2(TreeNode root) {
        LinkedList<Integer> ans = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return ans;

        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            ans.addFirst(cur.val);
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (cur.right != null) {
                stack.push(cur.right);
            }
        }
        System.out.println();
        return ans;
    }

    public List<Integer> postorderTraversalNR(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        HashSet<Integer> visited = new HashSet<>();

        if ( root == null)
            return results;



        TreeNode current = root;

        while ( current != null ) {
            while ((current.left != null && !visited.contains(current.left.val))
                    || (current.right != null && !visited.contains(current.right.val)))
            {
                stack.push(current);
                visited.add(current.val);

                if (current.right != null) {
                    stack.push(current.right);
                    visited.add(current.right.val);
                }
                if (current.left != null) {
                    stack.push(current.left);
                    visited.add(current.left.val);
                }

                current = stack.pop();
            }

            results.add(current.val);

            if (stack.empty())
                break;
            current = stack.pop();
        }

        return results;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        postorderTraversalImpl(root, results);
        return results;
    }

    void postorderTraversalImpl (TreeNode root, List<Integer> results) {
        if ( root == null)
            return;
        postorderTraversalImpl(root.left, results);
        postorderTraversalImpl(root.right, results);
        results.add(root.val);

    }
}