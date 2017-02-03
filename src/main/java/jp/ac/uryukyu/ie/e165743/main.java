package jp.ac.uryukyu.ie.e165743;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.event.*;

class main extends JFrame implements ActionListener {
    public JLabel label;
    public JPanel p;
    public boolean counter;
    public int c;
    public long start;
    public long end;
    public boolean exit;

    public static void main(String args[]) {
        main Barrage = new main("title");
        Barrage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Barrage.setVisible(true);

    }

    main(String title) {
        counter = true;
        c = 0;

        setTitle(title);
        p = new JPanel();
        setSize(300, 300);
        setLocationRelativeTo(null);


        label = new JLabel("");
        JButton button1 = new JButton("Lets Barrage!");
        button1.addActionListener(this);

        p.add(label);
        p.add(button1);

        getContentPane().add(p);


        p.add(label);

        getContentPane().add(p, BorderLayout.CENTER);

    }

    public void actionPerformed(ActionEvent e) {
        start = System.currentTimeMillis();
        Sub sub = new Sub();
        Thread th = new Thread(sub);
        if (counter) {
            label.setText("Start!!");
            exit = true;
            th.start();
            counter = false;
        }
        c++;


    }

    class Sub extends Thread {

        public void run() {
            while (exit) {
                end = System.currentTimeMillis();
                if ((end - start)/1000000000 == 5) {
                    System.out.println(c);
                    exit = false;
                }
                System.out.println((start + end));
            }
        }
    }
}