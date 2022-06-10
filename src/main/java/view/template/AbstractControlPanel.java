package view.template;

import util.Constant;
import view.menu.SelectionFrame;

import javax.swing.*;
import java.awt.*;

/**
 * @author aiden
 */
public abstract class AbstractControlPanel extends JPanel {
    protected final JLabel status = new JLabel("",SwingConstants.CENTER);
    protected final JPanel topContainer = new JPanel();
    protected final JPanel middleContainer = new JPanel();
    protected final JPanel botContainer = new JPanel();
    protected final JButton button = new JButton();
    protected final JButton back = new JButton();

    protected final JTextField textField = new JTextField();
    public AbstractControlPanel() {
        //setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(Constant.CONTROL_W,Constant.CONTROL_H));

        textField.setPreferredSize(new Dimension(100,30));
        button.setPreferredSize(new Dimension(100,30));
        back.setPreferredSize(new Dimension(100,30));
        status.setPreferredSize(new Dimension(Constant.CONTROL_W/2,30));
        back.setText("Back");

        status.setAlignmentY(CENTER_ALIGNMENT);
        status.setAlignmentX(CENTER_ALIGNMENT);

        topContainer.setAlignmentY(CENTER_ALIGNMENT);
        middleContainer.setAlignmentY(CENTER_ALIGNMENT);
        botContainer.setAlignmentY(CENTER_ALIGNMENT);

        middleContainer.setBackground(Color.LIGHT_GRAY);
        botContainer.setBackground(Color.LIGHT_GRAY);
        topContainer.setBackground(Color.LIGHT_GRAY);

        topContainer.add(status);
        botContainer.add(back);

        topContainer.setPreferredSize(new Dimension(Constant.CONTROL_W,Constant.CONTROL_H/3));
        middleContainer.setPreferredSize(new Dimension(Constant.CONTROL_W,Constant.CONTROL_H/3));
        botContainer.setPreferredSize(new Dimension(Constant.CONTROL_W,Constant.CONTROL_H/3));

        setBackground(Color.GRAY);
        back.addActionListener(e -> {
            SwingUtilities.getWindowAncestor(this).dispose();
            SelectionFrame selectionFrame = new SelectionFrame();
            selectionFrame.pack();
            selectionFrame.setVisible(true);
        });
    }
}
