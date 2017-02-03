package jp.ac.uryukyu.ie.e165743;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.*;

public class TimerTest1 extends JFrame implements ActionListener{

    JLabel label;
    Timer timer;
    int sec;

    public static void main(String[] args){
        TimerTest1 frame = new TimerTest1();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(10, 10, 300, 200);
        frame.setTitle("タイトル");
        frame.setVisible(true);
    }

    TimerTest1(){
        sec = 1;
        label = new JLabel();

        JPanel labelPanel = new JPanel();
        labelPanel.add(label);

        timer = new Timer(1000 , this);

        getContentPane().add(labelPanel, BorderLayout.CENTER);

        timer.start();
    }

    public void actionPerformed(ActionEvent e){
        label.setText(12-sec + " sec");

        if (sec >= 11){
            timer.stop();
        }else{
            sec++;
        }

    }
}