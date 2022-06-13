package util;

import model.bst.BinaryTree;
import org.junit.jupiter.api.Test;

class BinaryTreeTest {
    @Test
    void pruneTest()
    {
        BinaryTree root = new BinaryTree(50);
        BinaryTree.insert(root,100,0,0);
        BinaryTree.insert(root,99,0,0);
        BinaryTree.insert(root,101,0,0);
        BinaryTree.prune(root,100);

        BinaryTree.prune(root,50);
        BinaryTree.insert(root,1,0,0);

        BinaryTree.preorder(root);
    }

}