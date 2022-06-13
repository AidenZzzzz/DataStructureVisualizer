package view.stack;

import model.stack.Stack;
import view.template.AbstractFrameTemplate;

import static util.Constant.*;

/**
 * @author aiden
 */
public class StackFrame extends AbstractFrameTemplate {

    public StackFrame() {

        super();
        setTitle("Stack Visualizer");

        Stack stack = new Stack();
        StackGraphics stackGraphics = new StackGraphics(stack);
        stackGraphics.setSize(GRAPHICS_W, GRAPHICS_H);

        StackControlPanel controlPanel = new StackControlPanel();
        controlPanel.setStack(stack);
        controlPanel.setStackGraphics(stackGraphics);

        mainPanel.add(stackGraphics);
        mainPanel.add(controlPanel);
        add(mainPanel);
        pack();
        setVisible(true);
    }
}
