package view.menu;

import view.bst.BinaryTreeFrame;
import view.linkedlist.LinkedListFrame;
import view.queue.QueueFrame;
import view.stack.StackFrame;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;

import static util.Constant.*;

/**
 * @author aiden
 */
public class SelectionFrame extends JFrame {
    final JPanel container = new JPanel();
    final JPanel buttonContainer = new JPanel();
    final JPanel titleContainer = new JPanel();
    final JLabel title = new JLabel("Data Structure Visualizer");
    final JButton binaryTreeButton = new JButton("Binary Tree");
    final JButton stackButton = new JButton("Stack");
    final JButton queueButton = new JButton("Queue");
    final JButton linkedListButton = new JButton("Linked List");
    final JButton exitButton = new JButton("EXIT");
    final Font buttonFont = new Font("Impact",Font.PLAIN,19);

    final int buttonWidth = 150;
    final int buttonHeight = 80;
    public SelectionFrame()
    {

        initButtonListener();

        setLayout(new BorderLayout());
        container.setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        buttonContainer.setPreferredSize(new Dimension(buttonWidth,FRAME_HEIGHT));
        buttonContainer.setAlignmentY(CENTER_ALIGNMENT);
        buttonContainer.setAlignmentX(CENTER_ALIGNMENT);

        titleContainer.setPreferredSize(new Dimension(FRAME_WIDTH,100));
        titleContainer.setAlignmentY(CENTER_ALIGNMENT);
        titleContainer.setAlignmentX(CENTER_ALIGNMENT);
        setPreferredSize(new Dimension(FRAME_WIDTH +15, FRAME_HEIGHT +15));

        binaryTreeButton.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        stackButton.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        queueButton.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        linkedListButton.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        exitButton.setPreferredSize(new Dimension(buttonWidth, buttonHeight));


        binaryTreeButton.setFont(buttonFont);
        stackButton.setFont(buttonFont);
        queueButton.setFont(buttonFont);
        linkedListButton.setFont(buttonFont);
        exitButton.setFont(buttonFont);

        binaryTreeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        stackButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        queueButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        linkedListButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(new Font("Impact", Font.BOLD, 40));

        titleContainer.add(title);
        buttonContainer.add(binaryTreeButton);
        buttonContainer.add(stackButton);
        buttonContainer.add(queueButton);
        buttonContainer.add(linkedListButton);

        buttonContainer.add(exitButton);

        container.add(titleContainer,BorderLayout.CENTER);
        container.add(buttonContainer,BorderLayout.CENTER);

        add(container,BorderLayout.CENTER);


    }

    private void initButtonListener() {
        binaryTreeButton.addActionListener(e -> {
            dispose();
            new BinaryTreeFrame();
        });

        stackButton.addActionListener(e -> {
            dispose();
            new StackFrame();

        });

        queueButton.addActionListener(e -> {
            dispose();
            new QueueFrame();

        });

        linkedListButton.addActionListener(e->{
            dispose();
            new LinkedListFrame();
        });

        exitButton.addActionListener(e -> dispose());
    }


}
