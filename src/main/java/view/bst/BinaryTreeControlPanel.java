package view.bst;

import model.bst.BinaryTree;
import view.template.AbstractControlPanel;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;
import java.util.Random;

import static util.Constant.*;

/**
 * @author aiden
 */
public class BinaryTreeControlPanel extends AbstractControlPanel {
    final String[] actions;
    final JComboBox<String> actionChooser;
    BinaryTreeGraphics binaryTreeGraphics;
    BinaryTree root;

    public BinaryTreeControlPanel() {
        super();
        status.setText("Due to dimension limit, overlapping will occur at depth 4");
        actions = new String[]{ "Smart Insert","Insert", "Delete", "Find", "Balance", "Clean", "Fill Tree"};
        actionChooser = new JComboBox<>(actions);
        actionChooser.setPreferredSize(new Dimension(CONTROL_BUTTON_WIDTH, CONTROL_BUTTON_HEIGHT));
        button.setText(Objects.requireNonNull(actionChooser.getSelectedItem()).toString());
        middleContainer.add(actionChooser);
        middleContainer.add(textField);
        middleContainer.add(button);

        add(topContainer);
        add(middleContainer);
        add(botContainer);

        initActionListener();

    }

    public void setBinaryTreeGraphics(BinaryTreeGraphics binaryTreeGraphics) {
        this.binaryTreeGraphics = binaryTreeGraphics;
    }

    public void setRoot(BinaryTree x)
    {
        this.root=x;
    }

    private void initActionListener() {
        actionChooser.addActionListener(e -> {
            if(actionChooser.getSelectedItem()!=null) {
                button.setText(actionChooser.getSelectedItem().toString());
                button.setEnabled(true);
            }
        });

        button.addActionListener(e -> {
            if(actionChooser.getSelectedItem()!=null) {
                System.out.println("perform "+actionChooser.getSelectedItem());
                switch (actionChooser.getSelectedItem().toString()) {
                    case "Insert" -> insert(textField.getText());
                    case "Smart Insert" -> smartInsert(textField.getText());
                    case "Find" -> find(textField.getText());
                    case "Delete" -> delete(textField.getText());
                    case "Balance" -> balance();
                    case "Clean" -> clean();
                    case "Fill Tree" -> fillTree(textField.getText());
                    default -> throw new IllegalStateException("Unexpected value: " + actionChooser.getSelectedItem());
                }
                binaryTreeGraphics.repaint();
                repaint();

            }
            else{
                new JPopupMenu("Please select an action");
            }
        });
    }

    private void smartInsert(String text) {
        insert(text);
        balance();
    }

    private void balance() {

        root = BinaryTree.balance(root);
        binaryTreeGraphics.setRoot(root);
        status.setText("Tree balancing complete");
        binaryTreeGraphics.repaint();
        repaint();

    }

    private void delete(String name) {
        System.out.println(name);
        try {
            BinaryTree.delete(root,Integer.parseInt(name));
            status.setText("Deleted " + name);
        }
        catch (NumberFormatException e) {
            status.setText("Input must be integer");
        }
        binaryTreeGraphics.repaint();
        repaint();
    }

    private void find(String name) {
        System.out.println(name);
        long startTime = System.nanoTime();
        try {
            if (BinaryTree.exist(root, Integer.parseInt(name))) {
                long endTime = System.nanoTime();
                status.setText(name + " found in " + (endTime-startTime) + " nanoseconds");
            } else {
                status.setText("Integer " + name + " not found");
            }
        }catch (NumberFormatException e)
        {
            status.setText("Input must be integer");
        }
        binaryTreeGraphics.repaint();
        repaint();
    }

    private void insert(String name) {
        System.out.println(name);
        try {
            BinaryTree.insert(root,Integer.parseInt(name));
            status.setText("Inserted " + name);
        }
        catch (NumberFormatException e) {
            status.setText("Input must be integer");
        }
        binaryTreeGraphics.repaint();
        repaint();
    }

    private void fillTree(String text)
    {
        clean();
        int input = 10;
        String extraText = "";
        if(text.length() == 0)
        {
            extraText = "Use default. ";
        }
        else {
            try {
                input = Integer.parseInt(text);
            } catch (NumberFormatException e) {
                extraText = "Use default. ";
            }
        }
        int startTime = (int) System.nanoTime();
        Random random = new Random();
        for(int i = 0; i < input; i++)
        {
            int num  = random.nextInt(0,input);
            BinaryTree.insert(root,num);
        }
        int time = (int) System.nanoTime() - startTime;
        balance();
        status.setText(extraText + input +" random values inserted in " + time + " nanoseconds");
        binaryTreeGraphics.repaint();
        repaint();
    }

    private void clean() {
        root.val = null;
        root.right = null;
        root.left = null;
        status.setText("Tree cleaned");
        binaryTreeGraphics.repaint();
        repaint();
    }

}
