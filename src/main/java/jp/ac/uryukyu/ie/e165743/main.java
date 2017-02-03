package jp.ac.uryukyu.ie.e165743;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.TimeUnit;

class main extends JFrame implements ActionListener {
    public JLabel label;
    public JPanel p;
    public boolean counter;
    public int c;
    public long start;
    public long end;
    public boolean exit;
    public JLabel result;
    public JLabel average;

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


        result = new JLabel("");
        average = new JLabel("");
        label = new JLabel("");
        JButton button1 = new JButton("Lets Barrage!");
        button1.addActionListener(this);

        p.add(label);
        p.add(button1);
        p.add(result);
        p.add(label);
        p.add(average);

        getContentPane().add(p);


        getContentPane().add(p, BorderLayout.CENTER);

    }

    public void actionPerformed(ActionEvent e) {
        Sub sub = new Sub();
        Thread th = new Thread(sub);
        if (counter) {
            start = System.currentTimeMillis();
            label.setText("Start!!");
            exit = true;
            th.start();
            counter = false;
        }
        c++;
        Toolkit.getDefaultToolkit().beep();

    }

    class Sub extends Thread {

        public void run() {
            while (exit) {
                end = System.currentTimeMillis();
                if (TimeUnit.MILLISECONDS.toSeconds(end - start) == 10) {
                    exit = false;
                }
            }
            result.setText("あなたの押した回数は" + c + "回です");
            average.setText("平均回数は" + (c / 10) + "回です");
            label.setText("");

        }
    }
}