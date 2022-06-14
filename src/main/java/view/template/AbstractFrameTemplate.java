package view.template;

import util.Constant;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;

/**
 * @author aiden
 */
public abstract class AbstractFrameTemplate extends JFrame {
    protected final JPanel mainPanel;

    public AbstractFrameTemplate() throws HeadlessException {
        mainPanel = new JPanel();
        mainPanel.setPreferredSize(new Dimension(Constant.FRAME_WIDTH +15,Constant.FRAME_HEIGHT +15));
        mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.PAGE_AXIS));
        mainPanel.setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.WHITE);
    }
}
