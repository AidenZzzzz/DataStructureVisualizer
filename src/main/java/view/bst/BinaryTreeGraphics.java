package view.bst;

import model.bst.BinaryTree;

import java.awt.*;

import static util.Constant.*;

/**
 * @author aiden
 *

 */
public class BinaryTreeGraphics extends Canvas {
    public void setRoot(BinaryTree root) {
        this.root = root;
    }

    private BinaryTree root;

    public BinaryTreeGraphics(BinaryTree binaryTree) {
        this.root = binaryTree;
    }

    @Override
    public void paint(Graphics g){
        recursivePaint(g,root,0,0);
    }

    private void recursivePaint(Graphics g, BinaryTree treeNode, int depth, int xOffset)
    {
        if(treeNode == null || treeNode.val == null)
        {
            return;
        }
        int gap = FRAME_WIDTH / (4 * (depth + 1));
        int currX = BST_INIT_X - NODE_HEIGHT/2 + xOffset;
        int currY = BST_INIT_Y + depth * NODE_HEIGHT*2;

        g.drawRect(
                currX,
                currY,
                NODE_HEIGHT,
                NODE_HEIGHT
        );
        g.drawString(
                treeNode.val.toString(),
                currX+2,
                currY+25
        );
        if (root.left != null) {
            if(root.left.val!=null) {
                g.drawLine(
                        currX+NODE_HEIGHT/2,
                        currY+NODE_HEIGHT,
                        currX +NODE_HEIGHT/2 - gap,
                        currY + 2*NODE_HEIGHT
                );
                recursivePaint(g,treeNode.left,depth+1, xOffset-gap);
            }

        }
        if(root.right != null) {
            if(root.right.val != null) {
                g.drawLine(
                        currX+NODE_HEIGHT/2,
                        currY+NODE_HEIGHT,
                        currX+NODE_HEIGHT/2+ gap,
                        currY + 2*NODE_HEIGHT
                );
                recursivePaint(g, treeNode.right, depth + 1, xOffset + gap);
            }
        }
    }
}
