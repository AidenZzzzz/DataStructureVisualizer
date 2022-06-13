package view.stack;

import model.stack.Stack;
import java.awt.*;

import static util.Constant.*;

/**
 * @author aiden
 */
public class StackGraphics extends Canvas {
    private final Stack stack;
    private Graphics graphics;

    public StackGraphics(Stack stack){
        this.stack = stack;
    }

    public Graphics getG ()
    {
        return this.graphics;
    }

    @Override
    public void paint(Graphics g)
    {
        this.graphics = g;
        Stack.Node curr = stack.head;
        if(curr!=null) {
            drawHeadLabel(g);
        }
        int num = 0;
        while(curr!=null) {
            g.drawRect(
                    STACK_INIT_X,
                    STACK_INIT_Y+num* NODE_HEIGHT,
                    NODE_WIDTH,
                    NODE_HEIGHT);
            g.drawString(
                    curr.val.toString(),
                    STACK_INIT_X+50,
                    STACK_INIT_Y+num* NODE_HEIGHT+25);
            num++;
            curr=curr.next;
        }
    }

    private void drawHeadLabel(Graphics g) {
        int arrowX = STACK_INIT_X;
        int arrowY = STACK_INIT_Y + NODE_HEIGHT/2;
        g.drawLine(arrowX,arrowY, arrowX-50 ,arrowY);
        g.drawLine(arrowX,arrowY, arrowX-10 ,arrowY+10);
        g.drawLine(arrowX,arrowY, arrowX-10 ,arrowY-10);
        g.drawString("Top" , arrowX-40,arrowY-5);
    }

    public static void drawIndex(Graphics g, int index)
    {
        int arrowX = STACK_INIT_X + NODE_WIDTH;
        int arrowY = STACK_INIT_Y + (NODE_HEIGHT/2) + (NODE_HEIGHT*index);
        g.drawLine(arrowX,arrowY, arrowX+50 ,arrowY);
        g.drawLine(arrowX,arrowY, arrowX+10 ,arrowY-10);
        g.drawLine(arrowX,arrowY, arrowX+10 ,arrowY+10);
        g.drawString("Found" , arrowX+40,arrowY-5);


    }


}
