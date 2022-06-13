package view.linkedlist;

import model.linkedlist.SinglyLinkedList;
import view.template.AbstractFrameTemplate;

import static util.Constant.*;

/**
 * @author aiden
 */
public class LinkedListFrame extends AbstractFrameTemplate {

    public LinkedListFrame()
    {
        super();
        setTitle("Linked List Visualizer");

        SinglyLinkedList linkedList = new SinglyLinkedList();
        LinkedListGraphics linkedListGraphics = new LinkedListGraphics(linkedList);
        linkedListGraphics.setSize(GRAPHICS_W, GRAPHICS_H);

        LinkedListControlPanel controlPanel = new LinkedListControlPanel();
        controlPanel.setLinkedList(linkedList);
        controlPanel.setLinkedListGraphics(linkedListGraphics);

        mainPanel.add(linkedListGraphics);
        mainPanel.add(controlPanel);
        add(mainPanel);
        pack();
        setVisible(true);
    }
}
