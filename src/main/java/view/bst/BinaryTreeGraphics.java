package view.bst;

import model.bst.BinaryTree;

import java.awt.*;

/**
 * @author aiden
 *

 */
public class BinaryTreeGraphics extends Canvas {
    private final BinaryTree root;

    public BinaryTreeGraphics(BinaryTree binaryTree) {
        this.root = binaryTree;
    }

    @Override
    public void paint(Graphics g){
        if(root!=null) {
            root.draw(g);
        }
    }
}
