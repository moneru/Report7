package jp.ac.uryukyu.ie.e165743;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.event.*;

class main extends JFrame implements ActionListener {
    JLabel label;
    Timer timer;
    int sec;

    public static void main(String args[]) {
        main Barrage = new main("title");
        Barrage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Barrage.setVisible(true);

    }

    main(String title) {

        setTitle(title);
        JPanel p = new JPanel();
        setSize(300, 300);
        setLocationRelativeTo(null);

        label = new JLabel("");

        JButton button1 = new JButton("Lets Barrage!");
        button1.addActionListener(this);

        p.add(label);
        p.add(button1);

        getContentPane().add(p);
    }

    public void Timer(){
        sec = 1;
        label = new JLabel("");

        JPanel labelPanel = new JPanel();
        labelPanel.add(label);

        timer = new Timer(1000 , this);

        getContentPane().add(labelPanel, BorderLayout.CENTER);

        timer.start();
    }

    public void actionPerformed(ActionEvent e) {
        label.setText("Start!!");

        label.setText(12-sec + " sec");

        if (sec >= 11){
            timer.stop();
        }else {
            sec++;
        }
    }
}