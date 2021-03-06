package view.stack;

import model.linkedlist.AbstractSinglyLinkedNode;
import model.stack.Stack;
import view.template.AbstractControlPanel;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

/**
 * @author aiden
 */
public class StackControlPanel extends AbstractControlPanel {
    private StackGraphics  stackGraphics;
    private Stack stack;
    private final JComboBox<String> actionChooser;
    public StackControlPanel() {
        super();
        String[] actions = new String[]{"Push", "Pop", "Find"};
        actionChooser = new JComboBox<>(actions);
        actionChooser.setPreferredSize(new Dimension(100,30));
        middleContainer.add(actionChooser);
        button.setText(Objects.requireNonNull(actionChooser.getSelectedItem()).toString());
        middleContainer.add(actionChooser);
        middleContainer.add(textField);
        middleContainer.add(button);

        add(topContainer);
        add(middleContainer);
        add(botContainer);

        initActionListener();
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
                    case "Push" -> push(textField.getText());
                    case "Pop" -> pop(textField.getText());
                    case "Find" -> find(textField.getText());
                    default -> throw new IllegalStateException("Unexpected value: " + actionChooser.getSelectedItem());
                }
                textField.setText("");
                stackGraphics.repaint();

            }
            else{
                new JPopupMenu("Please select an action");
            }
        });
    }

    public void setStackGraphics(StackGraphics stackGraphics) {
        this.stackGraphics = stackGraphics;
    }

    public void setStack(Stack stack) {
        this.stack = stack;
    }

    private void pop(String name) {
        System.out.println(name);
        AbstractSinglyLinkedNode.Node top = Stack.top(stack);
        if(top!=null) {
            this.status.setText("removed " + top.val.toString());
            stack = Stack.pop(stack);
        }
        else
        {
            this.status.setText("Stack empty");
        }
        stackGraphics.repaint();
        repaint();
    }

    private void find(String name) {
        if(name.equals(""))
        {
            status.setText("Empty input");
            return;
        }
        System.out.println(name);
        int res = Stack.find(stack,name);
        if(res == -1)
        {
            status.setText(name + " not found");
        }
        else
        {
            status.setText("Found at level " + res);
            StackGraphics.drawIndex(stackGraphics.getG(),res);
        }

        stackGraphics.repaint();
        repaint();
    }

    private void push(String name) {
        System.out.println(name);
        Stack.push(stack,name);
        stackGraphics.repaint();
        repaint();
    }



}
