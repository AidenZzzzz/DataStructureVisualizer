package view.queue;

import model.linkedlist.AbstractSinglyLinkedNode;
import model.queue.Queue;
import view.template.AbstractControlPanel;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

/**
 * @author aiden
 */
public class QueueControlPanel extends AbstractControlPanel {
    private QueueGraphics queueGraphics;
    private Queue queue;
    private final JComboBox<String> actionChooser;
    public QueueControlPanel() {
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
                queueGraphics.repaint();

            }
            else{
                new JPopupMenu("Please select an action");
            }
        });
    }

    public void setQueueGraphics(QueueGraphics queueGraphics) {
        this.queueGraphics = queueGraphics;
    }

    public void setQueue(Queue queue) {
        this.queue = queue;
    }

    private void pop(String name) {
        System.out.println(name);
        AbstractSinglyLinkedNode.Node top = Queue.top(queue);
        if(top!=null) {
            this.status.setText("removed " + top.val.toString());
            queue = Queue.pop(queue);
        }
        else
        {
            this.status.setText("Queue empty");
        }
        queueGraphics.repaint();
        repaint();
    }

    private void find(String name) {
        System.out.println(name);
        int res = Queue.find(queue,Integer.parseInt(name));
        if(res == -1)
        {
            status.setText(name + " not found");
        }
        else
        {
            status.setText("Found at level " + res);
            QueueGraphics.drawIndex(queueGraphics.getG(),res);
        }

        queueGraphics.repaint();
        repaint();
    }

    private void push(String name) {
        System.out.println(name);
        Queue.push(queue,Integer.parseInt(name));
        queueGraphics.repaint();
        repaint();
    }


}
