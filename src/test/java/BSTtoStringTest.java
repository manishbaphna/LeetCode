import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BSTtoStringTest {

    @Test
    void basicTest1() {

        TreeNode root = new TreeNode(1);
        root.addLeftNode(root, 2);
        root.addRightNode(root, 3);
        root.left.addLeftNode(root.left, 4);

        root.printTree(root,3);

        String result = new BSTtoString().tree2str(root);
        System.out.println(result);
    }
}