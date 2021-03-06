package view.linkedlist;

import model.linkedlist.SinglyLinkedList;
import view.template.AbstractControlPanel;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

import static util.Constant.*;

/**
 * @author aiden
 */
public class LinkedListControlPanel extends AbstractControlPanel {
    private LinkedListGraphics linkedListGraphics;
    private SinglyLinkedList linkedList;
    private final JComboBox<String> actionChooser;

    public LinkedListControlPanel() {
        super();
        String[] actions  = new String[] {"Insert", "Delete" , "Find", "Reverse", "Prune"};
        actionChooser = new JComboBox<>(actions);
        actionChooser.setPreferredSize(new Dimension(CONTROL_BUTTON_WIDTH, CONTROL_BUTTON_HEIGHT));
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

    public void setLinkedListGraphics(LinkedListGraphics linkedListGraphics) {
        this.linkedListGraphics = linkedListGraphics;
    }

    public void setLinkedList(SinglyLinkedList linkedList) {
        this.linkedList = linkedList;
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
                    case "Delete" -> delete(textField.getText());
                    case "Find" -> find(textField.getText());
                    case "Reverse" -> reverse();
                    case "Prune" -> prune(textField.getText());
                    default -> throw new IllegalStateException("Unexpected value: " + actionChooser.getSelectedItem());
                }
                textField.setText("");
                linkedListGraphics.repaint();

            }
            else{
                new JPopupMenu("Please select an action");
            }
        });
    }

    private void prune(String text) {
        if(text.length() == 0)
        {
            status.setText("Empty input");
            return;
        }
        SinglyLinkedList.prune(linkedList, text);
        status.setText("Deleted trailing elements of " + text);
        linkedListGraphics.repaint();
        repaint();
    }

    private void reverse() {
        SinglyLinkedList.reverseList(linkedList);
        status.setText("List reversal complete");
        linkedListGraphics.repaint();
        repaint();
    }

    private void find(String text) {
        if(text.length() == 0)
        {
            status.setText("Empty input");
            return;
        }
        System.out.println(text);
        int res = SinglyLinkedList.find(linkedList,text);
        if(res == -1)
        {
            status.setText(text + " not found");
        }
        else
        {
            status.setText("Found at level " + res);
            LinkedListGraphics.drawIndex(linkedListGraphics.getG(),res);
        }

        linkedListGraphics.repaint();
        repaint();

    }

    private void delete(String text) {
        System.out.println(text);
        SinglyLinkedList.delete(linkedList,text);
        status.setText("Deleted " + text);
        linkedListGraphics.repaint();
        repaint();

    }

    private void insert(String text) {
        if(text.length()==0)
        {
            status.setText("Empty input");
            return;
        }
        System.out.println("Inserting " + text);
        SinglyLinkedList.insert(linkedList,text);
        status.setText("Inserted " + text);
        linkedListGraphics.repaint();
        repaint();
    }
}
