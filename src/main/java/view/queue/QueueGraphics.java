package view.queue;

import model.queue.Queue;

import java.awt.*;

import static util.Constant.*;
import static util.Constant.NODE_HEIGHT;

/**
 * @author aiden
 */
public class QueueGraphics extends Canvas {
    private final Queue queue;
    private Graphics graphics;

    public QueueGraphics(Queue queue){
        this.queue = queue;
    }

    public Graphics getG()
    {
        return this.graphics;
    }

    @Override
    public void paint(Graphics g)
    {
        this.graphics = g;
        Queue.Node curr = queue.head;
        if(curr!=null) {
            drawHeadLabel(g);
        }
        int num = 0;
        while(curr!=null) {
            g.drawRect(
                    QUEUE_INIT_X,
                    QUEUE_INIT_Y+num* NODE_HEIGHT,
                    NODE_WIDTH,
                    NODE_HEIGHT);
            g.drawString(curr.val.toString(), QUEUE_INIT_X+50,
                    QUEUE_INIT_Y+num* NODE_HEIGHT+25);
            num++;
            curr=curr.next;
        }
    }

    private void drawHeadLabel(Graphics g) {
        int arrowX = QUEUE_INIT_X;
        int arrowY = QUEUE_INIT_Y+NODE_HEIGHT/2;
        g.drawLine(arrowX,arrowY, arrowX-50 ,arrowY);
        g.drawLine(arrowX,arrowY, arrowX-10 ,arrowY+10);
        g.drawLine(arrowX,arrowY, arrowX-10 ,arrowY-10);
        g.drawString("Top" , arrowX-40,arrowY-5);
    }

    public static void drawIndex(Graphics g, int index)
    {
        int arrowX = QUEUE_INIT_X+NODE_WIDTH;
        int arrowY = QUEUE_INIT_Y+NODE_HEIGHT/2+NODE_HEIGHT*index;
        g.drawLine(arrowX,arrowY, arrowX+50 ,arrowY);
        g.drawLine(arrowX,arrowY, arrowX+10 ,arrowY-10);
        g.drawLine(arrowX,arrowY, arrowX+10 ,arrowY+10);
        g.drawString("Found" , arrowX+40,arrowY-5);


    }


}
