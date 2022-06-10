package view.queue;

import model.queue.Queue;
import view.template.AbstractFrameTemplate;

/**
 * @author aiden
 */
public class QueueFrame extends AbstractFrameTemplate {
    public final Queue queue;


    public QueueFrame() {
        super();

        setTitle("Queue Visualizer");

        queue = new Queue();
    }
}
