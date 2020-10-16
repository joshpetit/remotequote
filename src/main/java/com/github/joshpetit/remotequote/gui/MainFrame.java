package com.github.joshpetit.remotequote.gui;


import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public MainFrame() {
        Rectangle rec = getGraphicsConfiguration().getBounds();
        Insets insets = Toolkit.getDefaultToolkit().getScreenInsets(getGraphicsConfiguration());
        setUndecorated(true);
        int x = rec.x + insets.right;
        int y = rec.y - rec.height + insets.top + getHeight();
        setSize(1000, 100);
        setLocation(x,y);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Remote Quote");

        GridBagLayout manager = new GridBagLayout();
        setLayout(manager);
        GridBagConstraints gc = new GridBagConstraints();



        setVisible(true);
    }
}
