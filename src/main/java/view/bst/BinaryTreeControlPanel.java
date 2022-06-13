package view.bst;

import model.bst.BinaryTree;
import view.template.AbstractControlPanel;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

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
        actions = new String[]{"Insert", "Delete", "Find"};
        actionChooser = new JComboBox<>(actions);
        actionChooser.setPreferredSize(new Dimension(100,30));
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
                    case "Find" -> find(textField.getText());
                    case "Delete" -> delete(textField.getText());
                    default -> throw new IllegalStateException("Unexpected value: " + actionChooser.getSelectedItem());
                }
                textField.setText("");
                status.setText("DONE");
                binaryTreeGraphics.repaint();

            }
            else{
                new JPopupMenu("Please select an action");
            }
        });
    }

    private void delete(String name) {
        System.out.println(name);
        try {
            BinaryTree.delete(root,Integer.parseInt(name));
        }
        catch (NumberFormatException e) {
            System.out.println("not an int");
        }
        binaryTreeGraphics.repaint();
    }

    private void find(String name) {
        System.out.println(name);
        if(BinaryTree.exist(root,Integer.parseInt(name)))
        {
            // TODO: 6/10/22 point to the tree node
        }
        else
        {

        }
    }

    private void insert(String name) {
        System.out.println(name);
        try {
            BinaryTree.insert(root,Integer.parseInt(name),0,0);
        }
        catch (NumberFormatException e) {
            System.out.println("not an int");
        }
        binaryTreeGraphics.repaint();
    }

}
