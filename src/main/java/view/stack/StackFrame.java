package view.stack;

import model.stack.Stack;
import util.Constant;
import view.template.AbstractFrameTemplate;

/**
 * @author aiden
 */
public class StackFrame extends AbstractFrameTemplate {
    private final Stack stack;

    public StackFrame() {

        super();
        setTitle("Stack Visualizer");

        stack = new Stack();
        StackGraphics stackGraphics = new StackGraphics(stack);
        stackGraphics.setSize(Constant.GRAPHICS_W,Constant.GRAPHICS_H);

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
