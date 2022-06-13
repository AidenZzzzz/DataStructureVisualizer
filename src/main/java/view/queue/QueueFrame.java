package view.queue;

import model.queue.Queue;
import util.Constant;
import view.queue.QueueControlPanel;
import view.template.AbstractFrameTemplate;

/**
 * @author aiden
 */
public class QueueFrame extends AbstractFrameTemplate {

    public QueueFrame() {

        super();
        setTitle("Queue Visualizer");

        Queue queue = new Queue();
        QueueGraphics queueGraphics = new QueueGraphics(queue);
        queueGraphics.setSize(Constant.GRAPHICS_W,Constant.GRAPHICS_H);

        QueueControlPanel controlPanel = new QueueControlPanel();
        controlPanel.setQueue(queue);
        controlPanel.setQueueGraphics(queueGraphics);

        mainPanel.add(queueGraphics);
        mainPanel.add(controlPanel);
        add(mainPanel);
        pack();
        setVisible(true);
    }
}
