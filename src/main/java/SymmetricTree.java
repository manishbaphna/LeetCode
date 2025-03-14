import java.util.*;

//https://leetcode.com/problems/symmetric-tree/description/
public class SymmetricTree {
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

                if (startNode != endNode && (startNode == null || endNode == null))
                    return false;

                if ( startNode == endNode || (startNode.val == endNode.val)) {
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
}
