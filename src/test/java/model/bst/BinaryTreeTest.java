package model.bst;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BinaryTreeTest {

    @Test
    void insertTest()
    {
        BinaryTree root = new BinaryTree(6);
        Assertions.assertNotNull(root.val);
        BinaryTree.insert(root,5);
        Assertions.assertNotNull(root.left);
        BinaryTree.insert(root,7);
        Assertions.assertNotNull(root.right);

    }
}