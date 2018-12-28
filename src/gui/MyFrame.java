package gui;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int width = screenSize.width * 2/3;
    int height = screenSize.height * 2/3;
    public MyFrame(){
        super("Text Editor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(width,height));
        setLocation(50,50);
        setLayout(new BorderLayout());
        setVisible(true);

    }
}
