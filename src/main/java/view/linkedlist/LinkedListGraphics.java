package view.linkedlist;

import model.linkedlist.SinglyLinkedList;

import java.awt.*;

import static util.Constant.*;

/**
 * @author aiden
 */
public class LinkedListGraphics extends Canvas {
    private final SinglyLinkedList list;
    private Graphics graphics;
    public LinkedListGraphics(SinglyLinkedList list) {
        this.list = list;
    }

    public static void drawIndex(Graphics g, int res) {

    }

    @Override
    public void paint(Graphics g) {
        this.graphics = g;
        SinglyLinkedList.Node curr = list.head;
        if(curr != null) {
            drawHeadLabel(g);
        }
        int num = 0;
        while(curr != null){
            g.drawRect(
                    LL_INIT_X+ num * (NODE_HEIGHT+GAP) ,
                    LL_INIT_Y,
                    NODE_WIDTH/2,
                    NODE_HEIGHT);
            g.drawString(
                    curr.val.toString(),
                    LL_INIT_X + num* (NODE_HEIGHT+GAP) + 25,
                    LL_INIT_Y + 25);
            if(num>0)
            {
                //Draw linking arrow
                int arrowX = LL_INIT_X + (NODE_HEIGHT+GAP) * num ;
                int arrowY = LL_INIT_Y + NODE_HEIGHT/2;
                g.drawLine(arrowX,arrowY, arrowX-GAP ,arrowY);
                g.drawLine(arrowX,arrowY, arrowX-GAP/2 ,arrowY+GAP/2);
                g.drawLine(arrowX,arrowY, arrowX-GAP/2 ,arrowY-GAP/2);
            }
            num ++;
            curr = curr.next;
        }


    }

    private void drawHeadLabel(Graphics g) {
        int arrowX = LL_INIT_X;
        int arrowY = LL_INIT_Y+NODE_HEIGHT/2;
        g.drawLine(arrowX,arrowY, arrowX-50 ,arrowY);
        g.drawLine(arrowX,arrowY, arrowX-10 ,arrowY+10);
        g.drawLine(arrowX,arrowY, arrowX-10 ,arrowY-10);
        g.drawString("Head" , arrowX-40,arrowY-5);
    }

    public Graphics getG() {
        return this.graphics;
    }
}
