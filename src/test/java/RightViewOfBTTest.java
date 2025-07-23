import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RightViewOfBTTest {
    RightViewOfBT rightViewOfBT = new RightViewOfBT();


    @Test
    void basicTest(){
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
        var result = rightViewOfBT.rightSideView(root);
        result.forEach(System.out::println);
    }

    @Test
    void basicTest2(){
        TreeNode root = new TreeNode(3);
        var result = rightViewOfBT.rightSideView(root);
        result.forEach(System.out::println);
    }

}