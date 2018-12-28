import gui.MyFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main  {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JTextArea textArea = new JTextArea();
               MyFrame Frame = new MyFrame();
                JMenuBar menubar = new JMenuBar();
                JMenu menu1 = new JMenu("File");
                JMenuItem nw = new JMenuItem("New");
                JMenuItem open = new JMenuItem("Open");
                JMenuItem exit = new JMenuItem("Exit");
                JMenuItem save = new JMenuItem("Save");
                menu1.add(nw);
                menu1.add(open);
                menu1.add(save);
                exit.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.exit(0);
                    }
                });
                menu1.add(exit);
                menubar.add(menu1);
                JMenu menu2 = new JMenu("Edit");
                JMenuItem copy = new JMenuItem("Copy");
                JMenuItem paste = new JMenuItem("Paste");
                JMenuItem cut = new JMenuItem("Cut");
                menu2.add(copy);
                menu2.add(cut);
                menu2.add(paste);
                menubar.add(menu2);
                Frame.add(textArea);
                Frame.setJMenuBar(menubar);
            }
        });
    }

}
