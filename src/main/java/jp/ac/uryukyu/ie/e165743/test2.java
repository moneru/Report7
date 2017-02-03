package jp.ac.uryukyu.ie.e165743;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.event.*;
/**
 * Created by e165743H on 2017/02/03.
 */
class test2 extends JFrame implements ActionListener  {
    JLabel label;
    int sec;
    Timer timer;

    public static void main(String args[]){
        main Barrage = new main("title");
        Barrage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Barrage.setVisible(true);
    }

    test2(String title){
        setTitle(title);
        setBounds(100, 100, 300, 300);

        JPanel p = new JPanel();
        JButton button1 = new JButton("Lets Barrage!");
        p.add(button1);

        sec = 1;
        label = new JLabel();
        label.setBounds(50, 50, 150, 150);

        JPanel labelPanel = new JPanel();
        labelPanel.add(label);

        timer = new Timer(1000 , this);

        getContentPane().add(labelPanel, BorderLayout.CENTER);

        timer.start();
    }

    public void actionPerformed(ActionEvent e) {
        label.setText(12-sec + " sec");

        if (sec >= 11){
            timer.stop();
        }else{
            sec++;
        }
    }
}
