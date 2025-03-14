public class BinaryTreeTilt {

    int tilt = 0;
    public int Sum(TreeNode root) {

        if ( root == null)
            return 0;
        if ( root.left == null && root.right == null)
            return root.val;


        int sumOfTree = root.val + Sum(root.left) + Sum(root.right);
        tilt += Math.abs(Sum(root.left) - Sum(root.right));

        return sumOfTree;
    }

    public int findTilt(TreeNode root) {
        int temp = Math.abs(Sum(root.left) - Sum(root.right));
        this.tilt += temp;
        return this.tilt;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,2}; //{7,7,7,7,7,7,7};
        int[] val = new int[500];

        System.out.println("size of val " + val.length);
        for ( int i=0; i <arr.length; ++i) {
            val[arr[i]]++;
        }

        for ( int i= val.length - 1 ; i > 0 ; --i) {
            System.out.println("value of val[i]" + val[i]);
            if (val[i] == i) {
                System.out.println("answer : " + i);
                return;
            }
        }

        System.out.println(" Answer -1");
    }
}
