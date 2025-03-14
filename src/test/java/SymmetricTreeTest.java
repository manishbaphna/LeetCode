import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.plaf.DimensionUIResource;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class SymmetricTreeTest {

    SymmetricTree DUT = new SymmetricTree();

    @Test
    void basicTest1() {
        TreeNode leftNode = new TreeNode(2, new TreeNode(3), new TreeNode(4));
        TreeNode rightNode = new TreeNode(2, new TreeNode(4), new TreeNode(3));
        TreeNode root = new TreeNode(1, leftNode, rightNode);

        boolean result = DUT.isSymmetric(root);

        assertTrue(result);

    }
}