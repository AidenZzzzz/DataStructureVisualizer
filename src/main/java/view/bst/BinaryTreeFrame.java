package view.bst;

import model.bst.BinaryTree;
import util.Constant;
import view.template.AbstractFrameTemplate;

/**
 * @author aiden
 */
public class BinaryTreeFrame extends AbstractFrameTemplate {

    public final BinaryTree root;

    public BinaryTreeFrame()
    {
        super();
        setTitle("Binary Tree Visualizer");

        root = new BinaryTree();
        BinaryTreeGraphics binaryTreeGraphics = new BinaryTreeGraphics(root);
        binaryTreeGraphics.setSize(Constant.GRAPHICS_W,Constant.GRAPHICS_H);

        BinaryTreeControlPanel binaryTreeControlPanel = new BinaryTreeControlPanel();
        binaryTreeControlPanel.setRoot(root);
        binaryTreeControlPanel.setBinaryTreeGraphics(binaryTreeGraphics);

        mainPanel.add(binaryTreeGraphics);
        mainPanel.add(binaryTreeControlPanel);
        add(mainPanel);
        pack();
        setVisible(true);
    }
}
