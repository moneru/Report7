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
    public JLabel timeLabel;
    public boolean counter;
    public int sec;
    public Timer timer;
    public int c;
    public JLabel count;

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


        timeLabel = new JLabel("");
        p.add(timeLabel);
        sec = 1;
        timer = new Timer(1000, main.this);


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
        Sub sub = new Sub();
        Thread th = new Thread(sub);
        if (counter){
            th.start();
        }

        label.setText("Start!!");

        c++;
        count.setText(c);

    }

    class Sub extends Thread {

        public void run() {
            while (true) {
                if(counter){
                    timer.start();
                    counter = false;
                }

                timeLabel.setText(11 - sec + " sec");

                if (sec >= 11) {
                    timer.stop();
                } else {
                    sec++;
                }
            }
        }
    }
}