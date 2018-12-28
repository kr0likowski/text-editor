import gui.MyFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

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
                nw.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        textArea.setText("");
                    }
                });
                JMenuItem open = new JMenuItem("Open");
                open.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        JFileChooser jf = new JFileChooser();
                        int r = jf.showOpenDialog(null);
                        if (r == JFileChooser.APPROVE_OPTION) {
                            File openedFile = new File(jf.getSelectedFile().getAbsolutePath());
                            try {
                                //Read file
                                String s1 = "";
                                String sl = "";
                                FileReader fr = new FileReader(openedFile);
                                BufferedReader br = new BufferedReader(fr);
                                sl = br.readLine();
                                while ((s1 = br.readLine()) != null) {
                                    sl = sl + "\n" + s1;
                                }
                                textArea.setText(sl);
                            } catch (Exception ext) {
                                JOptionPane.showMessageDialog(Frame,ext.getMessage());
                            }


                        }

                    }
                });
                JMenuItem exit = new JMenuItem("Exit");
                JMenuItem save = new JMenuItem("Save");
                save.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JFileChooser jf = new JFileChooser();
                        int r = jf.showSaveDialog(null);
                        if(r==JFileChooser.APPROVE_OPTION)
                        {
                            File fl = new File(jf.getSelectedFile().getAbsolutePath());
                            try{
                            FileWriter wr = new FileWriter(fl,false);
                            BufferedWriter br = new BufferedWriter(wr);
                            br.write(textArea.getText());
                            br.flush();
                            br.close();
                            }catch(Exception ext){
                                JOptionPane.showMessageDialog(Frame,ext.getMessage());
                        }

                        }
                    }
                });
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
                copy.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        textArea.copy();
                    }
                });
                JMenuItem paste = new JMenuItem("Paste");
                paste.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        textArea.paste();
                    }
                });
                JMenuItem cut = new JMenuItem("Cut");
                cut.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        textArea.cut();
                    }
                });
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
