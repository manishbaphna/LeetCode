import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTiltTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void baiscTest1(){
        TreeNode L3 = new TreeNode(3);
        TreeNode L5 = new TreeNode(5);
        TreeNode L2 = new TreeNode(2, L3, L5);
        TreeNode L7 = new TreeNode(7);
        TreeNode L9 = new TreeNode(9, null, L7);
        TreeNode root = new TreeNode(4, L2, L9);

        int result = new BinaryTreeTilt().findTilt(root);

        assertEquals(15, result);
    }

    @Test
    void baiscTest2(){
        TreeNode L5 = new TreeNode(5);
        TreeNode L4 = new TreeNode(4, L5, null);
        TreeNode L3 = new TreeNode(3, L4, null);
        TreeNode L2 = new TreeNode(2, L3, null);
        TreeNode root = new TreeNode(1, L2, null);

        int result = new BinaryTreeTilt().findTilt(root);

        assertEquals(14, result);
    }
}