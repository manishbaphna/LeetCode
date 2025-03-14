// https://leetcode.com/problems/construct-string-from-binary-tree/
public class BSTtoString {
    public String tree2str(TreeNode root) {
        int level = 0;
        StringBuffer str = new StringBuffer();
        preOrderImpl(root, str);
        return str.toString();
    }

    private void preOrderImpl(TreeNode root, StringBuffer result){
        if ( root == null)
            return;

        TreeNode left = root.left;
        TreeNode right = root.right;
        if ( left == null && right != null )
            result.append(root.val + "()");
        else
            result.append(root.val) ;

        if ( root.left != null) {
            result.append("(");
            preOrderImpl(root.left, result);
            result.append(")");
        }
        if ( root.right != null ) {
            result.append("(");
            preOrderImpl(root.right, result);
            result.append(")");
        }

    }
}
